package com.tcs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.bean.QuestionAndAnswer;
import com.tcs.bean.Student;
import com.tcs.connection.ConnectionManager;

public class StudentDAO 
{
	private Connection con=null;;
	private PreparedStatement StudentPostQuestionPS=null;
	private PreparedStatement StudentLoginPS=null;
	private PreparedStatement CreateStudentPS=null;
	private PreparedStatement selectStudentId=null;
	private PreparedStatement EditStudentPS=null;
	private PreparedStatement ViewStudentPS =null;
	private PreparedStatement ViewQuestionStudentPS= null;
	//private ResultSet rs=null;
	int result=0;
	String StudentPostQuestionQuery = "insert into QUESTIONANDANSWER(question_id,question,student_id,status) values(question_id.nextval,?,?,?)";
	String StudentLoginQuery="select student_id,password from student where student_id=? and password=?";
	String CreateStudentQuery=" insert into student values(student_id.nextval,?,?,?,?,?,?)";
	String EditStudentQuery="update student set username=?,password=?,email_id=?,phone_no=? where student_id=?";
	String ViewStudentQuery="select * from student where student_id=?";
	String ViewQuestionStudentQuery="select * from questionandanswer";
	public int studentPostQuestion(QuestionAndAnswer qa) throws SQLException {
		ConnectionManager conn=new ConnectionManager();
		con = conn.getConnection();
		try
		{
			StudentPostQuestionPS = con.prepareStatement(StudentPostQuestionQuery);
			StudentPostQuestionPS.setString(1,qa.getQuestion());
			StudentPostQuestionPS.setInt(2,qa.getStudentId());
			StudentPostQuestionPS.setString(3,"false");
		    result=StudentPostQuestionPS.executeUpdate();
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
	public int loginStudent(Student student) throws SQLException 
	{
		int result=0;
		ConnectionManager conn=new ConnectionManager();
		con = conn.getConnection();
		try
		{
			StudentLoginPS = con.prepareStatement(StudentLoginQuery);
			StudentLoginPS.setInt(1,student.getStudentId());
			StudentLoginPS.setString(2,student.getPassword());
			System.out.println(student.getStudentId());
			System.out.println(student.getPassword());
		   ResultSet rs=StudentLoginPS.executeQuery();
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
	public int createStudent(Student student) throws SQLException,ClassNotFoundException
	{
		ConnectionManager conn=new ConnectionManager();
		con = conn.getConnection();	
	int stdId=0;
		try
		{	System.out.println(student.getUserName());
			System.out.println("in dao");
			CreateStudentPS=con.prepareStatement(CreateStudentQuery);
			CreateStudentPS.setString(1,student.getUserName());
			System.out.println(student.getUserName());
			CreateStudentPS.setString(2,student.getPassword());
			System.out.println(student.getPassword());
			CreateStudentPS.setInt(3,student.getClassRoomId());
			System.out.println(student.getClassRoomId());
			CreateStudentPS.setInt(4,student.getFacultyId());
			System.out.println(student.getFacultyId());
			CreateStudentPS.setString(5,student.getEmailId());
			System.out.println(student.getEmailId());
			CreateStudentPS.setLong(6,student.getPhoneNo());
			System.out.println(student.getPhoneNo());
			System.out.println(CreateStudentPS);
			int result=CreateStudentPS.executeUpdate();
			con.commit();
			if(result>0)
			selectStudentId=con.prepareStatement("select student_id.currval as id from dual");
			ResultSet rs=selectStudentId.executeQuery();
			while (rs.next())
			{
				stdId=rs.getInt(1);
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
			if(CreateStudentPS!=null)
			{
				CreateStudentPS.close();
			}
		}
		return stdId;

}
	public void studentEdit(Student student) throws SQLException 
	{
		ConnectionManager conn=new ConnectionManager();
		con = conn.getConnection();
		try
		{
		System.out.println("in dao");
		EditStudentPS=con.prepareStatement(EditStudentQuery);
		EditStudentPS.setString(1,student.getUserName());
		System.out.println(student.getUserName());
		EditStudentPS.setString(2,student.getPassword());
		System.out.println(student.getPassword());
		EditStudentPS.setString(3,student.getEmailId());
		System.out.println(student.getEmailId());
		EditStudentPS.setLong(4,student.getPhoneNo());
		System.out.println(student.getPhoneNo());
		EditStudentPS.setInt(5,student.getStudentId());
		System.out.println(student.getStudentId());
		System.out.println(EditStudentPS);
		EditStudentPS.executeUpdate();
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
		if(EditStudentPS!=null)
		{
			EditStudentPS.close();
		}
	}
	}
	public Student studentView(Student student) throws SQLException 
	{
		ConnectionManager conn=new ConnectionManager();
		con = conn.getConnection();
		Student student1=new Student();
		try
		{
		System.out.println("in dao");
		ViewStudentPS=con.prepareStatement(ViewStudentQuery);
		ViewStudentPS.setInt(1,student.getStudentId());
		System.out.println("in dao hello");
		System.out.println(student.getStudentId());
		ResultSet rs=ViewStudentPS.executeQuery();
	    con.commit();
	    while(rs.next())
	    {
			student1.setUserName(rs.getString("username"));
			student1.setPassword(rs.getString("password"));
			student1.setFacultyId(rs.getInt("faculty_id"));
			student1.setClassRoomId(rs.getInt("classroom_id"));
			student1.setPhoneNo(rs.getLong("phone_no"));
			student1.setEmailId(rs.getString("email_id"));
	    }
	    System.out.println(student1.getClassRoomId()+student1.getEmailId()+student1.getPhoneNo());
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
			if(ViewStudentPS!=null)
			{
				ViewStudentPS.close();
			}
		}
	    return student1;
	    }
	public ArrayList<QuestionAndAnswer> studentViewQuestion() throws SQLException 
	{
		ConnectionManager conn=new ConnectionManager();
		con = conn.getConnection();
		ArrayList<QuestionAndAnswer> List=new ArrayList<QuestionAndAnswer>();
		QuestionAndAnswer QA=new QuestionAndAnswer();
		try
		{
		System.out.println("in dao");
		ViewQuestionStudentPS=con.prepareStatement(ViewQuestionStudentQuery);
		ResultSet rs=ViewQuestionStudentPS.executeQuery();
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
			if(ViewQuestionStudentPS!=null)
			{
				ViewQuestionStudentPS.close();
			}
		}
		return List;
	}
}
