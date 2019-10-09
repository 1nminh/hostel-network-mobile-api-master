package com.giang.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AppointmentDTO implements Serializable {
    private Integer id;

    private Integer renterId;

    private Integer hostId;

    private Integer postId;

    private String addressAppointment;

    private UserDTO userInfor;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime time;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createDate;

    private Integer status;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRenterId() {
        return renterId;
    }

    public void setRenterId(Integer renterId) {
        this.renterId = renterId;
    }

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getAddressAppointment() {
        return addressAppointment;
    }

    public void setAddressAppointment(String addressAppointment) {
        this.addressAppointment = addressAppointment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserDTO getUserInfor() {
        return userInfor;
    }

    public void setUserInfor(UserDTO userInfor) {
        this.userInfor = userInfor;
    }
}
