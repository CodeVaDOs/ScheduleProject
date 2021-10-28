package ua.kiev.kmrf.scheduler.service.schedule;

import org.springframework.stereotype.Service;
import ua.kiev.kmrf.scheduler.dto.request.schedule.DisciplineRequest;
import ua.kiev.kmrf.scheduler.dto.response.schedule.DisciplineResponse;
import ua.kiev.kmrf.scheduler.entity.schedule.Discipline;
import ua.kiev.kmrf.scheduler.repository.schedule.DisciplineRepository;
import ua.kiev.kmrf.scheduler.service.GeneralService;

import java.util.List;

@Service
public class DisciplineService extends GeneralService<Discipline> {
    private DisciplineRepository disciplineRepository;

    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }
}
