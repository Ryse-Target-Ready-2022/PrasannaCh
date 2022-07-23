package com.tgt.rysetii.learningresourcesapi.controllers;

import com.tgt.rysetii.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetii.learningresourcesapi.service.LearningResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lr")
public class LearningResourceController {

    @Autowired
    private final LearningResourceService repo;

    public LearningResourceController(LearningResourceService repo) {

        this.repo = repo;
    }

    @GetMapping("/")
    public List<LearningResource> getAllLearningResources()
    {

        return repo.getLearningResources();
    }

    @PostMapping(value="/", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveLearningResources(@RequestBody List<LearningResource> learningResources)
    {
        repo.saveLearningResources(learningResources);
    }

    @PostMapping("/post")
    public void insertResources(@RequestBody List<LearningResource> lr)
    {
        repo.saveLearningResources(lr);
    }
    @PostMapping("/post1")
    public String insertRecord(@RequestBody LearningResource lr)
    {
        repo.save(lr);
        return "inserted employee";

    }

    @PutMapping("/update/{id}")
    public String updateLearningResource(@PathVariable int id,@RequestBody LearningResource learningresource)
    {
        return repo.updateLearningResource(id, learningresource);
    }

    @DeleteMapping(value="/learningresource/{learningResourceId}")
    public void deleteLearningResource(@PathVariable int learningResourceId)
    {
        repo.deleteLearningResourceById(learningResourceId);
    }
}
