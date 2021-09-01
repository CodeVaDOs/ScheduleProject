package ua.kiev.kmrf.scheduler.service.schedule;

import org.springframework.stereotype.Service;
import ua.kiev.kmrf.scheduler.dto.request.schedule.PairRequest;
import ua.kiev.kmrf.scheduler.dto.response.schedule.PairResponse;
import ua.kiev.kmrf.scheduler.repository.schedule.PairRepository;

import java.util.List;

@Service
public class PairService {
    private PairRepository pairRepository;

    public PairService(PairRepository pairRepository) {
        this.pairRepository = pairRepository;
    }

    public PairResponse create(PairRequest a) {
        return new PairResponse();
    }

    public PairResponse update(PairRequest a) {
        return new PairResponse();
    }

    public void delete(Long id) {
    }

    public List<PairResponse> getAll() {
        return null;
    }
}
