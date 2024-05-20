package com.school.school.services;

import com.school.school.model.entity.School;
import com.school.school.model.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public School addSchool(School school){
        return schoolRepository.save(school);
    }
    public List<School> fetchSchools(){
        return schoolRepository.findAll();
    }
    public School fetchSchoolById(int id){
        return schoolRepository.findById(id).orElse(null);
    }
}