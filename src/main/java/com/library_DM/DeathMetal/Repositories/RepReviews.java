package com.library_DM.DeathMetal.Repositories;

import com.library_DM.DeathMetal.Entities.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepReviews extends CrudRepository<Review, Long> {
    Iterable<Review> findByValueContaining(String title);
}
