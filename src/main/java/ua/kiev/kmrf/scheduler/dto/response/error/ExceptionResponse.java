package ua.kiev.kmrf.scheduler.dto.response.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    public String message;
}