package com.riwi.filtro.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassGetResp {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime created_at;
    private Boolean active;
    private List<StudentBasicResp> students;
}
