package com.riwi.filtro.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.filtro.api.dto.request.StudentReq;
import com.riwi.filtro.api.dto.response.StudentBasicResp;
import com.riwi.filtro.api.dto.response.StudentGetResp;
import com.riwi.filtro.infrastructure.services.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/students")
@AllArgsConstructor
public class StudentController {
    @Autowired
    private final StudentService service;

    @Operation(summary = "Lists all students by name in paginated form as long as the student is active.", description = "You must submit the page, the size of the page, and the name by which you want to search for the student.")
    @GetMapping
    public ResponseEntity<Page<Object>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam (defaultValue = "") String name) {
        return ResponseEntity.ok(this.service.getAll(page - 1, size, name));
    }

    @ApiResponse(responseCode = "400", description = "When the id is not valid.", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
    })
    @Operation(summary = "Lists a student by specific id.", description = "You must send the id of the student you wish to list.")
    @GetMapping(path = "/{id}")
    public ResponseEntity<StudentGetResp> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.get(id));
    }

    @Operation(summary = "Create a student.", description = "You must enter the name, description and status of the class.")
    @PostMapping
    public ResponseEntity<StudentBasicResp> create(@Validated @RequestBody StudentReq request){
        return ResponseEntity.ok(this.service.create(request));
    }

    @Operation(summary = "Update a student.", description = "You must enter the student's name, email and the status you wish to update.")
    @PutMapping(path = "/{id}")
    public ResponseEntity<StudentBasicResp> update(
            @PathVariable Long id,
            @Validated @RequestBody StudentReq request) {
        return ResponseEntity.ok(this.service.update(request, id));
    }

    @Operation(summary = "Disables a specific student.", description = "You must enter the id of the student you wish to disable.")
    @PatchMapping(path = "/{id}")
    public ResponseEntity<StudentBasicResp> disable(
        @PathVariable Long id) {
    return ResponseEntity.ok(this.service.disable(id));
    }
}
