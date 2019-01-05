package com.jitin.springbootbatchexamplewithmysql.util;

import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.jitin.springbootbatchexamplewithmysql.model.Division;
import com.jitin.springbootbatchexamplewithmysql.model.Result;
import com.jitin.springbootbatchexamplewithmysql.model.Student;

@Component
public class ResultProcessor implements ItemProcessor<Student, Student> {
	@Override
	public Student process(Student student) throws Exception {
		Float percentage = (float) (student.getMarksObtained() * 100) / student.getTotalMarks();
		student.setPercentage(percentage);
		if (percentage >= 33) {
			student.setOverAllResult(Result.PASS);
			if (percentage >= 33 && percentage < 45) {
				student.setDivision(Division.THIRD.toString());
			} else if (percentage >= 45 && percentage < 60) {
				student.setDivision(Division.SECOND.toString());
			} else if (percentage >= 60 && percentage < 75) {
				student.setDivision(Division.FIRST.toString());
			} else if (percentage >= 75 && percentage < 100) {
				student.setDivision(Division.HONOURS.toString());
			}
		} else {
			student.setOverAllResult(Result.FAIL);
		}
		student.setDateUpdated(new Date());
		return student;
	}
}
