package com.giang.service;

import com.giang.service.dto.AppointmentDTO;

import java.util.List;

public interface AppointmentService {

    List<AppointmentDTO> getAppointmentByRenter(Integer userId);

    List<AppointmentDTO> getAppointmentByHost(Integer userId);

    AppointmentDTO getAppointmentDetail(Integer id);

    AppointmentDTO createAppointment(AppointmentDTO newAppointment);

    AppointmentDTO updateStatus(Integer id, Integer status);

    Boolean deleteAppointment(Integer id);
}

