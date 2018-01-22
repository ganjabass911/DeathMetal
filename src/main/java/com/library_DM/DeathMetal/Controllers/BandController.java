package com.library_DM.DeathMetal.Controllers;

import com.library_DM.DeathMetal.Entities.BandEntity;
import com.library_DM.DeathMetal.Servises.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BandController {
    @Autowired
    BandService bandService;

    @GetMapping(name = "bands")
    public Iterable<BandEntity> getBandRepository() {
        return bandService.getBands();
    }

    @GetMapping("/band{id}")
    public Optional<BandEntity> getBand(@PathVariable long id){
        return bandService.getBand(id);
    }
}
