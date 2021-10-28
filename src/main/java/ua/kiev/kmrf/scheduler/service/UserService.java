package ua.kiev.kmrf.scheduler.service;

import org.springframework.stereotype.Service;
import ua.kiev.kmrf.scheduler.entity.user.User;
import ua.kiev.kmrf.scheduler.exception.NoDataFoundException;
import ua.kiev.kmrf.scheduler.repository.UserRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;

@Service
public class UserService extends GeneralService<User> {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NoDataFoundException("User doesn't exist"));
    }

    public List<User> getUsersByBirthdayBetween(String d1, String d2) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date parseD1 = formatter.parse(d1);
        Date parsed2 = formatter.parse(d2);
        return userRepository.getUsersByBirthdayBetween(parseD1, parsed2);
    }

    public List<User> getUsersByGroup(Long id) {
        return userRepository.getAllByGroup_id(id);
    }
}
