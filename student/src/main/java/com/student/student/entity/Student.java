package com.student.student.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class Student {
    // @Id
    private String nisn;
    // private String id;
    private String name;
    private int age;
    private String gender;
    private Integer schoolId;
    private String major;
    private String StatusAwal;
    private String StatusAkhir;
    private String NoIjazah;
}


