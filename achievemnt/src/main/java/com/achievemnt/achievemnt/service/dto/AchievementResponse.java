package com.achievemnt.achievemnt.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AchievementResponse {
    private String nisn;
    private String lomba;
    private String capaian;
    private String tahun;
    private School School;
    private Student Student;
}
