package com.postres.staffing_follower.utils;


import com.postres.staffing_follower.controller.StatusController;
import com.postres.staffing_follower.entity.Status;
import com.postres.staffing_follower.repository.StatusRepo;

import com.postres.staffing_follower.service.StatusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestDateDifferenceCalculator {

    @Mock
    StatusRepo statusRepo;


    @Mock
    StatusService statusService;

    @InjectMocks
    StatusController statusController;


    @Test
    public void testDateDifferenceCalculator() throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date dateGit = dateFormat.parse("2018-07-03T03:00:00.000Z");
        Date dateq = dateFormat.parse("2018-07-26T03:00:00.000Z");

        System.out.println(dateGit.getTime());
        System.out.println((dateq.getTime()-dateGit.getTime())/(1000*60*60*24));
        System.out.println(dateGit);

    }
        @Test
    public void testDatabase(){

           //StatusRepo statusRepo=mock(StatusRepo.class);



         List<Status> list = new ArrayList<>();
         list.add(new Status((long) 7,"Closed",1));
         list.add(new Status((long) 5,"In progress",1));
         when(statusService.getAll()).thenReturn(list);
         //System.out.println(statusService.getAll());

            System.out.println(statusController.findAllStatus());


    }
}
