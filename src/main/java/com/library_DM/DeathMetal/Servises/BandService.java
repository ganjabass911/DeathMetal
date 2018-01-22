package com.library_DM.DeathMetal.Servises;

import com.library_DM.DeathMetal.Entities.BandEntity;
import com.library_DM.DeathMetal.Repositories.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BandService {
    @Autowired
    BandRepository bandRepository;
    public Iterable<BandEntity> getBands(){
        return bandRepository.findAll();
    }
    public Optional<BandEntity> getBand(long id){
        return bandRepository.findById(id);
    }
}
