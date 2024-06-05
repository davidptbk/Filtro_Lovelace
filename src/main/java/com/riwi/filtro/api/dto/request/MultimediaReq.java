package com.riwi.filtro.api.dto.request;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.riwi.filtro.utils.enums.TypeEnum;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultimediaReq {
    @NotNull(message = "The multimedia type is required")
    private TypeEnum type;
    @NotBlank(message = "The url multimedia is required")
    private String url;

    @NotNull(message = "the lesson id in multimedia is required")
    private Long lesson_id;
    @NotNull(message = "El estado de la clase es requerido.")
    private Boolean active;
}
