package com.postres.staffing_follower.controller;

import com.postres.staffing_follower.entity.Candidate;
import com.postres.staffing_follower.entity.CandidateStatus;
import com.postres.staffing_follower.service.CandidateStatusService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CandidateStatusControllerTest {

    @Mock
    CandidateStatusService candidateStatusService;

    @InjectMocks
    CandidateStatusController candidateStatusController;


    @Test
    public void testGetAll(){

        List<CandidateStatus> candidateStatuses=new ArrayList<>();
        candidateStatuses.add(new CandidateStatus((long) 5,"Confirmed",1));
        candidateStatuses.add(new CandidateStatus((long) 10,"Interviewing",1));

        when(candidateStatusService.getAll()).thenReturn(candidateStatuses);

        assertEquals(ResponseEntity.ok(candidateStatuses),candidateStatusController.findAllCandidateStatus());
    }

    @Test
    public void findCandidateSatusByIdTest(){


        CandidateStatus candidateStatus= new CandidateStatus(
                (long) 5,"Confirmed",1);

        when(candidateStatusService.getStatus((long) 6)).thenReturn(java.util.Optional.ofNullable(candidateStatus));

        assertEquals(ResponseEntity.ok(java.util.Optional.ofNullable(candidateStatus)),candidateStatusController.findCandidateSatusById((long) 6));
    }

    @Test
    public  void saveCandidateStatus(){
        CandidateStatus candidateStatus= new CandidateStatus(
                (long) 5,"Confirmed",1);

        candidateStatusController.saveCandidateStatus(candidateStatus);

    }

}

