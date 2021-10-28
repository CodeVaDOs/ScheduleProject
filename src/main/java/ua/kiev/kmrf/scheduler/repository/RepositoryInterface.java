package ua.kiev.kmrf.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kiev.kmrf.scheduler.entity.BaseEntity;
import ua.kiev.kmrf.scheduler.exception.NoDataFoundException;

import java.util.Optional;

public interface RepositoryInterface<E extends BaseEntity> extends JpaRepository<E, Long> {
    default E findEntityById(Long id) {
        Optional<E> entityOptional = findById(id);
        if (!entityOptional.isPresent()) {
            String msg = String.format("An error occurred while trying to find entity with id %d. ", id);
            throw new NoDataFoundException(msg);
        }
        return entityOptional.get();
    }
}
