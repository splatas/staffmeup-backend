package com.postres.staffing_follower.service;

import com.postres.staffing_follower.entity.CandidateHistory;
import com.postres.staffing_follower.pojo.CandidateCompareReport;
import com.postres.staffing_follower.repository.CandidateHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CandidateHistoryService {

    @Autowired
    private CandidateHistoryRepo candidateHistoryRepo;


    public List<CandidateHistory> getAll(){
        return candidateHistoryRepo.findAll();
    }

    public List<CandidateHistory> getAllCandidateHistory(Long idCandidateHistory){
        return candidateHistoryRepo.findAllByIdCandidateHistory(idCandidateHistory);
    }

    public void saveCandidateHistory(CandidateHistory candidateHistory){
        candidateHistoryRepo.save(candidateHistory);
    }

    public List<CandidateHistory> getAllOrderedByDate(){
        return candidateHistoryRepo.findAllByOrderByIdCandidateAscUpdateDateDesc();
    }


    public List<List<CandidateHistory>> getCandidatesToCompareByTicket(Long idTicket, Date dateOne, Date dateTwo){

        int i = 0;
        int j = 0;
        Long candidateIdAux= 0L;

        //CandidateCompareReport candidateReport = null;
        CandidateHistory candidate;
        //List<CandidateCompareReport> candidateList = new ArrayList<>();
        List<CandidateHistory> candidateHistoryToCompareList = new ArrayList<>();
        List<List<CandidateHistory>> candidateList = new ArrayList<>();
        List<CandidateHistory> candidateHistoryList = candidateHistoryRepo.getAllTheCandidatesToCompareByTicket(idTicket, dateOne, dateTwo);

        if (!candidateHistoryList.isEmpty()){

            candidateIdAux = candidateHistoryList.get(0).getIdCandidate();
            //candidateHistoryToCompareList = new ArrayList<>();

            while (i < candidateHistoryList.size()){

                candidate = candidateHistoryList.get(i);

                if (candidateIdAux == candidate.getIdCandidate()){
                    if (candidate.getUpdateDate().compareTo(dateOne)<= 0){
                        candidateHistoryToCompareList.add(candidate);
                        //candidateReport.setCandidateHistoryOne(candidate);
                    }
                    else{
                        if (candidateHistoryToCompareList.isEmpty()){
                            candidateHistoryToCompareList.add(getEmptyCandidate());
                        }
                        candidateHistoryToCompareList.add(candidate);
                        //candidateReport.setCandidateHistoryTwo(candidate);
                    }
                }
                else {
                    if (candidateHistoryToCompareList.size() == 1){
                        candidateHistoryToCompareList.add(getEmptyCandidate());
                    }
                    candidateList.add(j, candidateHistoryToCompareList);
                    j++;
                    //candidateList.add(candidateReport);
                    //candidateReport = new CandidateCompareReport();
                    candidateHistoryToCompareList = new ArrayList<>();

                    candidateIdAux = candidate.getIdCandidate();

                    if (candidate.getUpdateDate().compareTo(dateOne) <= 0){
                        candidateHistoryToCompareList.add(candidate);
                        //candidateReport.setCandidateHistoryOne(candidate);
                    }
                    else{
                        if (candidateHistoryToCompareList.isEmpty()){
                            candidateHistoryToCompareList.add(getEmptyCandidate());
                        }
                        candidateHistoryToCompareList.add(candidate);
                        //candidateReport.setCandidateHistoryTwo(candidate);
                    }
                }
                i++;
            }

            if (candidateHistoryToCompareList.size() == 1){
                candidateHistoryToCompareList.add(getEmptyCandidate());
            }

            candidateList.add(j, candidateHistoryToCompareList);
            //candidateList.add(candidateReport);
            //return  candidateList;

        }

        return candidateList;

    }

    private CandidateHistory getEmptyCandidate() {
        return new CandidateHistory(0L, 0L, "", "", "", "", "", "", "", "", "", "", 0, null);
    }




    /*    VERSION ORIGINAL TODO ELIMINAR CUANDO LA NUEVA VERSION FUNCIONE
    public List<CandidateCompareReport> getCandidateToCompareByTicket(Long idTicket, Date dateOne, Date dateTwo){

        int i = 0;
        Long candidateIdAux= 0L;

        CandidateCompareReport candidateReport = null;
        CandidateHistory candidate;
        List<CandidateCompareReport> candidateList = new ArrayList<>();
        List<CandidateHistory> candidateHistoryList = candidateHistoryRepo.getAllTheCandidatesToCompareByTicket(idTicket, dateOne, dateTwo);

        if (!candidateHistoryList.isEmpty()){
            candidateIdAux = candidateHistoryList.get(0).getIdCandidate();
            candidateReport = new CandidateCompareReport();
        }

        while (i < candidateHistoryList.size()){

            candidate = candidateHistoryList.get(i);

            if (candidateIdAux == candidate.getIdCandidate()){
                if (candidate.getUpdateDate().compareTo(dateOne)<= 0){
                    candidateReport.setCandidateHistoryOne(candidate);
                }
                else{
                    candidateReport.setCandidateHistoryTwo(candidate);
                }
            }
            else {
                candidateList.add(candidateReport);
                candidateReport = new CandidateCompareReport();

                candidateIdAux = candidate.getIdCandidate();

                if (candidate.getUpdateDate().compareTo(dateOne)<=0){
                    candidateReport.setCandidateHistoryOne(candidate);
                }
                else{
                    candidateReport.setCandidateHistoryTwo(candidate);
                }
            }
            i++;
        }
        candidateList.add(candidateReport);
        return  candidateList;

    }

*/





    public List<CandidateHistory> test(Date dateOne, Date dateTwo){
        return candidateHistoryRepo.getAllTheCandidatesToCompare(dateOne, dateTwo);
    }



}


