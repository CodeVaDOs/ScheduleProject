package ua.kiev.kmrf.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.kmrf.scheduler.entity.refreshToken.RefreshToken;

import java.util.Date;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    void deleteByExpirationDateBefore(Date date);
}