package com.giang.rest_api.impl;

import com.giang.rest_api.TypeApi;
import com.giang.service.TypeService;
import com.giang.service.dto.TypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeController implements TypeApi {

    @Autowired
    TypeService typeService;

    @Override
    public ResponseEntity<List<TypeDTO>> getAll() {
        return ResponseEntity.ok(typeService.getAll());
    }
}
