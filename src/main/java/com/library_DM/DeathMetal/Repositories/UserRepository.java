package com.library_DM.DeathMetal.Repositories;

import com.library_DM.DeathMetal.Entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String usernme);
}
