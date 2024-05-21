package com.achievemnt.achievemnt.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "achievemnt")
public class Achievemnt {

    @Id
    private String nisn;
    // private String id;  // Renamed to follow Java naming conventions
    private String capaian;
    private String lomba;
    private String tahun;
    private Integer schoolId;
}
