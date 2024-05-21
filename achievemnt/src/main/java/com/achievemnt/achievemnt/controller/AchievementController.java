package com.achievemnt.achievemnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.achievemnt.achievemnt.model.entity.Achievemnt;
import com.achievemnt.achievemnt.service.serviceAchievemnt.ServiceAchievement;

@RestController
@RequestMapping("/achievement")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AchievementController {

    @Autowired
    private ServiceAchievement achievementService;

    @PostMapping
    public ResponseEntity<?> createAchievement(@RequestBody Achievemnt achievement) {
        return achievementService.createAchievement(achievement);
    }

    @GetMapping
    public ResponseEntity<?> getAllAchievements() {
        return achievementService.fetchAchievement();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAchievementById(@PathVariable String id) {
        return achievementService.fetchAchievementById(id);
    }
}
