package net.javaguides.hibernate;

import java.util.List;

import net.javaguides.hibernate.dao.IStudentDao;
import net.javaguides.hibernate.dao.StudentDao;
import net.javaguides.hibernate.model.Student;

public class App {
public static void main(String[] args) {
	Student student=new Student("Poonam","B","abc@gmail.com");
	//save method
	IStudentDao	studentDao=new StudentDao();
	studentDao.saveStudent(student);
	
	System.out.println("Student id"+student.getId());
	
	//update
	student.setFirstname("Ram");
	studentDao.updateStudent(student);
	
	Student student2=studentDao.getStudentById(student.getId());
	//print
	 List<Student> students=studentDao.getAllStudents();
	 students.forEach(student1->System.out.println(student1.getId()));
//delete
	 studentDao.deleteStudent(student.getId());
	 }
}
