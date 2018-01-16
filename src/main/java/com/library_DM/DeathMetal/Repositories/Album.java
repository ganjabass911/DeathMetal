package com.library_DM.DeathMetal.Repositories;

import org.springframework.data.repository.CrudRepository;

public interface Album extends CrudRepository<Album, Long> {
    Iterable<Album> findByValueContaining(String title);
}
