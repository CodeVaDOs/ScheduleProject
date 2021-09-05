package ua.kiev.kmrf.scheduler.dto.response.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import ua.kiev.kmrf.scheduler.util.Violation;

import java.util.List;

@Data
@AllArgsConstructor
public class ValidationErrorResponse {
    private List<Violation> violations;
}