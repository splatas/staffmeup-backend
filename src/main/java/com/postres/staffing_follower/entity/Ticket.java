package com.postres.staffing_follower.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @NotNull
    @Column(name = "id_ticket")
    private Long idTicket;

    @NotEmpty
    @Column(name = "project")
    private String project;


    @Column(name = "description")
    private String description;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_profile", foreignKey = @ForeignKey(name = "FK_TICKET_PROFILE"))
    private Profile profile;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_seniority", foreignKey = @ForeignKey(name = "FK_TICKET_SENIORITY"))
    private Seniority seniority;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_position", foreignKey = @ForeignKey(name = "FK_TICKET_POSITION"))
    private Position position;


    @Column(name = "created_on")
    private Date createdOn;


    @Column(name = "start_date")
    private Date startDate;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_location", foreignKey = @ForeignKey(name = "FK_TICKET_LOCATION"))
    private Location location;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_status", foreignKey = @ForeignKey(name = "FK_TICKET_STATUS"))
    private Status status;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "ticket")
    private List<Candidate> candidates;


    public Ticket() {
    }

    public Ticket(Long idTicket, @NotEmpty String project, String description, Profile profile, Seniority seniority, Position position, Date createdOn, Date startDate, Location location, Status status, List<Candidate> candidates) {
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
        this.candidates = candidates;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Seniority getSeniority() {
        return seniority;
    }

    public void setSeniority(Seniority seniority) {
        this.seniority = seniority;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

}
