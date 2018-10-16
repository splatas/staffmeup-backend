package com.postres.staffing_follower.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "candidateStatus")
public class CandidateStatus {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_candidate_status")
    private Long idCandidateStatus;

    @Column(name = "ds_candidate_status")
    @NotEmpty
    private String dsCandidateStatus;

    @Column(name = "enable_candidate_status")
    @NotNull
    private Integer enabledCandidateStatus;

    public CandidateStatus(Long idCandidateStatus, @NotEmpty String dsCandidateStatus, @NotNull Integer enabledCandidateStatus) {
        this.idCandidateStatus = idCandidateStatus;
        this.dsCandidateStatus = dsCandidateStatus;
        this.enabledCandidateStatus = enabledCandidateStatus;
    }

    public CandidateStatus() {
    }


    public Long getIdCandidateStatus() {
        return idCandidateStatus;
    }

    public void setIdCandidateStatus(Long idCandidateStatus) {
        this.idCandidateStatus = idCandidateStatus;
    }

    public String getDsCandidateStatus() {
        return dsCandidateStatus;
    }

    public void setDsCandidateStatus(String dsCandidateStatus) {
        this.dsCandidateStatus = dsCandidateStatus;
    }

    public Integer getEnabledCandidateStatus() {
        return enabledCandidateStatus;
    }

    public void setEnabledCandidateStatus(Integer enabledCandidateStatus) {
        this.enabledCandidateStatus = enabledCandidateStatus;
    }
}
