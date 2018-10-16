package com.postres.staffing_follower.controller;

import com.postres.staffing_follower.entity.Status;
import com.postres.staffing_follower.repository.StatusRepo;
import com.postres.staffing_follower.service.StatusService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatusControllerTest {

    @Mock
    StatusRepo statusRepo;

    @Mock
    StatusService statusService;

    @InjectMocks
    StatusController statusController;

    @Before
    public  void init(){

        System.out.println("Begin Test of StatusController");
    }


    @Test
    public void testDatabase(){



        List<Status> list = new ArrayList<>();
        list.add(new Status((long) 7,"Closed",1));
        Status status5 = new Status((long) 5, "In progress", 1);
        list.add(status5);
        when(statusService.getAll()).thenReturn(list);
        when(statusService.getStatus((long) 5)).thenReturn(java.util.Optional.of(status5));
        statusController.saveSatus((new Status((long) 7,"Open",1)));
        System.out.println(statusController.findAllStatus());
        System.out.println(statusController.findStatusByID((long) 5));

        assertEquals(statusController.findStatusByID((long) 5), ResponseEntity.ok(java.util.Optional.of(status5)));
    }

}