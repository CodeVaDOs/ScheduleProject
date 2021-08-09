package ua.kiev.kmrf.scheduler.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.kiev.kmrf.scheduler.dto.request.RequestUser;
import ua.kiev.kmrf.scheduler.entity.refreshToken.RefreshToken;
import ua.kiev.kmrf.scheduler.entity.user.User;
import ua.kiev.kmrf.scheduler.exception.JwtAuthenticationException;
import ua.kiev.kmrf.scheduler.exception.NoDataFoundException;
import ua.kiev.kmrf.scheduler.exception.UserAlreadyExistException;
import ua.kiev.kmrf.scheduler.repository.RefreshTokenRepository;
import ua.kiev.kmrf.scheduler.repository.UserRepository;
import ua.kiev.kmrf.scheduler.security.JwtTokenProvider;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.expirationRefresh}")
    private long validityRefreshToken;

    public AuthService(AuthenticationManager authenticationManager, UserRepository userRepository, JwtTokenProvider jwtTokenProvider, RefreshTokenRepository refreshTokenRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.refreshTokenRepository = refreshTokenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RefreshToken readRefreshToken(Long id) {
        return refreshTokenRepository.findById(id).orElseThrow(() -> new JwtAuthenticationException("refreshToken not found", HttpStatus.FORBIDDEN));
    }

    public RefreshToken createRefreshToken(User user) {
        return refreshTokenRepository.save(new RefreshToken(validityRefreshToken, user));
    }

    public void markUsed(Long id) {
        refreshTokenRepository.findById(id)
                .map(t -> {
                    t.setIsUsed(true);
                    return refreshTokenRepository.save(t);
                })
                .orElseThrow(() -> new NoDataFoundException("refreshToken", id));
    }

    public Map<Object, Object> createTokens(User u) {
        String token = jwtTokenProvider.createToken(u.getEmail(), u.getRole().name(), u.getId());

        RefreshToken createdRefreshToken = this.createRefreshToken(u);
        String refreshToken = jwtTokenProvider.createRefreshToken(createdRefreshToken.getId());

        Map<Object, Object> tokens = new HashMap<>();
        tokens.put("userId", u.getId());
        tokens.put("token", token);
        tokens.put("refreshToken", refreshToken);
        return tokens;
    }

    public Map<Object, Object> authenticate(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NoDataFoundException("User doesn't exists"));
        return createTokens(user);
    }

    public Map<Object, Object> register(RequestUser requestUser) {
        if (userRepository.findByEmail(requestUser.getEmail()).isPresent()) {
            throw new UserAlreadyExistException(requestUser.getEmail());
        }

        User user = userRepository.save(requestUser.toEntity());
        return createTokens(user);
    }

    public Map<Object, Object> refresh(String refreshToken) {
        Long refreshTokenId = jwtTokenProvider.getRefreshTokenId(refreshToken);
        RefreshToken rt = readRefreshToken(refreshTokenId);

        if (rt.getExpirationDate().before(new Date()) || rt.getIsUsed()) {
            throw new JwtAuthenticationException("refreshToken is expired", HttpStatus.UNAUTHORIZED);
        } else {
            markUsed(refreshTokenId);
            User user = userRepository.findById(rt.getUser().getId()).orElseThrow(() -> new NoDataFoundException("User doesn't exists"));
            return createTokens(user);
        }
    }
}