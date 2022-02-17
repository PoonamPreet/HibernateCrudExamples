package net.javaguides.hibernate.dao;

import java.util.List;

import net.javaguides.hibernate.model.Student;

public interface IStudentDao {

	//save student
	//get All Students
	//get students by id
	//update student
	//delete student
	void saveStudent(Student student);

	void updateStudent(Student student);

	Student getStudentById(long id);

	List<Student> getAllStudents();

	Student deleteStudent(long id);

}