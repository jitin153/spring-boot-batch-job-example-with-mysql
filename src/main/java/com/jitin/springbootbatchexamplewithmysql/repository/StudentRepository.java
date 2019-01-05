package com.jitin.springbootbatchexamplewithmysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jitin.springbootbatchexamplewithmysql.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
