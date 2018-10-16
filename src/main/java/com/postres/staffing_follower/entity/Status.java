package com.postres.staffing_follower.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_status")
    private Long idStatus;

    @Column(name="ds_status")
    @NotEmpty
    private String dsStatus;

    @Column(name="enable_status")
    @NotNull
    private Integer enableStatus;

    public Status(Long idStatus, @NotEmpty String dsStatus, @NotNull Integer enableStatus) {
        this.idStatus = idStatus;
        this.dsStatus = dsStatus;
        this.enableStatus = enableStatus;
    }

    public Long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Long idStatus) {
        this.idStatus = idStatus;
    }

    public String getDsStatus() {
        return dsStatus;
    }

    public void setDsStatus(String dsStatus) {
        this.dsStatus = dsStatus;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Status() {
    }
}
