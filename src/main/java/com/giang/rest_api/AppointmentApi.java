package com.giang.rest_api;


import com.giang.service.dto.AppointmentDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RequestMapping("/appointments")
public interface AppointmentApi {

    @ApiOperation(tags = {"APPOINTMENT"}, value = "Get all appointments of an user")
    @GetMapping("")
    ResponseEntity<List<AppointmentDTO>> getAppointmentByUser(@RequestParam("userId") Integer userId,
                                                              @RequestParam(value = "created", required = false) Boolean created);

//    @ApiOperation(tags = {"APPOINTMENT"}, value = "Get all your appointments")
//    @GetMapping("/hosts")
//    ResponseEntity<List<AppointmentDTO>> getAppointmentByHost(@RequestParam("userId") Integer userId);

    @ApiOperation(tags = {"APPOINTMENT"}, value = "Get an appointment detail")
    @GetMapping("/{id}")
    ResponseEntity<AppointmentDTO> getAppointmentDetail(@PathVariable("id") Integer id);

    @ApiOperation(tags = {"APPOINTMENT"}, value = "Create an appointment")
    @PostMapping("")
    ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO newAppointment);

    @ApiOperation(tags = {"APPOINTMENT"}, value = "Update status of an appointment")
    @PutMapping("/{id}")
    ResponseEntity<AppointmentDTO> updateStatus(@PathVariable("id") Integer id,
                                                @RequestParam Integer status);

    @ApiOperation(tags = {"APPOINTMENT"}, value = "Delete an appointment")
    @DeleteMapping("/{id}")
    ResponseEntity<Boolean> deleteAppointment(@PathVariable("id") Integer id);
}
