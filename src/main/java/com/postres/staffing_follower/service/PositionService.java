package com.postres.staffing_follower.service;

import com.postres.staffing_follower.entity.Position;
import com.postres.staffing_follower.repository.PositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    private PositionRepo positionRepo;

    public Optional<Position> getPosition(Long id) {return positionRepo.findById(id);}

    public void savePosition (Position position) {positionRepo.save(position);}

    public List<Position> getAll(){return positionRepo.findAll();}

}
