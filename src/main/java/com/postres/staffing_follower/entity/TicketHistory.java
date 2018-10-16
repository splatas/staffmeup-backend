package com.postres.staffing_follower.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "ticket_history")
public class TicketHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ticket_history")
    private Long idTicketHistory;

    @NotNull
    @Column(name = "id_ticket")
    private Long idTicket;

    @NotEmpty
    @Column(name = "project")
    private String project;

    @Column(name = "description")
    private String description;

    @NotEmpty
    @Column(name = "profile")
    private String profile;

    @Column(name = "seniority")
    private String seniority;

    @Column(name = "position")
    private String position;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "location")
    private String location;

    @Column(name = "status")
    private String status;

    @NotNull
    @Column(name = "update_date")
    private Date updateDate;


    public TicketHistory() {
    }

    public TicketHistory(Long idTicketHistory, Long idTicket, @NotEmpty String project, String description,  String profile, String seniority, String position,  Date createdOn, Date startDate, String location,  String status, @NotNull Date updateDate) {
        this.idTicketHistory = idTicketHistory;
        this.idTicket = idTicket;
        this.project = project;
        this.description = description;
        this.profile = profile;
        this.seniority = seniority;
        this.position = position;
        this.createdOn = createdOn;
        this.startDate = startDate;
        this.location = location;
        this.status = status;
        this.updateDate = updateDate;
    }


    public Long getIdTicketHistory() {
        return idTicketHistory;
    }
    public void setIdTicketHistory(Long idTicketHistory) {
        this.idTicketHistory = idTicketHistory;
    }
    public Long getIdTicket() {
        return idTicket;
    }
    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }
    public String getProject() {
        return project;
    }
    public void setProject(String project) {
        this.project = project;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }
    public String getSeniority() {
        return seniority;
    }
    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public Date getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}

