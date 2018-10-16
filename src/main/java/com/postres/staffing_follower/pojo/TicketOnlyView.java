package com.postres.staffing_follower.pojo;

import java.util.Date;

public class TicketOnlyView {

    private Long idTicket;
    private String project;
    private String description;
    private String profile;
    private String seniority;
    private String position;
    private Date createdOn;
    private Date startDate;
    private String location;
    private String status;


    public TicketOnlyView() {
    }

    public TicketOnlyView(Long idTicket, String project, String description, String profile, String seniority, String position, Date createdOn, Date startDate, String location, String status) {
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

}
