package com.riwi.filtro.api.dto.request;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
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
public class StudentReq {
    @NotBlank(message = "The name student is required")
    private String name;
    @NotBlank(message = "The email is required")
    @Email(message = "The email must be a valid email [example@example.com]")
    private String email;

    @NotNull(message = "The state student is required")
    private Boolean active;
    @NotNull(message = "The class id in student is required")
    private Long class_id;
}
