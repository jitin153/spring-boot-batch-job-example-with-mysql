package com.jitin.springbootbatchexamplewithmysql.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jitin.springbootbatchexamplewithmysql.service.StudentResultBatchService;

@RestController
public class StudentResultBatchController {
	private static final Logger LOG = LoggerFactory.getLogger(StudentResultBatchController.class);
	@Autowired
	private StudentResultBatchService studentResultBatchService;

	@GetMapping("/loadstudentdata/{filename}")
	public String load(@PathVariable("filename") String filename) {
		String result = "FAILED!";
		try {
			result = studentResultBatchService.lauchBatch(filename);
		} catch (JobParametersInvalidException e) {
			LOG.error("Error occurred : ", e);
		} catch (JobExecutionAlreadyRunningException e) {
			LOG.error("Error occurred : ", e);
		} catch (JobRestartException e) {
			LOG.error("Error occurred : ", e);
		} catch (JobInstanceAlreadyCompleteException e) {
			LOG.error("Error occurred : ", e);
		}
		return result;
	}
}
