package com.achievemnt.achievemnt.service.serviceAchievemnt;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.achievemnt.achievemnt.model.entity.Achievemnt;
import com.achievemnt.achievemnt.model.repository.AchievemntRepo;
import com.achievemnt.achievemnt.service.dto.AchievementResponse;
import com.achievemnt.achievemnt.service.dto.School;
import com.achievemnt.achievemnt.service.dto.Student;

@Service
public class ServiceAchievement {

    @Autowired
    private AchievemntRepo repo;

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<?> createAchievement(Achievemnt achievemnt) {
        try {
            Achievemnt savedAchievement = repo.save(achievemnt);
            return new ResponseEntity<>(savedAchievement, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchAchievement() {
        List<Achievemnt> achievements = repo.findAll();
        if (!achievements.isEmpty()) {
            return new ResponseEntity<>(achievements, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Achievements found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> fetchAchievementById(String id) {
        Optional<Achievemnt> data = repo.findById(id);
        if (data.isPresent()) {
            Student student = restTemplate.getForObject("http://student:18082/student/"+data.get().getNisn(), Student.class);
            School school = restTemplate.getForObject("http://school/school:18081/" + data.get().getSchoolId(), School.class);
            AchievementResponse achievementResponse = new AchievementResponse(
                data.get().getNisn(),
                data.get().getLomba(),
                data.get().getCapaian(),
                data.get().getTahun(),
                school,
                student
            );
            return new ResponseEntity<>(achievementResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Achievement not found", HttpStatus.NOT_FOUND);
        }
    }
}
