package com.library_DM.DeathMetal.Repositories;

import com.library_DM.DeathMetal.Entities.ReviewEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<ReviewEntity, Long> {
}
