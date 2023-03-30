package org.ziegelbauer.wowarmoryviewer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private boolean status;
    private Object payload;
}
