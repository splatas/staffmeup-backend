package com.postres.staffing_follower.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_location")
    private int idLocation;

    @NotEmpty
    @Column(name = "ds_location")
    private String dsLocation;

    @NotNull
    @Column(name = "enable_location")
    private Integer enableLocation;

    public Location() {
    }

    public Location(int idLocation, @NotEmpty String dsLocation, @NotNull Integer enableLocation) {
        this.idLocation = idLocation;
        this.dsLocation = dsLocation;
        this.enableLocation = enableLocation;
    }

    public int getIdLocation() {
        return idLocation;
    }


    public String getDsLocation() {
        return dsLocation;
    }

    public void setDsLocation(String dsLocation) {
        this.dsLocation = dsLocation;
    }

    public Integer getEnableLocation() {
        return enableLocation;
    }

    public void setEnableLocation(Integer enableLocation) {
        this.enableLocation = enableLocation;
    }
}
