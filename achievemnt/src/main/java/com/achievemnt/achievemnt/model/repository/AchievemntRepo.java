package com.achievemnt.achievemnt.model.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.achievemnt.achievemnt.model.entity.Achievemnt;


@Repository
public interface AchievemntRepo extends MongoRepository<Achievemnt,String> {
     Optional<Achievemnt> findByNisn(String nisn);
}
