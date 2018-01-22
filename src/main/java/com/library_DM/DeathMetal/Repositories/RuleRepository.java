package com.library_DM.DeathMetal.Repositories;

import com.library_DM.DeathMetal.Entities.RuleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends CrudRepository<RuleEntity, Long> {
}
