package com.library_DM.DeathMetal.Repositories;

import com.library_DM.DeathMetal.Entities.Band;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepBand extends CrudRepository<Band, Long> {
    Iterable<Band> findByNameContaining(String name);
}
