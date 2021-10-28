package ua.kiev.kmrf.scheduler.service.schedule;

import org.springframework.stereotype.Service;
import ua.kiev.kmrf.scheduler.dto.request.schedule.PairRequest;
import ua.kiev.kmrf.scheduler.dto.response.schedule.PairResponse;
import ua.kiev.kmrf.scheduler.entity.schedule.Pair;
import ua.kiev.kmrf.scheduler.repository.schedule.PairRepository;
import ua.kiev.kmrf.scheduler.service.GeneralService;

import java.util.List;

@Service
public class PairService extends GeneralService<Pair> {
    private PairRepository pairRepository;


    public PairService(PairRepository pairRepository) {
        this.pairRepository = pairRepository;
    }
}
