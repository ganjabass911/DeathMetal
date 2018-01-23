package com.library_DM.DeathMetal.Controllers;

import com.library_DM.DeathMetal.Entities.AlbumEntity;
import com.library_DM.DeathMetal.Entities.BandEntity;
import com.library_DM.DeathMetal.Entities.ReviewEntity;
import com.library_DM.DeathMetal.Servises.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BandController {
    @Autowired
    BandService bandService;

//    @GetMapping(name = "bands")
//    public Iterable<BandEntity> getBandRepository() {
//        return bandService.getBands();
//    }

//    @GetMapping("/band{id}")
//    public Optional<BandEntity> getBand(@PathVariable long id){
//        return bandService.getBand(id);
//    }
    @RequestMapping(value = "/band{id}", method = RequestMethod.GET)
    public ModelAndView getBand(@PathVariable long id){
        Map<String,Object>model=new HashMap<>();
        Optional<BandEntity> band = bandService.getBand(id);//интересный момент
        model.put("bands", band);
        return new ModelAndView("bands", model);
    }

    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = {"/bands"}, method = RequestMethod.GET)
    public ModelAndView bandList(){
        Map<String, Object> model = new HashMap<>();
        List<BandEntity> bands = (List<BandEntity>) bandService.getBands();
        model.put("bands", bands);
        return new ModelAndView("bands", model);
    }

    @RequestMapping(value = {"/albums"}, method = RequestMethod.GET)
    public ModelAndView albumList(){
        Map<String,Object> model = new HashMap<>();
        List<AlbumEntity> albums = (List<AlbumEntity>) bandService.getAlbums();
        model.put("albums", albums);
        return new ModelAndView("albums", model);
    }

    @RequestMapping(value = {"/reviewes"}, method = RequestMethod.GET)
    public ModelAndView reviewList(){
        Map<String,Object> model = new HashMap<>();
        List<ReviewEntity> reviewes = (List<ReviewEntity>) bandService.getReviewes();
        model.put("reviewes", reviewes);
        return new ModelAndView("reviewes", model);
    }
}
