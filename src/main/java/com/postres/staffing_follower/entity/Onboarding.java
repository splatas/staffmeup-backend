package com.postres.staffing_follower.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "onboarding")
public class Onboarding {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_onboarding")
    private Long idOnboarding;

    @NotEmpty
    @Column(name = "ds_onboarding")
    private String dsOnboarding;

    @NotNull
    @Column(name = "enable_onboarding")
    private Integer enableOnboarding;


    public Onboarding() {
    }

    public Onboarding(Long idOnboarding, @NotEmpty String dsOnboarding, @NotNull Integer enableOnboarding) {
        this.idOnboarding = idOnboarding;
        this.dsOnboarding = dsOnboarding;
        this.enableOnboarding = enableOnboarding;
    }


    public Long getIdOnboarding() {
        return idOnboarding;
    }

    public void setIdOnboarding(Long idOnboarding) {
        this.idOnboarding = idOnboarding;
    }

    public String getDsOnboarding() {
        return dsOnboarding;
    }

    public void setDsOnboarding(String dsOnboarding) {
        this.dsOnboarding = dsOnboarding;
    }

    public Integer getEnableOnboarding() {
        return enableOnboarding;
    }

    public void setEnableOnboarding(Integer enableOnboarding) {
        this.enableOnboarding = enableOnboarding;
    }

}