package com.jitin.springbootbatchexamplewithmysql.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentResultBatchController {
	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job job;

	@GetMapping("/loadstudentdata/{filename}")
	public String load(@PathVariable("filename") String filename) throws JobParametersInvalidException,
			JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
		Map<String, JobParameter> maps = new HashMap<>();
		maps.put("time", new JobParameter(System.currentTimeMillis()));
		maps.put("filename", new JobParameter(filename));
		JobParameters parameters = new JobParameters(maps);
		JobExecution jobExecution = jobLauncher.run(job, parameters);

		System.out.println("Student results are processing...");
		while (jobExecution.isRunning()) {
			System.out.println("...");
		}
		BatchStatus response = jobExecution.getStatus();
		if (response.equals(BatchStatus.COMPLETED)) {
			return filename + " has been successfully processed and saved into database!";
		} else {
			return "Oops!..Something went wrong while processing " + filename;
		}
	}
}
