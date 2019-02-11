package com.tcs.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.bean.Faculty;
import com.tcs.bean.QuestionAndAnswer;
import com.tcs.dao.FacultyDAO;

public class FacultyService 
{

	FacultyDAO facultyDAO=new FacultyDAO();
	public int loginFaculty(Faculty faculty1) throws SQLException 
	{
		return facultyDAO.loginFaculty(faculty1);
	}
	public int createFacultyService(Faculty faculty2) throws SQLException 
	{
		return facultyDAO.createFaculty(faculty2); 
	}
	public void facultyEdit(Faculty faculty3) throws SQLException 
	{
		facultyDAO.facultyEdit(faculty3);
	}
	public Faculty FacultyView(Faculty faculty4) throws SQLException {
	
		return facultyDAO.facultyView(faculty4);
	}
	public int facultyPostQuestion(QuestionAndAnswer qa) throws SQLException
	{
		return facultyDAO.facultyPostQuestion(qa);
		
	}
	public ArrayList<QuestionAndAnswer> facultyViewQuestion() throws SQLException 
	{
		return facultyDAO.facultyViewQuestion();
	}
	public int facultyAnswerQuestion(QuestionAndAnswer QA1) throws SQLException 
	{
		return facultyDAO.facultyAnswerQuestion(QA1);
	}
}
