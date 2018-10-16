package com.postres.staffing_follower.controller;

import com.postres.staffing_follower.pojo.TecnologyReport;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/file")
public class FileControler {

    @GetMapping("/downloadTechnologyReport")
    public ResponseEntity<InputStreamResource> downloadTechnologyReport() {
        try {
            StringBuffer buffer = new StringBuffer();
            TecnologyReport tecnologyReport = new TecnologyReport();
            tecnologyReport.setAvarage(10);
            tecnologyReport.setMax(20);
            tecnologyReport.setMin(1);
            tecnologyReport.setTecnologyName("java");

            buffer.append(tecnologyReport.getTecnologyName()).append(",");
            buffer.append(tecnologyReport.getMin()).append(",");
            buffer.append(tecnologyReport.getMax()).append(",");
            buffer.append(tecnologyReport.getAvarage()).append(",");


            InputStream is = new ByteArrayInputStream(buffer.toString().getBytes(Charset.forName("UTF-8")));;

            return ResponseEntity
                    .ok()
                    .body(new InputStreamResource(is));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    }
