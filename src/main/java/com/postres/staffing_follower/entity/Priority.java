package com.postres.staffing_follower.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "priority")
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_priority")
    private Long idPriority;

    @NotEmpty
    @Column(name = "ds_priority")
    private String dsPriority;

    @NotNull
    @Column(name = "enable_priority")
    private Integer enablePriority;


    public Priority() {
    }

    public Priority(Long idPriority, @NotEmpty String dsPriority, @NotNull Integer enablePriority) {
        this.idPriority = idPriority;
        this.dsPriority = dsPriority;
        this.enablePriority = enablePriority;
    }


    public Long getIdPriority() {
        return idPriority;
    }

    public void setIdPriority(Long idPriority) {
        this.idPriority = idPriority;
    }

    public String getDsPriority() {
        return dsPriority;
    }

    public void setDsPriority(String dsPriority) {
        this.dsPriority = dsPriority;
    }

    public Integer getEnablePriority() {
        return enablePriority;
    }

    public void setEnablePriority(Integer enablePriority) {
        this.enablePriority = enablePriority;
    }

}