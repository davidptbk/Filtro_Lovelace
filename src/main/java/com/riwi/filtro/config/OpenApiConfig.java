package com.riwi.filtro.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * Configuracion de swagger
 */
@Configuration
@OpenAPIDefinition(info = @Info(title = "Api to config of class students and lessons of Riwi", version = "1.0", description = "Api documentarion of filter lovelace clan"))
public class OpenApiConfig {

}
