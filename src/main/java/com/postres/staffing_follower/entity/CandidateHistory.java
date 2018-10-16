package com.postres.staffing_follower.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "candidate_history")
public class CandidateHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_candidate_history")
    private Long idCandidateHistory;

    @NotNull
    @Column(name = "id_candidate")
    private Long idCandidate;

    @NotEmpty
    @Column(name = "nombre")
    private String nombre;

    @NotEmpty
    @Column(name = "ticket")
    private String ticket;


    @Column(name = "interview")
    private String interview;


    @Column(name = "onboarding")
    private String onboarding;


    @Column(name = "priority")
    private String priority;

    //private Integer aging;  // TODO se calcula on demand

    @Column(name = "real_attibute")
    private String realAttibute;

    @Column(name = "comment")
    private String comment;


    @Column(name = "candidateStatus")
    private String candidateStatus;


    @Column(name = "main_area")
    private String mainArea;

    @Column(name = "project")
    private String project;

    @Column(name = "level")
    private Integer level;

    @NotNull
    @Column(name = "update_date")
    private Date updateDate;


    public CandidateHistory() {
    }

    public CandidateHistory(Long idCandidateHistory, @NotNull Long idCandidate, @NotEmpty String nombre, @NotEmpty String ticket, String interview, String onboarding, String priority, String realAttribute, String comment, String candidateStatus, String mainArea, String project, Integer level, @NotNull Date updateDate) {
        this.idCandidateHistory = idCandidateHistory;
        this.idCandidate = idCandidate;
        this.nombre = nombre;
        this.ticket = ticket;
        this.interview = interview;
        this.onboarding = onboarding;
        this.priority = priority;
        this.realAttibute = realAttibute;
        this.comment = comment;
        this.candidateStatus = candidateStatus;
        this.mainArea = mainArea;
        this.project = project;
        this.level = level;
        this.updateDate = updateDate;


    }


    public Long getIdCandidateHistory() {
        return idCandidateHistory;
    }

    public void setIdCandidateHistory(Long idCandidateHistory) {
        this.idCandidateHistory = idCandidateHistory;
    }

    public Long getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(Long idCandidate) {
        this.idCandidate = idCandidate;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getInterview() {
        return interview;
    }

    public void setInterview(String interview) {
        this.interview = interview;
    }

    public String getOnboarding() {
        return onboarding;
    }

    public void setOnboarding(String onboarding) {
        this.onboarding = onboarding;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRealAttibute() {
        return realAttibute;
    }

    public void setRealAttibute(String realAttibute) {
        this.realAttibute = realAttibute;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCandidateStatus() {
        return candidateStatus;
    }

    public void setCandidateStatus(String candidateStatus) {
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
