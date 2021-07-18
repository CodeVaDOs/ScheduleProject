package ua.kiev.kmrf.scheduler.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ua.kiev.kmrf.scheduler.entity.user.User;
import ua.kiev.kmrf.scheduler.exception.NoDataFoundException;
import ua.kiev.kmrf.scheduler.repository.UserRepository;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() ->
            new NoDataFoundException(String.format("User with email %s doesn't exists", email))
        );
        return SecurityUser.fromUser(user);
    }
}