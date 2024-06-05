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
public class ClassToStudentResp {
    private long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private Boolean active;
    private List<LessonToClassResp> lessons;
}
