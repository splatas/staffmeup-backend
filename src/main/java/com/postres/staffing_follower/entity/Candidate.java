package com.postres.staffing_follower.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_candidate")
    private Long idCandidate;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_ticket", foreignKey = @ForeignKey(name = "FK_CANDIDATE_TICKET"))
    private Ticket ticket;


    @Column(name = "interview")
    private String interview;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_onboarding", foreignKey = @ForeignKey(name = "FK_CANDIDATE_ONBOARDING"))
    private Onboarding onboarding;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_priority", foreignKey = @ForeignKey(name = "FK_CANDIDATE_PRIORITY"))
    private Priority priority;

    //private Integer aging;  // TODO se calcula on demand

    @Column
    private String comment;


    @Column(name = "real_attibute")
    private String realAttibute;

    //private String comment;  // TODO va en el historico

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_candidate_status", foreignKey = @ForeignKey(name = "FK_CANDIDATE_CANDIDATESTATUS"))
    private CandidateStatus candidateStatus;


    @Column(name = "main_area")
    private String mainArea;

    @Column(name = "project")
    private String project;




    @Column(name = "real_attribute")
    private String realAttribute;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_seniority", foreignKey = @ForeignKey(name = "FK_CANDIDATE_SENIORITY"))
    private Seniority level;


    public Candidate() {
    }

    public Candidate(Long idCandidate, @NotEmpty String name, Ticket ticket, String interview, Onboarding onboarding, Priority priority, String comment, String realAttibute, CandidateStatus candidateStatus, String mainArea, String project, String realAttribute, Seniority level) {
        this.idCandidate = idCandidate;
        this.name = name;
        this.ticket = ticket;
        this.interview = interview;
        this.onboarding = onboarding;
        this.priority = priority;
        this.comment = comment;
        this.realAttibute = realAttibute;
        this.candidateStatus = candidateStatus;
        this.mainArea = mainArea;
        this.project = project;
        this.realAttribute = realAttribute;
        this.level = level;
    }

    public Long getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(Long idCandidate) {
        this.idCandidate = idCandidate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getInterview() {
        return interview;
    }

    public void setInterview(String interview) {
        this.interview = interview;
    }

    public Onboarding getOnboarding() {
        return onboarding;
    }

    public void setOnboarding(Onboarding onboarding) {
        this.onboarding = onboarding;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getRealAttibute() {
        return realAttibute;
    }

    public void setRealAttibute(String realAttibute) {
        this.realAttibute = realAttibute;
    }

    public CandidateStatus getCandidateStatus() {
        return candidateStatus;
    }

    public void setCandidateStatus(CandidateStatus candidateStatus) {
        this.candidateStatus = candidateStatus;
    }

    public String getMainArea() {
        return mainArea;
    }

    public void setMainArea(String mainArea) {
        this.mainArea = mainArea;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Seniority getLevel() {
        return level;
    }

    public void setLevel(Seniority level) {
        this.level = level;
    }

    public String getComment() { return comment; }

    public void setComment(String comment) { this.comment = comment; }
}
