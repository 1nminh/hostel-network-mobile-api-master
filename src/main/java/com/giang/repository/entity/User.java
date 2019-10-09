package com.giang.repository.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

//    @Column(name = "phone")
//    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "regist_date")
    private LocalDate registDate;

//    @Column(name = "is_admin")
//    private Boolean isAdmin;
//
//    @Column(name = "is_blocked")
//    private Boolean isBlocked;

    @Column(name = "img_avatar")
    private String imgAvatar;

//    @Column(name = "amount")
//    private Double amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public Boolean getAdmin() {
//        return isAdmin;
//    }
//
//    public void setAdmin(Boolean admin) {
//        isAdmin = admin;
//    }

    public LocalDate getRegistDate() {
        return registDate;
    }

    public void setRegistDate(LocalDate registDate) {
        this.registDate = registDate;
    }

//    public Boolean getBlocked() {
//        return isBlocked;
//    }
//
//    public void setBlocked(Boolean blocked) {
//        isBlocked = blocked;
//    }
//
//    public void setAmount(Double amount) {
//        this.amount = amount;
//    }
//
//    public Double getAmount() {
//        return amount;
//    }

    public String getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(String imgAvatar) {
        this.imgAvatar = imgAvatar;
    }
}
