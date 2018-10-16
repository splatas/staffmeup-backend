package com.postres.staffing_follower.dao.impl;


import com.postres.staffing_follower.dao.TicketCandidateDAO;
import com.postres.staffing_follower.entity.TicketCandidate;
import org.beanio.StreamFactory;
import org.beanio.Unmarshaller;
import org.beanio.builder.DelimitedParserBuilder;
import org.beanio.builder.StreamBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;



@Component
public class TicketCandidateDAOImpl implements TicketCandidateDAO {

    private String urlFile;

    private Logger logger = LoggerFactory.getLogger(TicketCandidateDAOImpl.class);

    public TicketCandidateDAOImpl(@Value("${postres.file.url:PlanillaMOC.csv}") final String urlFile) {
        this.urlFile = urlFile;
    }

    @Override
    public List<TicketCandidate> getAllTicketsAndCandidates() throws Exception{
        List<TicketCandidate> listTicketsCandidates = new ArrayList<>();

        StreamBuilder builderCSV = new StreamBuilder("builderCSV")
                .format("csv")
                .parser(new DelimitedParserBuilder(','))
                .addRecord(TicketCandidate.class);
        StreamFactory factory  = StreamFactory.newInstance();
        factory.define(builderCSV);

        Unmarshaller unmarshaller = factory.createUnmarshaller("builderCSV");

        try(BufferedReader br = new BufferedReader(new FileReader(urlFile))) {
            String line =  br.readLine();
            while ((line = br.readLine()) != null) {
                TicketCandidate ticketCandidate = (TicketCandidate) unmarshaller.unmarshal(line);
                listTicketsCandidates.add(ticketCandidate);
            }
        } catch (Exception e) {
            logger.error("Error to parse csv",e);
            throw e;
        }

        return listTicketsCandidates;
    }
}
