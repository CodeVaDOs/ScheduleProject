package ua.kiev.kmrf.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.kmrf.scheduler.entity.user.User;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends RepositoryInterface<User> {
    Optional<User> findByEmail(String email);

    List<User> getUsersByBirthdayBetween(Date d1, Date d2);

    List<User> getAllByGroup_id(Long id);
}
