package net.javaguides.hibernate.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.model.Student;
import net.javaguides.hibernate.util.HibernateUtil;

public class StudentDao implements IStudentDao {
//save student
	//get All Students
	//get students by id
	//update student
	//delete student
	@Override
	public void saveStudent(Student student)
	{
		Transaction transaction=null; 
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			
			//start the transaction
			transaction = session.beginTransaction();
			//save student object
			session.saveOrUpdate(student);
			
			//commit transaction
			transaction.commit();
		}
		catch(Exception ex)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
		}
		
	}
	
	@Override
	public void updateStudent(Student student)
	{
		Transaction transaction=null; 
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			//start the transaction
			transaction = session.beginTransaction();

			//save student object
			session.saveOrUpdate(student);
			
			//commit transaction
			transaction.commit();
		}
		catch(Exception ex)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
		}
		
	}
	@Override
	public Student getStudentById(long id)
	{
		Transaction transaction=null; 
		Student student=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			//start the transaction
			transaction = session.beginTransaction();

			//get student object
			student=session.get(Student.class,id);
			System.out.println("Id is "+id);
//			student=session.load(Student.class,id);
			
			//commit transaction
			transaction.commit();
		}
		catch(Exception ex)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
		}
		return student;
	}
	@Override
	public List<Student> getAllStudents()
	{
		Transaction transaction=null; 
		List<Student> students=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			//start the transaction
			transaction=session.beginTransaction();

			//get students
			students=session.createQuery("from Student").list();
//			student=session.load(Student.class,id);
			
			//commit transaction
			transaction.commit();
		}
		catch(Exception ex)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
		}
		return students;
	}
	
	@Override
	public Student deleteStudent(long id)
	{
		Transaction transaction=null; 
		Student student=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			//start the transaction
			transaction = session.beginTransaction();

			//get student object
			student=session.get(Student.class,id);
			session.delete(student);
//			student=session.load(Student.class,id);
			
			//commit transaction
			transaction.commit();
		}
		catch(Exception ex)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
		}
		return student;
	}

}
