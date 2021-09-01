package ua.kiev.kmrf.scheduler.service.schedule;

import org.springframework.stereotype.Service;
import ua.kiev.kmrf.scheduler.dto.request.schedule.AudienceRequest;
import ua.kiev.kmrf.scheduler.dto.response.schedule.AudienceResponse;
import ua.kiev.kmrf.scheduler.entity.schedule.Audience;
import ua.kiev.kmrf.scheduler.repository.schedule.AudienceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AudienceService {
    private AudienceRepository audienceRepository;

    public AudienceService(AudienceRepository audienceRepository) {
        this.audienceRepository = audienceRepository;
    }

    public AudienceResponse create(AudienceRequest a) {
        return new AudienceResponse();
    }

    public AudienceResponse update(AudienceRequest a) {
        return new AudienceResponse();
    }

    public void delete(Long id) {
    }

    public List<AudienceResponse> getAll() {
        return null;
    }
}
