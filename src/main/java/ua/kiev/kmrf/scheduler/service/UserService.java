package ua.kiev.kmrf.scheduler.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kiev.kmrf.scheduler.dto.response.ResponseUser;
import ua.kiev.kmrf.scheduler.entity.user.User;
import ua.kiev.kmrf.scheduler.exception.NoDataFoundException;
import ua.kiev.kmrf.scheduler.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseUser getProfile(String email) {
        return new ResponseUser(getUserByEmail(email));
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NoDataFoundException("User doesn't exist"));
    }
}
