package ua.kiev.kmrf.scheduler.service.schedule;

import org.springframework.stereotype.Service;
import ua.kiev.kmrf.scheduler.dto.request.schedule.LessonTypeRequest;
import ua.kiev.kmrf.scheduler.dto.response.schedule.LessonTypeResponse;
import ua.kiev.kmrf.scheduler.entity.schedule.LessonType;
import ua.kiev.kmrf.scheduler.repository.schedule.LessonTypeRepository;
import ua.kiev.kmrf.scheduler.service.GeneralService;

import java.util.List;

@Service
public class LessonTypeService extends GeneralService<LessonType> {
    private LessonTypeRepository lessonTypeRepository;

    public LessonTypeService(LessonTypeRepository lessonTypeRepository) {
        this.lessonTypeRepository = lessonTypeRepository;
    }
}
