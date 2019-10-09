package com.giang.rest_api;

import com.giang.service.dto.TypeDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@RequestMapping("/types")
public interface TypeApi {

    @ApiOperation(tags = "TYPE", value = "Get all type")
    @GetMapping("")
    ResponseEntity<List<TypeDTO>> getAll();
}
