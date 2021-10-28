package ua.kiev.kmrf.scheduler.service.schedule;

import org.springframework.stereotype.Service;
import ua.kiev.kmrf.scheduler.dto.request.schedule.ScheduleRequest;
import ua.kiev.kmrf.scheduler.dto.response.schedule.ScheduleResponse;
import ua.kiev.kmrf.scheduler.entity.schedule.Schedule;
import ua.kiev.kmrf.scheduler.repository.schedule.ScheduleRepository;
import ua.kiev.kmrf.scheduler.service.GeneralService;

import java.util.List;

@Service
public class ScheduleService extends GeneralService<Schedule> {
    private ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }
}
