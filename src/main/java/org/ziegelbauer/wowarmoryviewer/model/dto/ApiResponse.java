package org.ziegelbauer.wowarmoryviewer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ApiResponse {
    private boolean status;
    private Object payload;
}
