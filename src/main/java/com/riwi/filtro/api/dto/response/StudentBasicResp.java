package com.riwi.filtro.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentBasicResp {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private Boolean active;
}
