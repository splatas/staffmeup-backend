package com.postres.staffing_follower.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_position")
    private int idPosition;

    @NotEmpty
    @Column(name = "ds_position")
    private String dsPosition;

    @NotNull
    @Column(name = "enable_position")
    private Integer enablePosition;

    public Position() {
    }

    public Position(int idPosition, @NotEmpty String dsPosition, @NotNull Integer enablePosition) {
        this.idPosition = idPosition;
        this.dsPosition = dsPosition;
        this.enablePosition = enablePosition;
    }

    public int getIdPosition() {
        return idPosition;
    }


    public String getDsPosition() {
        return dsPosition;
    }

    public void setDsPosition(String dsPosition) {
        this.dsPosition = dsPosition;
    }

    public Integer getEnablePosition() {
        return enablePosition;
    }

    public void setEnablePosition(Integer enablePosition) {
        this.enablePosition = enablePosition;
    }
}
