package com.giang.repository;

import com.giang.repository.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByHostId(Integer hostId);

    List<Appointment> findAllByRenterId(Integer renterId);

    Appointment findById(Integer id);
}
