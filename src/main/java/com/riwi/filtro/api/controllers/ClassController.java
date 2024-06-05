package com.riwi.filtro.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.filtro.api.dto.request.ClassReq;
import com.riwi.filtro.api.dto.response.ClassBasicResp;
import com.riwi.filtro.api.dto.response.ClassGetResp;
import com.riwi.filtro.infrastructure.services.ClassService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/class")
@AllArgsConstructor
public class ClassController {
    @Autowired
    private final ClassService service;
@Operation(summary = "List all class for name or description paginated with condition the class is active.", description = "You must submit the page, the size of the page, and the name or description by which you want to search for the class.")
    @GetMapping
    public ResponseEntity<Page<Object>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam (defaultValue = "") String name,
            @RequestParam (defaultValue = "") String description) {
        return ResponseEntity.ok(this.service.getAll(page - 1, size, name, description));
    }

    @ApiResponse(responseCode = "400", description = "When the id is invalid.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(summary = "Lists a class by specific id.", description = "You must send the id of the class you want to list.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<ClassGetResp> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.get(id));
    }

    @Operation(summary = "Create a class", description = "You must send the name, the description and the state of class.")
    @PostMapping
    public ResponseEntity<ClassBasicResp> create(@Validated @RequestBody ClassReq request){
        return ResponseEntity.ok(this.service.create(request));
    }

}
