package com.postres.staffing_follower.pojo;

import com.postres.staffing_follower.entity.CandidateHistory;

public class CandidateCompareReport {

    private CandidateHistory candidateHistoryOne;
    private CandidateHistory candidateHistoryTwo;


    public CandidateCompareReport() {
    }

    public CandidateCompareReport(CandidateHistory candidateHistoryOne, CandidateHistory candidateHistoryTwo) {
        this.candidateHistoryOne = candidateHistoryOne;
        this.candidateHistoryTwo = candidateHistoryTwo;
    }


    public CandidateHistory getCandidateHistoryOne() {
        return candidateHistoryOne;
    }
    public void setCandidateHistoryOne(CandidateHistory candidateHistoryOne) {
        this.candidateHistoryOne = candidateHistoryOne;
    }
    public CandidateHistory getCandidateHistoryTwo() {
        return candidateHistoryTwo;
    }
    public void setCandidateHistoryTwo(CandidateHistory candidateHistoryTwo) {
        this.candidateHistoryTwo = candidateHistoryTwo;
    }

}
