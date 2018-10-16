package com.postres.staffing_follower.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "seniority")
public class Seniority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_seniority")
    private int idSeniority;

    @NotNull
    @Column(name = "level")
    private Integer level;

    @NotEmpty
    @Column(name = "ds_seniority")
    private String dsSeniority;

    @NotNull
    @Column(name = "enable_seniority")
    private Integer enableSeniority;

    public Seniority() {

    }

    public Seniority(int idSeniority, @NotNull Integer level, @NotEmpty String dsSeniority, @NotNull Integer enableSeniority) {
        this.idSeniority = idSeniority;
        this.level = level;
        this.dsSeniority = dsSeniority;
        this.enableSeniority = enableSeniority;
    }

    public int getIdSeniority() {
        return idSeniority;
    }


    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDsSeniority() {
        return dsSeniority;
    }

    public void setDsSeniority(String dsSeniority) {
        this.dsSeniority = dsSeniority;
    }

    public Integer getEnableSeniority() {
        return enableSeniority;
    }

    public void setEnableSeniority(Integer enableSeniority) {
        this.enableSeniority = enableSeniority;
    }
}
