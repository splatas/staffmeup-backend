package com.postres.staffing_follower.entity;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

@Record
public class TicketCandidate {
    @Field(at=0)
    private Long ticketNumber;
    @Field(at=1)
    private String project;
    @Field(at=2)
    private String description;
    @Field(at=3)
    private String profile;
    @Field(at=4)
    private String seniority;
    @Field(at=5)
    private String position;
    @Field(at=6)
    private String sRCreatedon;
    @Field(at=7)
    private String startDate;
    @Field(at=8)
    private String location;
    @Field(at=9)
    private String status;
    @Field(at=10)
    private String candidate;
    @Field(at=11)
    private String requiresClientInterview;
    @Field(at=12)
    private String readyForOnboarding;
    @Field(at=13)
    private String priority;
    @Field(at=14)
    private Long aging;
    @Field(at=15)
    private String real;
    @Field(at=16)
    private String comment;
    @Field(at=17)
    private String candidateStatus;
    @Field(at=18)
    private String mainArea;
    @Field(at=19)
    private String projectAssigned;
    @Field(at=20)
    private Integer level;

    public Long getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Long ticketNumber) {
        this.ticketNumber = ticketNumber;
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

    public String getsRCreatedon() {
        return sRCreatedon;
    }

    public void setsRCreatedon(String sRCreatedon) {
        this.sRCreatedon = sRCreatedon;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
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

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public String getRequiresClientInterview() {
        return requiresClientInterview;
    }

    public void setRequiresClientInterview(String requiresClientInterview) {
        this.requiresClientInterview = requiresClientInterview;
    }

    public String getReadyForOnboarding() {
        return readyForOnboarding;
    }

    public void setReadyForOnboarding(String readyForOnboarding) {
        this.readyForOnboarding = readyForOnboarding;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Long getAging() {
        return aging;
    }

    public void setAging(Long aging) {
        this.aging = aging;
    }

    public String getReal() {
        return real;
    }

    public void setReal(String real) {
        this.real = real;
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

    public String getProjectAssigned() {
        return projectAssigned;
    }

    public void setProjectAssigned(String projectAssigned) {
        this.projectAssigned = projectAssigned;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "TicketCandidate{" +
                "ticketNumber=" + ticketNumber +
                ", project='" + project + '\'' +
                ", description='" + description + '\'' +
                ", profile='" + profile + '\'' +
                ", seniority='" + seniority + '\'' +
                ", position='" + position + '\'' +
                ", sRCreatedon='" + sRCreatedon + '\'' +
                ", startDate='" + startDate + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                ", candidate='" + candidate + '\'' +
                ", requiresClientInterview='" + requiresClientInterview + '\'' +
                ", readyForOnboarding='" + readyForOnboarding + '\'' +
                ", priority='" + priority + '\'' +
                ", aging=" + aging +
                ", real='" + real + '\'' +
                ", comment='" + comment + '\'' +
                ", candidateStatus='" + candidateStatus + '\'' +
                ", mainArea='" + mainArea + '\'' +
                ", projectAssigned='" + projectAssigned + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
