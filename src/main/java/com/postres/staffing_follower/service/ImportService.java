package com.postres.staffing_follower.service;


import com.postres.staffing_follower.dao.TicketCandidateDAO;
import com.postres.staffing_follower.entity.*;
import com.postres.staffing_follower.repository.*;
import com.postres.staffing_follower.utils.Field;
import com.postres.staffing_follower.utils.FieldConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ImportService {
    @Autowired
    private TicketCandidateDAO ticketCandidateDAO;
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private TicketHistoryRepo ticketHistoryRepo;
    @Autowired
    private CandidateRepo candidateRepo;
    @Autowired
    private CandidateHistoryRepo candidateHistoryRepo;
    @Autowired
    private LocationRepo locationRepo;
    @Autowired
    private PositionRepo positionRepo;
    @Autowired
    private ProfileRepo profileRepo;
    @Autowired
    private SeniorityRepo seniorityRepo;
    @Autowired
    private StatusRepo statusRepo;
    @Autowired
    private CandidateStatusRepo candidateStatusRepo;
    @Autowired
    private OnboardingRepo onboardingRepo;
    @Autowired
    private PriorityRepo priorityRepo;



    public void importSheetTicketCandidate() throws Exception {
        List<TicketCandidate> listTicketsCandidates = ticketCandidateDAO.getAllTicketsAndCandidates();
        for (TicketCandidate ticketCandidate: listTicketsCandidates) {
            Ticket ticket = this.createTicket(ticketCandidate);
//          do save or update
            ticketRepo.save(ticket);

            TicketHistory ticketHistory = this.createTicketHistory(ticketCandidate);
            TicketHistory ticketHistoryRepeated = this.getTicketHistoryRepeated(ticket.getIdTicket(), ticketHistory);
            if(ticketHistoryRepeated == null){
                ticketHistoryRepo.save(ticketHistory);
            }

            Candidate candidateNewOrRepeated = this.getCandidate(ticket, ticketCandidate);
            Candidate candidate = candidateRepo.save(candidateNewOrRepeated);


            CandidateHistory candidateHistory = this.createCandidateHistory(ticketCandidate, candidate.getIdCandidate());
            CandidateHistory candidateHistoryRepeated = this.getCandidateHistoryRepeated(candidate.getIdCandidate(), candidateHistory);
            if(candidateHistoryRepeated == null){
                candidateHistoryRepo.save(candidateHistory);
            }
        }
    }

    private Candidate getCandidate(Ticket ticket, TicketCandidate ticketCandidate) {
        Candidate candidate = this.createCandidate(ticketCandidate, ticket);

        List<Candidate> candidates = candidateRepo.findByTicket(ticket);
        Candidate candidateRepeated = candidates.stream().filter(object -> {
            if(Field.equal(object.getName(), candidate.getName())){
                return true;
            }
            return false;
        }).findAny().orElse(null);
        candidate.setIdCandidate(candidateRepeated != null?candidateRepeated.getIdCandidate():null);

        return candidate;
    }


    private CandidateHistory getCandidateHistoryRepeated(Long idCandidate, CandidateHistory candidateHistory) {
        List<CandidateHistory> histories = candidateHistoryRepo.findByIdCandidate(idCandidate);
        CandidateHistory candidateHistoryRepeated = histories.stream().filter( object -> {
                    if(
                            Field.equal(object.getCandidateStatus(), candidateHistory.getCandidateStatus()) &&
                                    Field.equal(object.getComment(), candidateHistory.getComment()) &&
                                    Field.equal(object.getInterview(), candidateHistory.getInterview()) &&
                                    Field.equal(object.getLevel(), candidateHistory.getLevel()) &&
                                    Field.equal(object.getMainArea(), candidateHistory.getMainArea()) &&
                                    Field.equal(object.getOnboarding(), candidateHistory.getOnboarding()) &&
                                    Field.equal(object.getPriority(), candidateHistory.getPriority()) &&
                                    Field.equal(object.getProject(), candidateHistory.getProject()) &&
                                    Field.equal(object.getRealAttibute(), candidateHistory.getRealAttibute())
                    ){
                        return true;
                    }
                    return false;
                }

        ).findAny().orElse(null);

        return candidateHistoryRepeated;

    }

    private TicketHistory getTicketHistoryRepeated(Long idTicket, TicketHistory ticketHistory) {
        List<TicketHistory> histories = ticketHistoryRepo.findByIdTicket(idTicket);
        TicketHistory ticketHistoryRepeated = histories.stream().filter(object -> {
            if (
                    Field.equal(object.getDescription(), ticketHistory.getDescription()) &&
                            Field.equal(object.getProject(), ticketHistory.getProject()) &&
                            Field.equal(object.getStatus(), ticketHistory.getStatus()) &&
                            Field.equal(object.getProfile(), ticketHistory.getProfile()) &&
                            Field.equal(object.getLocation(), ticketHistory.getLocation()) &&
                            Field.equal(object.getSeniority(), ticketHistory.getSeniority()) &&
                            Field.equal(object.getPosition(), ticketHistory.getPosition())&&
                            Field.equal(object.getStartDate(), ticketHistory.getStartDate()) &&
                            Field.equal(object.getCreatedOn(), ticketHistory.getCreatedOn())
            ) {
                return true;
            }
            return false;
        }).findAny().orElse(null);

        return ticketHistoryRepeated;
    }

    private CandidateHistory createCandidateHistory(TicketCandidate ticketCandidate, Long idCandidate) {
        CandidateHistory candidateHistory = new CandidateHistory();
        candidateHistory.setCandidateStatus(Field.getValueNormalized(ticketCandidate.getCandidateStatus()));
        candidateHistory.setComment(ticketCandidate.getComment());
        candidateHistory.setTicket(ticketCandidate.getTicketNumber().toString());
        candidateHistory.setIdCandidate(idCandidate);
        candidateHistory.setInterview(Field.getValueNormalized(ticketCandidate.getRequiresClientInterview(), FieldConstants.NOT.getValue()));
        candidateHistory.setLevel(ticketCandidate.getLevel());
        candidateHistory.setMainArea(Field.getValueNormalized(ticketCandidate.getMainArea()));
        candidateHistory.setNombre(ticketCandidate.getCandidate());
        candidateHistory.setOnboarding(Field.getValueNormalized(ticketCandidate.getReadyForOnboarding(), FieldConstants.NOT.getValue()));
        candidateHistory.setPriority(Field.getValueNormalized(ticketCandidate.getPriority()));
        candidateHistory.setProject(Field.getValueNormalized(ticketCandidate.getProject()));
        candidateHistory.setRealAttibute(Field.getValueNormalized(ticketCandidate.getReal()));
        candidateHistory.setUpdateDate(new Date());
        return candidateHistory;
    }

    private TicketHistory createTicketHistory(TicketCandidate ticketCandidate) {
        TicketHistory ticketHistory = new TicketHistory();
        ticketHistory.setDescription(ticketCandidate.getDescription());
        ticketHistory.setIdTicket(ticketCandidate.getTicketNumber());
        ticketHistory.setProject(ticketCandidate.getProject());


        ticketHistory.setStartDate(Field.getDate(ticketCandidate.getStartDate()));
        ticketHistory.setCreatedOn(Field.getDate(ticketCandidate.getsRCreatedon()));

        ticketHistory.setStatus(ticketCandidate.getStatus());
        ticketHistory.setProfile(ticketCandidate.getProfile());
        ticketHistory.setLocation(ticketCandidate.getLocation());
        ticketHistory.setSeniority(ticketCandidate.getSeniority());
        ticketHistory.setPosition(Field.getValueNormalized(ticketCandidate.getPosition()));
        ticketHistory.setUpdateDate(new Date());
        return ticketHistory;
    }

    private Candidate createCandidate(TicketCandidate ticketCandidate, Ticket ticket) {
        Candidate candidate = new Candidate();
        candidate.setName(ticketCandidate.getCandidate());
        candidate.setTicket(ticket);
        candidate.setMainArea(Field.getValueNormalized(ticketCandidate.getMainArea()));
        candidate.setInterview(Field.getValueNormalized(ticketCandidate.getRequiresClientInterview(), FieldConstants.NOT.getValue()));
        candidate.setComment(Field.getValueNormalized(ticketCandidate.getComment()));

        List<CandidateStatus> statuses = candidateStatusRepo.findByDsCandidateStatus(ticketCandidate.getCandidateStatus());
        List<Priority> priorities = priorityRepo.findByDsPriority(ticketCandidate.getPriority());
        List<Onboarding> onboardies = onboardingRepo.findByDsOnboarding(ticketCandidate.getReadyForOnboarding());

        candidate.setPriority(priorities.isEmpty()?null:priorities.get(0));
        candidate.setCandidateStatus(statuses.isEmpty()?null:statuses.get(0));
        candidate.setOnboarding(onboardies.isEmpty()?null:onboardies.get(0));

        if(ticketCandidate.getLevel() != null){
            List<Seniority> seniorities = seniorityRepo.findByDsSeniority(ticketCandidate.getLevel().toString());
            candidate.setLevel(seniorities.isEmpty()?null:seniorities.get(0));
        }

        candidate.setProject(ticketCandidate.getProject());
        candidate.setRealAttibute(ticketCandidate.getReal());
        return candidate;
    }

    private Ticket createTicket(TicketCandidate ticketCandidate) {
        Ticket ticket = new Ticket();
        ticket.setDescription(ticketCandidate.getDescription());
        ticket.setIdTicket(ticketCandidate.getTicketNumber());
        ticket.setProject(ticketCandidate.getProject());

        ticket.setStartDate(Field.getDate(ticketCandidate.getStartDate()));
        ticket.setCreatedOn(Field.getDate(ticketCandidate.getsRCreatedon()));

        List<Location> locations = locationRepo.findByDsLocation(Field.getValue(ticketCandidate.getLocation()));
        List<Seniority> seniorities = seniorityRepo.findByDsSeniority(Field.getValue(ticketCandidate.getSeniority()));
        List<Profile> profiles = profileRepo.findByDsProfile(Field.getValue(ticketCandidate.getProfile()));
        List<Status> statuses = statusRepo.findByDsStatus(Field.getValue(ticketCandidate.getStatus()));
        List<Position> positions = positionRepo.findByDsPosition(Field.getValue(ticketCandidate.getPosition()));

        ticket.setLocation(locations.isEmpty()?null:locations.get(0));
        ticket.setSeniority(seniorities.isEmpty()?null:seniorities.get(0));
        ticket.setProfile(profiles.isEmpty()?null:profiles.get(0));
        ticket.setStatus(statuses.isEmpty()?null:statuses.get(0));
        ticket.setPosition(positions.isEmpty()?null:positions.get(0));

        return ticket;

    }



}
