package com.postres.staffing_follower.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_profile")
    private Long idProfile;

    @Column(name="ds_profile")
    @NotEmpty
    private String dsProfile;

    @Column(name="enable_profile")
    @NotNull
    private Integer enableProfile;


    public Profile(Long idProfile, @NotEmpty String dsProfile, @NotNull Integer enableProfile) {
        this.idProfile = idProfile;
        this.dsProfile = dsProfile;
        this.enableProfile = enableProfile;
    }

    public Profile() {
    }

    public Long getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Long idProfile) {
        this.idProfile = idProfile;
    }

    public String getDsProfile() {
        return dsProfile;
    }

    public void setDsProfile(String dsProfile) {
        this.dsProfile = dsProfile;
    }

    public Integer getEnableProfile() {
        return enableProfile;
    }

    public void setEnableProfile(Integer enableProfile) {
        this.enableProfile = enableProfile;
    }
}
