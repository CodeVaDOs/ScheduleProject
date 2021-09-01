package ua.kiev.kmrf.scheduler.service.schedule;

import org.springframework.stereotype.Service;
import ua.kiev.kmrf.scheduler.dto.request.schedule.ScheduleRequest;
import ua.kiev.kmrf.scheduler.dto.response.schedule.ScheduleResponse;
import ua.kiev.kmrf.scheduler.repository.schedule.ScheduleRepository;

import java.util.List;

@Service
public class ScheduleService {
    private ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponse create(ScheduleRequest a) {
        return new ScheduleResponse();
    }

    public ScheduleResponse update(ScheduleRequest a) {
        return new ScheduleResponse();
    }

    public void delete(Long id) {
    }

    public List<ScheduleResponse> getAll() {
        return null;
    }
}
