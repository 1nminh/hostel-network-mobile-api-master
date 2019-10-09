package com.giang.service.dto;

import java.io.Serializable;

public class BenefitDTO implements Serializable {
    private Integer id;

    private String benefitName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBenefitName() {
        return benefitName;
    }

    public void setBenefitName(String benefitName) {
        this.benefitName = benefitName;
    }
}
