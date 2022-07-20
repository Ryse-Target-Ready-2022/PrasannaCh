package com.tgt.rysetii.learningresourcesapi.repository;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface LearningResourceRepository extends JpaRepository<LearningResource,Integer> {
}
