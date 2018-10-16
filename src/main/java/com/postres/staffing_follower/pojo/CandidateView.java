package com.postres.staffing_follower.pojo;

public class CandidateView {

    private Long idCandidate;
    private String name;
    private Long ticket;
    private String interview;
    private String onboarding;
    private String priority;
    private String realAttribute;
    private String candidateStatus;
    private String mainArea;
    private String project;
    private Integer level;
    private  String comment;


    public CandidateView() {
    }

    public CandidateView(Long idCandidate, String name, Long ticket, String interview, String onboarding, String priority, String realAttribute, String candidateStatus, String mainArea, String project, Integer level, String comment) {
        this.idCandidate = idCandidate;
        this.name = name;
        this.ticket = ticket;
        this.interview = interview;
        this.onboarding = onboarding;
        this.priority = priority;
        this.realAttribute = realAttribute;
        this.candidateStatus = candidateStatus;
        this.mainArea = mainArea;
        this.project = project;
        this.level = level;
        this.comment = comment;
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
    public Long getTicket() {
        return ticket;
    }
    public void setTicket(Long ticket) {
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
    public String getRealAttribute() {
        return realAttribute;
    }
    public void setRealAttribute(String realAttribute) {
        this.realAttribute = realAttribute;
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
    public String getComment() {return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
