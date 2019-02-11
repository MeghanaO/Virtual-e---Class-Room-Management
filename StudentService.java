package com.tcs.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.bean.QuestionAndAnswer;
import com.tcs.bean.Student;
import com.tcs.dao.StudentDAO;

public class StudentService 
{
	StudentDAO studentDAO=new StudentDAO();
	public int loginStudent(Student student) throws SQLException
	{
		return studentDAO.loginStudent(student);
	}
public int createStudentService(Student student) throws ClassNotFoundException, SQLException
{
	//Connect DAO to create
	System.out.println("in service");
	return studentDAO.createStudent(student);
}
public int studentPostQuestion(QuestionAndAnswer qa) throws SQLException
{
	return studentDAO.studentPostQuestion(qa);
}
public void studentEdit(Student student) throws SQLException {
	 studentDAO.studentEdit(student);
}
public Student studentView(Student student) throws SQLException 
{
	return studentDAO.studentView(student);
}
public ArrayList<QuestionAndAnswer> studentViewQuestion() throws SQLException {
	// TODO Auto-generated method stub
	return studentDAO.studentViewQuestion();
}
}
