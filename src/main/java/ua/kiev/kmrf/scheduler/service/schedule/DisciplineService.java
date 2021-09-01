package ua.kiev.kmrf.scheduler.service.schedule;

import org.springframework.stereotype.Service;
import ua.kiev.kmrf.scheduler.dto.request.schedule.DisciplineRequest;
import ua.kiev.kmrf.scheduler.dto.response.schedule.DisciplineResponse;
import ua.kiev.kmrf.scheduler.repository.schedule.DisciplineRepository;

import java.util.List;

@Service
public class DisciplineService {
    private DisciplineRepository disciplineRepository;

    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public DisciplineResponse create(DisciplineRequest a) {
        return new DisciplineResponse();
    }

    public DisciplineResponse update(DisciplineRequest a) {
        return new DisciplineResponse();
    }

    public void delete(Long id) {
    }

    public List<DisciplineResponse> getAll() {
        return null;
    }
}
