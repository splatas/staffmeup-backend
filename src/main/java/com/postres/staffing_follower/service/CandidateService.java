package com.postres.staffing_follower.service;

import com.postres.staffing_follower.entity.Candidate;
import com.postres.staffing_follower.pojo.CandidateView;
import com.postres.staffing_follower.repository.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepo candidateRepo;


    public Candidate getCandidate(Long id) {
        return candidateRepo.getOne(id);
    }

    public List<Candidate> getBetween(Long from, Long to){
        return candidateRepo.findByIdCandidateBetween(from, to);
    }

    public List<Candidate> getAll() {
        return candidateRepo.findAll();
    }

    public void saveCandidate(Candidate candidate) {
        candidateRepo.save(candidate);
    }

    /**
     * <h1>getCandidateView</h1>
     *<p>Only the values ​​selected in the fromEntityToPojo method are displayed</p>
     */
    public List<CandidateView> getCandidatesView() {

        List<Candidate> candidates = getAll();
        List<CandidateView> candidatesView = new ArrayList<>();

        for (Candidate c : candidates) {
            candidatesView.add(fromEntityToPojo(c));
        }

        return candidatesView;
    }


    /**
     * <h1>fromEntityToPojo</h1>
     * <p>take the values form entity ​​to save them in a object from CandidateView
     * @return Object.toString: return an empty String instead of a null</p>
     */
    private CandidateView fromEntityToPojo(Candidate candidate){

        CandidateView candidatePojo;

        Long    idCandidate     = candidate.getIdCandidate();
        String  name            = Objects.toString(candidate.getName(), "");
        Long    ticket          = candidate.getTicket().getIdTicket();
        String  interview       = Objects.toString(candidate.getInterview(),"");
        String comment          = Objects.toString(candidate.getComment(),"");
        String  onboarding      = "";

        if(candidate.getOnboarding() != null){
            onboarding      = Objects.toString(candidate.getOnboarding().getDsOnboarding(),"");
        }
        String  priority      = "";
        if(candidate.getPriority() != null){
            priority        = Objects.toString(candidate.getPriority().getDsPriority(),"");
        }

        String  candidateStatus      = "";
        if(candidate.getCandidateStatus() != null){
            candidateStatus = Objects.toString(candidate.getCandidateStatus().getDsCandidateStatus(),"");
        }

        Integer  level      = -1;
        if(candidate.getLevel() != null && candidate.getLevel().getLevel() == null){
            level = candidate.getLevel().getLevel();
        }
        String  mainArea        = Objects.toString(candidate.getMainArea(),"");
        String  project         = Objects.toString(candidate.getProject(),"");
        String  realAttribute   = Objects.toString(candidate.getRealAttibute(),"");

        candidatePojo = new CandidateView( idCandidate
                                          ,name
                                          ,ticket
                                          ,interview
                                          ,onboarding
                                          ,priority
                                          ,realAttribute
                                          ,candidateStatus
                                          ,mainArea
                                          ,project
                                          ,level
                                          ,comment);

        return candidatePojo;
    }

}
