package com.library_DM.DeathMetal.Repositories;

import com.library_DM.DeathMetal.Entities.AlbumEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<AlbumEntity, Long>{
}
