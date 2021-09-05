package ua.kiev.kmrf.scheduler.service;

import org.springframework.stereotype.Service;
import ua.kiev.kmrf.scheduler.entity.user.User;
import ua.kiev.kmrf.scheduler.exception.NoDataFoundException;
import ua.kiev.kmrf.scheduler.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NoDataFoundException("User doesn't exist"));
    }
}
