package com.riwi.filtro.api.dto.response;

import java.time.LocalDateTime;

import com.riwi.filtro.utils.enums.TypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultimediaBasicResp {
    private Long id;
    private TypeEnum type;
    private String url;
    private LocalDateTime createdAt;
    private Boolean active;
}
