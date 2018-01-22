package com.library_DM.DeathMetal.Repositories;

import com.library_DM.DeathMetal.Entities.BandEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandRepository extends CrudRepository<BandEntity, Long> {

}
