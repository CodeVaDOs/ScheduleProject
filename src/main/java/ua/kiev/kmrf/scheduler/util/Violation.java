package ua.kiev.kmrf.scheduler.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Violation {
    private String fieldName;
    private String message;
}
