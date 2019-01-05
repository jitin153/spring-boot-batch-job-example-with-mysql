package com.jitin.springbootbatchexamplewithmysql.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "student_result")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "roll_number")
	private Integer rollNumber;
	@Column(name = "name")
	private String name;
	@Column(name = "student_class")
	private String studentClass;
	@Column(name = "total_marks")
	private Integer totalMarks;
	@Column(name = "marks_obtained")
	private Integer marksObtained;
	@Column(name = "percentage")
	private Float percentage;
	@Enumerated(EnumType.STRING)
	@Column(name = "over_all_result")
	private Result overAllResult;
	@Column(name = "division")
	private String division;
	@Column(name = "date_updated")
	private Date dateUpdated;

}
