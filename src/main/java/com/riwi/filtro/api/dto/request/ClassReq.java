package com.riwi.filtro.api.dto.request;


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
public class ClassReq {
    @NotBlank(message = "The class name is required")
    private String name;

    @NotBlank(message = "The description class is required")
    private String description;

    @NotNull(message = "El estado de la clase es requerido.")
    private Boolean active;
}
