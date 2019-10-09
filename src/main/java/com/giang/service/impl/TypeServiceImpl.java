package com.giang.service.impl;

import com.giang.repository.TypeRepository;
import com.giang.repository.entity.Type;
import com.giang.service.TypeService;
import com.giang.service.dto.TypeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<TypeDTO> getAll() {
        return typeRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private TypeDTO mapToDto(Type entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, TypeDTO.class);
    }

}
