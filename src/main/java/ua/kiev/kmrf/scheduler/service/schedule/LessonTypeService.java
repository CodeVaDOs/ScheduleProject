package ua.kiev.kmrf.scheduler.service.schedule;

import org.springframework.stereotype.Service;
import ua.kiev.kmrf.scheduler.dto.request.schedule.LessonTypeRequest;
import ua.kiev.kmrf.scheduler.dto.response.schedule.LessonTypeResponse;
import ua.kiev.kmrf.scheduler.repository.schedule.LessonTypeRepository;

import java.util.List;

@Service
public class LessonTypeService {
    private LessonTypeRepository lessonTypeRepository;

    public LessonTypeService(LessonTypeRepository lessonTypeRepository) {
        this.lessonTypeRepository = lessonTypeRepository;
    }

    public LessonTypeResponse create(LessonTypeRequest a) {
        return new LessonTypeResponse();
    }

    public LessonTypeResponse update(LessonTypeRequest a) {
        return new LessonTypeResponse();
    }

    public void delete(Long id) {
    }

    public List<LessonTypeResponse> getAll() {
        return null;
    }
}
