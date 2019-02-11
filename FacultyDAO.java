package com.tcs.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.bean.Faculty;
import com.tcs.bean.QuestionAndAnswer;
import com.tcs.bean.Student;
import com.tcs.connection.ConnectionManager;

public class FacultyDAO 
{
	private Connection con=null;;
	private PreparedStatement FacultyPostQuestionPS=null;
	private PreparedStatement FacultyLoginPS=null;
	private PreparedStatement CreateFacultyPS=null;
	private PreparedStatement selectFacultyId=null;
	private PreparedStatement EditFacultyPS=null;
	private PreparedStatement ViewFacultyPS=null;
	private PreparedStatement ViewQuestionFacultyPS =null;
	private PreparedStatement AnswerFacultyPS=null;
	int result=0;
	String FacultyPostQuestionQuery = "insert into QUESTIONANDANSWER(question_id,question,status) values(question_id.nextval,?,?)";
	String FacultyLoginQuery="select faculty_id,password from faculty where faculty_id=? and password=?";
	String CreateFacultyQuery=" insert into faculty values(faculty_id.nextval,?,?,?,?,?)";
	String EditFacultyQuery="update faculty set username=?,password=?,email_id=?,phone_no=? where faculty_id=?";
	String ViewFacultyQuery="select * from faculty where faculty_id=?";
	String ViewQuestionFacultyQuery="select * from questionandanswer";
	String AnswerFacultyQuery="update QuestionAndAnswer set answer=?,status=? where question_id=?";
	public int loginFaculty(Faculty faculty1) throws SQLException 
	{
		int result=0;
		ConnectionManager conn=new ConnectionManager();
		con = conn.getConnection();
		try
		{
			FacultyLoginPS = con.prepareStatement(FacultyLoginQuery);
			FacultyLoginPS.setInt(1,faculty1.getFacultyId());
			FacultyLoginPS.setString(2,faculty1.getPassword());
			System.out.println(faculty1.getFacultyId());
			System.out.println(faculty1.getPassword());
		   ResultSet rs=FacultyLoginPS.executeQuery();
		    con.commit();
		    while(rs.next())
		    {
		    	result=rs.getInt(1);
		    	System.out.println(result);
		    }
		}
		
		catch(SQLException e)
		{
			System.out.println("Exception occured while executing login operation");
			e.printStackTrace();
		}
		finally
		{
			con.close();
		}
		return result;
	}
	public int createFaculty(Faculty faculty2) throws SQLException 
	{
		ConnectionManager conn=new ConnectionManager();
		con = conn.getConnection();	
	int fctyId=0;
		try
		{	System.out.println(faculty2.getUserName());
			System.out.println("in dao");
			CreateFacultyPS=con.prepareStatement(CreateFacultyQuery);
			CreateFacultyPS.setString(1,faculty2.getUserName());
			System.out.println(faculty2.getUserName());
			CreateFacultyPS.setString(2,faculty2.getPassword());
			System.out.println(faculty2.getPassword());
			CreateFacultyPS.setInt(3,faculty2.getClassRoomId());
			System.out.println(faculty2.getClassRoomId());
			CreateFacultyPS.setString(4,faculty2.getEmailId());
			System.out.println(faculty2.getEmailId());
			CreateFacultyPS.setLong(5,faculty2.getPhoneNo());
			System.out.println(faculty2.getPhoneNo());
			System.out.println(CreateFacultyPS);
			int result=CreateFacultyPS.executeUpdate();
			con.commit();
			if(result>0)
			selectFacultyId=con.prepareStatement("select faculty_id.currval as id from dual");
			ResultSet rs=selectFacultyId.executeQuery();
			while (rs.next())
			{
				fctyId=rs.getInt(1);
		}
			}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		finally
		{
			if(con!=null)
			{
				con.close();
			}
			if(CreateFacultyPS!=null)
			{
				CreateFacultyPS.close();
			}
		}
		return fctyId;	
	}
	public void facultyEdit(Faculty faculty3) throws SQLException 
	{
		ConnectionManager conn=new ConnectionManager();
		con = conn.getConnection();
		try
		{
		System.out.println("in dao");
		EditFacultyPS=con.prepareStatement(EditFacultyQuery);
		EditFacultyPS.setString(1,faculty3.getUserName());
		System.out.println(faculty3.getUserName());
		EditFacultyPS.setString(2,faculty3.getPassword());
		System.out.println(faculty3.getPassword());
		EditFacultyPS.setString(3,faculty3.getEmailId());
		System.out.println(faculty3.getEmailId());
		EditFacultyPS.setLong(4,faculty3.getPhoneNo());
		System.out.println(faculty3.getPhoneNo());
		EditFacultyPS.executeUpdate();
		con.commit();
		}
	catch(SQLException sql)
	{
		System.out.println(sql);
	}
	finally
	{
		if(con!=null)
		{
			con.close();
		}
		if(EditFacultyPS!=null)
		{
			EditFacultyPS.close();
		}
	}
	}
	public Faculty facultyView(Faculty faculty4) throws SQLException 
	{
		ConnectionManager conn=new ConnectionManager();
		con = conn.getConnection();
		Faculty faculty1=new Faculty();
		try
		{
		System.out.println("in dao");
		ViewFacultyPS=con.prepareStatement(ViewFacultyQuery);
		ViewFacultyPS.setInt(1,faculty4.getFacultyId());
		System.out.println("in dao hello");
		System.out.println(faculty4.getFacultyId());
		ResultSet rs=ViewFacultyPS.executeQuery();
	    con.commit();
	    while(rs.next())
	    {
	    	faculty1.setUserName(rs.getString("username"));
	    	faculty1.setPassword(rs.getString("password"));
	    	faculty1.setFacultyId(rs.getInt("faculty_id"));
	    	faculty1.setClassRoomId(rs.getInt("classroom_id"));
	    	faculty1.setPhoneNo(rs.getLong("phone_no"));
	    	faculty1.setEmailId(rs.getString("email_id"));
	    }
	    System.out.println(faculty1.getClassRoomId()+faculty1.getEmailId()+faculty1.getPhoneNo());
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		finally
		{
			if(con!=null)
			{
				con.close();
			}
			if(ViewFacultyPS!=null)
			{
				ViewFacultyPS.close();
			}
		}
	    return faculty1;
	}
	public int facultyPostQuestion(QuestionAndAnswer qa) throws SQLException 
	{
		
			ConnectionManager conn=new ConnectionManager();
			con = conn.getConnection();
			try
			{
				FacultyPostQuestionPS = con.prepareStatement(FacultyPostQuestionQuery);
				FacultyPostQuestionPS.setString(1,qa.getQuestion());
				FacultyPostQuestionPS.setString(2,"false");
			    result=FacultyPostQuestionPS.executeUpdate();
			}
			
			catch(SQLException e)
			{
				System.out.println("Exception occured while executing create operation");
				e.printStackTrace();
			}
			finally
			{
				con.close();
			}
			return result;
			
		
	}
	public ArrayList<QuestionAndAnswer> facultyViewQuestion() throws SQLException 
	{
		ConnectionManager conn=new ConnectionManager();
		con = conn.getConnection();
		ArrayList<QuestionAndAnswer> List=new ArrayList<QuestionAndAnswer>();
		QuestionAndAnswer QA=new QuestionAndAnswer();
		try
		{
		System.out.println("in dao");
		ViewQuestionFacultyPS=con.prepareStatement(ViewQuestionFacultyQuery);
		ResultSet rs=ViewQuestionFacultyPS.executeQuery();
	    con.commit();
	    while(rs.next())
	    {
			QA.setStudentId(rs.getInt("student_id"));
	    	QA.setQuestionId(rs.getInt("question_id"));
			QA.setQuestion(rs.getString("question"));
			QA.setAnswer(rs.getString("answer"));
			QA.setStatus(rs.getString("status"));
			 System.out.println(QA.getQuestion());
			List.add(QA);
	    }
	    System.out.println("hello");
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		finally
		{
			if(con!=null)
			{
				con.close();
			}
			if(ViewQuestionFacultyPS!=null)
			{
				ViewQuestionFacultyPS.close();
			}
		}
		return List;
	}
	public int facultyAnswerQuestion(QuestionAndAnswer QA1) throws SQLException 
	{
		ConnectionManager conn=new ConnectionManager();
		con = conn.getConnection();
		try
		{
			AnswerFacultyPS=con.prepareStatement(AnswerFacultyQuery);
			AnswerFacultyPS.setString(1,QA1.getAnswer());
			AnswerFacultyPS.setString(2,"true");
			AnswerFacultyPS.setInt(3,QA1.getQuestionId());
			result=AnswerFacultyPS.executeUpdate();
		}
		
		catch(SQLException e)
		{
			System.out.println("Exception occured while executing create operation");
			e.printStackTrace();
		}
		finally
		{
			con.close();
		}
		return result;
		
	
	}
}


