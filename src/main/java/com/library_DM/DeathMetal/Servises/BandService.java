package com.library_DM.DeathMetal.Servises;

import com.library_DM.DeathMetal.Entities.AlbumEntity;
import com.library_DM.DeathMetal.Entities.BandEntity;
import com.library_DM.DeathMetal.Entities.ReviewEntity;
import com.library_DM.DeathMetal.Repositories.AlbumRepository;
import com.library_DM.DeathMetal.Repositories.BandRepository;
import com.library_DM.DeathMetal.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BandService {
    @Autowired
    BandRepository bandRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    AlbumRepository albumRepository;

    public Iterable<BandEntity> getBands(){
        return bandRepository.findAll();
    }
    public Optional<BandEntity> getBand(long id){
        return bandRepository.findById(id);
    }

    public Iterable<ReviewEntity> getReviewes(){return reviewRepository.findAll();}
    public Optional<ReviewEntity> getReview(long id){return reviewRepository.findById(id);}

    public Iterable<AlbumEntity> getAlbums(){return albumRepository.findAll();}
    public Optional<AlbumEntity> getAlbum(long id){return albumRepository.findById(id);}

}
