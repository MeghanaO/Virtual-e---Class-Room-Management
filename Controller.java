package com.tcs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.bean.Faculty;
import com.tcs.bean.QuestionAndAnswer;
import com.tcs.bean.Student;
import com.tcs.service.FacultyService;
import com.tcs.service.StudentService;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		 HttpSession session=null;
		 ArrayList<QuestionAndAnswer> List1=null;
		 ArrayList<QuestionAndAnswer> List=null;
				System.out.println("StudentController::doPost invoked");
				String action=request.getParameter("action");
				System.out.println(" Student User action received by controller:"+ action);
				if("loginStudent".equals(action)){
					Student student1=new Student();
					student1.setStudentId(Integer.parseInt(request.getParameter("userid")));
					student1.setPassword(request.getParameter("password"));
					System.out.println(request.getParameter("userid"));
					System.out.println(request.getParameter("password"));
					StudentService studentService=new StudentService();
					try {
						int result=studentService.loginStudent(student1);
						System.out.println(result);
						if(result>0)
						{
							session = request.getSession(true);
							session.setAttribute("userid",request.getParameter("userid"));
							System.out.println(session.getAttribute("userid"));
							RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/StudentWelcome.jsp");
							rd.forward(request,response);
						}
						else{
							RequestDispatcher rd = request.getRequestDispatcher("/JSP/StudentRegister.jsp");
							PrintWriter out = response.getWriter();
							out.println("Please Register");
							rd.forward(request,response);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if("addStudent".equals(action))
				{
					Student student2=new Student();
					student2.setUserName(request.getParameter("username"));
					System.out.println(request.getParameter("username"));
					System.out.println(student2.getUserName());
					student2.setPassword(request.getParameter("password"));
					System.out.println(request.getParameter("password"));
					int classid1=Integer.parseInt(request.getParameter("classid"));
					student2.setClassRoomId(classid1);
					System.out.println(classid1);
					int facultyid1=Integer.parseInt(request.getParameter("facultyid"));
					student2.setFacultyId(facultyid1);
					System.out.println(facultyid1);
					Long phoneno1=Long.parseLong(request.getParameter("contactnumber"));
					student2.setPhoneNo(phoneno1);
					System.out.println(phoneno1);
					student2.setEmailId(request.getParameter("email"));
					System.out.println(request.getParameter("email"));
					System.out.println("in controller");
					
					StudentService studentService=new StudentService();
					int studentId=0;
					try {
						studentId=studentService.createStudentService(student2);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 System.out.println(studentId);
					request.setAttribute("studentid",studentId );
					RequestDispatcher req=request.getRequestDispatcher("/VILP/JSP/Home.jsp");
					req.forward(request, response);
				}
				else if("StudentPostQuestion".equals(action))
				{
					session=request.getSession(false);
					System.out.println("hello");
					QuestionAndAnswer qa=new QuestionAndAnswer();
					System.out.println(request.getParameter("post"));
					qa.setQuestion(request.getParameter("post"));
					System.out.println(session.getAttribute("userid"));
					qa.setStudentId(Integer.parseInt((String)session.getAttribute("userid")));
					StudentService studentService=new StudentService();
					int result=0;
					try {
						result = studentService.studentPostQuestion(qa);
						System.out.println(result);
						System.out.println(request.getParameter("post"));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(result>0)
					{
					RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/StudentPostSuccess.jsp");
					rd.forward(request,response);
					}
				}

			
	else if("EditStudent".equals(action))
	{
		Student student4=new Student();
		session=request.getSession(false);
		System.out.println("hello");
		System.out.println(session.getAttribute("userid"));
		student4.setStudentId(Integer.parseInt((String)session.getAttribute("userid")));
		student4.setUserName(request.getParameter("username"));
		student4.setPassword(request.getParameter("password"));
		student4.setEmailId(request.getParameter("email"));
		student4.setPhoneNo(Long.parseLong(request.getParameter("phonenumber")));
		StudentService studentService=new StudentService();
		try {
			studentService.studentEdit(student4);
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/StudentPostSuccess.jsp");
		rd.forward(request,response);
	}
	else if("StudentView".equals(action))
	{
		System.out.println("StudentController::doPost invoked");
		String action1=request.getParameter("action");
		System.out.println(" Student User action received by controller:"+ action1);
		Student student5=new Student();
		session=request.getSession(false);
		System.out.println(session.getAttribute("userid"));
		student5.setStudentId(Integer.parseInt((String)session.getAttribute("userid")));
		StudentService studentService=new StudentService();
		Student student6=new Student();
		try {
			 student6=studentService.studentView(student5);
			 System.out.println(student6.getUserName());
			 System.out.println(student6.getPhoneNo());
			 System.out.println(student6.getEmailId());
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("student6",student6);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/StudentViewProfile.jsp");
		rd.forward(request,response);
	}
	else if("StudentViewQuestion".equals(action))
	{
		System.out.println("in controller");
		Student student7=new Student();
		session=request.getSession(false);
		System.out.println(session.getAttribute("userid"));
		student7.setStudentId(Integer.parseInt((String)session.getAttribute("userid")));
		StudentService studentService=new StudentService();
		try {
			List=studentService.studentViewQuestion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("List", List);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/StudentViewQuestion.jsp");
		rd.forward(request,response);
	}
	else if("loginFaculty".equals(action)){
		Faculty faculty1=new Faculty();			
		faculty1.setFacultyId(Integer.parseInt(request.getParameter("userid")));
					faculty1.setPassword(request.getParameter("password"));
					System.out.println(request.getParameter("userid"));
					System.out.println(request.getParameter("password"));
					FacultyService facultyService=new FacultyService();
					try {
						int result=facultyService.loginFaculty(faculty1);
						System.out.println(result);
						if(result>0)
						{
							session = request.getSession(true);
							session.setAttribute("facultyuserid",request.getParameter("userid"));
							System.out.println(session.getAttribute("facultyuserid"));
							RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/FacultyHome.jsp");
							rd.forward(request,response);
						}
						else{
							RequestDispatcher rd = request.getRequestDispatcher("/JSP/FacultyRegister.jsp");
							PrintWriter out = response.getWriter();
							out.println("Please Register");
							rd.forward(request,response);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	else if("addFaculty".equals(action))
	{
		Faculty faculty2=new Faculty();
		faculty2.setUserName(request.getParameter("username"));
		System.out.println(request.getParameter("username"));
		System.out.println(faculty2.getUserName());
		faculty2.setPassword(request.getParameter("password"));
		System.out.println(request.getParameter("password"));
		int classid1=Integer.parseInt(request.getParameter("classid"));
		faculty2.setClassRoomId(classid1);
		System.out.println(classid1);
		Long phoneno1=Long.parseLong(request.getParameter("contactnumber"));
		faculty2.setPhoneNo(phoneno1);
		System.out.println(phoneno1);
		faculty2.setEmailId(request.getParameter("email"));
		System.out.println(request.getParameter("email"));
		System.out.println("in controller");
		
		FacultyService facultyService=new FacultyService();
		int facultyId=0;
		try {
			facultyId=facultyService.createFacultyService(faculty2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(facultyId);
		request.setAttribute("studentid",facultyId );
		RequestDispatcher req=request.getRequestDispatcher("/JSP/Home.jsp");
		req.forward(request, response);
	}
	else if("EditFaculty".equals(action))
	{
		Faculty faculty3=new Faculty();
		session=request.getSession(false);
		System.out.println("hello in controller");
		System.out.println(session.getAttribute("userid"));
		faculty3.setFacultyId(Integer.parseInt((String)session.getAttribute("facultyuserid")));
		faculty3.setUserName(request.getParameter("username"));
		System.out.println("username");
		faculty3.setPassword(request.getParameter("password"));
		faculty3.setEmailId(request.getParameter("email"));
		System.out.println("hyai");
		faculty3.setPhoneNo(Long.parseLong(request.getParameter("phonenumber")));
		
		FacultyService facultyService=new FacultyService();
		try {
			System.out.println("haaa");
			facultyService.facultyEdit(faculty3);
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/FacultyPostSuccess.jsp");
		rd.forward(request,response);
	}
	else if("FacultyView".equals(action))
	{
		System.out.println("StudentController::doPost invoked");
		String action1=request.getParameter("action");
		System.out.println(" Student User action received by controller:"+ action1);
		Faculty faculty4=new Faculty();
		session=request.getSession(false);
		System.out.println(session.getAttribute("facultyuserid"));
		faculty4.setFacultyId(Integer.parseInt((String)session.getAttribute("facultyuserid")));
		System.out.println(faculty4.getFacultyId());
		FacultyService facultyService=new FacultyService();
		Faculty faculty5=new Faculty();
		try {
			faculty5 = facultyService.FacultyView(faculty4);
			 System.out.println(faculty5.getUserName());
			 System.out.println(faculty5.getPhoneNo());
			 System.out.println(faculty5.getEmailId());
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("faculty5",faculty5);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/FacultyViewProfile.jsp");
		rd.forward(request,response);
	}
	else if("FacultyPostQuestion".equals(action))
	{
		session=request.getSession(false);
		System.out.println("hello");
		QuestionAndAnswer qa=new QuestionAndAnswer();
		System.out.println(request.getParameter("post"));
		qa.setQuestion(request.getParameter("post"));
		System.out.println(session.getAttribute("facultyuserid"));
		qa.setFacultyId(Integer.parseInt((String)session.getAttribute("facultyuserid")));
		FacultyService facultyService=new FacultyService();
		int result=0;
		try {
			result = facultyService.facultyPostQuestion(qa);
			System.out.println(result);
			System.out.println(request.getParameter("post"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>0)
		{
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/FacultyPostSuccess.jsp");
		rd.forward(request,response);
		}
	}
	else if("FacultyViewQuestion".equals(action))
	{
		System.out.println("in controller");
		Faculty faculty6=new Faculty();
		session=request.getSession(false);
		System.out.println(session.getAttribute("facultyuserid"));
		faculty6.setFacultyId(Integer.parseInt((String)session.getAttribute("facultyuserid")));
		FacultyService facultyService=new FacultyService();
		
		try {
			List1=facultyService.facultyViewQuestion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("List1", List1);
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/FacultyViewQuestion.jsp");
		rd.forward(request,response);
	}
	else if("FacultyAnswer".equals(action))
	{	
		System.out.println("in controller");
		QuestionAndAnswer QA1=new QuestionAndAnswer();
		QA1.setQuestionId(Integer.parseInt(request.getParameter("questionid")));
		session=request.getSession(false);
		System.out.println(session.getAttribute("facultyuserid"));
		QA1.setAnswer(request.getParameter("answer"));
		FacultyService facultyService=new FacultyService();
		int result=0;
		try {
			result = facultyService.facultyAnswerQuestion(QA1);
			System.out.println(result);
			System.out.println(request.getParameter("answer"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>0)
		{
		RequestDispatcher rd=getServletContext().getRequestDispatcher("/JSP/FacultyPostSuccess.jsp");
		rd.forward(request,response);
		}
	}
}
}


