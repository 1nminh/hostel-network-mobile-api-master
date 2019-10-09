package com.giang.service.impl;

import com.giang.repository.AppointmentRepository;
import com.giang.repository.UserRepository;
import com.giang.repository.entity.Appointment;
import com.giang.service.AppointmentService;
import com.giang.service.dto.AppointmentDTO;
import com.giang.service.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AppointmentServiceimpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    private final UserRepository userRepository;

    public AppointmentServiceimpl(AppointmentRepository appointmentRepository, UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<AppointmentDTO> getAppointmentByRenter(Integer userId) {
        return appointmentRepository.findAllByRenterId(userId).stream().map((Appointment entity) -> mapToDtoWithUserInfor(entity, entity.getHostId())).collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> getAppointmentByHost(Integer userId) {
        return appointmentRepository.findAllByHostId(userId).stream().map((Appointment entity) -> mapToDtoWithUserInfor(entity, entity.getRenterId())).collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO getAppointmentDetail(Integer id) {
        return mapToDto(appointmentRepository.findById(id));
    }

    @Override
    public AppointmentDTO createAppointment(AppointmentDTO newAppointment) {
        Appointment appointment = mapToEntity(newAppointment);
        appointment = appointmentRepository.saveAndFlush(appointment);

        return mapToDto(appointment);
    }

    @Override
    public AppointmentDTO updateStatus(Integer id, Integer status) {
        Appointment appointment = appointmentRepository.findById(id);
        Optional.ofNullable(appointment).orElseThrow(EntityNotFoundException::new);

        appointment.setStatus(status);
        appointment = appointmentRepository.saveAndFlush(appointment);
        return mapToDto(appointment);
    }

    @Override
    public Boolean deleteAppointment(Integer id) {
        Appointment appointment = appointmentRepository.findById(id);
        Optional.ofNullable(appointment).orElseThrow(EntityNotFoundException::new);

        appointmentRepository.delete(appointment);
        return true;
    }

    private AppointmentDTO mapToDto(Appointment entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, AppointmentDTO.class);
    }

    private Appointment mapToEntity(AppointmentDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Appointment.class);
    }

    private AppointmentDTO mapToDtoWithUserInfor(Appointment entity, Integer userId) {
        ModelMapper modelMapper = new ModelMapper();
        AppointmentDTO result =  modelMapper.map(entity, AppointmentDTO.class);
        result.setUserInfor(modelMapper.map(userRepository.findById(userId), UserDTO.class));
        return result;
    }
}
