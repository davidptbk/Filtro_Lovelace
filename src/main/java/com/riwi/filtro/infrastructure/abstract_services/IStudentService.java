package com.riwi.filtro.infrastructure.abstract_services;

import com.riwi.filtro.api.dto.request.StudentReq;
import com.riwi.filtro.api.dto.response.StudentResp;

public interface IStudentService extends CrudService<StudentReq, StudentResp, Long> {
    
}
