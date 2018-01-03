package com.controller.student.servlets;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.student.classes.StudentOperations;
import com.controller.student.classes.StudentRegistrationModel;
import com.school.model.UserModel;
@WebServlet("/StudentRegistrationServlet")
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentRegistrationModel s=new StudentRegistrationModel();
		s.setLegacyId(request.getParameter("LegacyId"));
		s.setStudentname(request.getParameter("studentname"));
		s.setSex(request.getParameter("sex"));
		s.setSmotherlanguage(request.getParameter("Language"));
		s.setSethinicgroup(request.getParameter("SCast"));
		s.setSReligion(request.getParameter("SReligion"));
		s.setDob(request.getParameter("dob"));
		s.setDoben(request.getParameter("doben"));
		s.setBirthcertificateno(request.getParameter("birthcertificateno"));
		s.setBirthcertificateissuedby(request.getParameter("birthcertificateissuedby"));
		s.setBirthcertificateissueddate(request.getParameter("birthcertificateissueddate"));
		s.setBirthcertificateissueddateen(request.getParameter("birthcertificateissueddateen"));
		s.setDifferentlyabledYN(request.getParameter("DisabledYN"));
		s.setDifferentlyabledtype(request.getParameter("DisableType"));
		s.setDistrict(request.getParameter("District"));
		s.setVdcMun(request.getParameter("VdcMun"));
		s.setWardNo(request.getParameter("WardNo"));
		s.setTole(request.getParameter("tole"));
		s.setTempaddress(request.getParameter("tempaddress"));
		s.setFathername(request.getParameter("fathername"));
		s.setFaddress(request.getParameter("faddress"));
		s.setFoffice(request.getParameter("foffice"));
		s.setFposition(request.getParameter("fposition"));
		s.setFincome(request.getParameter("fincome"));
		s.setFmobile(request.getParameter("fmobile"));
		s.setFtelephone(request.getParameter("ftelephone"));
		s.setFemail(request.getParameter("femail"));
		s.setFephone(request.getParameter("fephone"));
		s.setMothername(request.getParameter("mothername"));
		s.setMaddress(request.getParameter("maddress"));
		s.setMoffice(request.getParameter("moffice"));
		s.setMposition(request.getParameter("mposition"));
		s.setMincome(request.getParameter("mincome"));
		s.setMmobile(request.getParameter("mmobile"));
		s.setMtelephone(request.getParameter("mtelephone"));
		s.setMemail(request.getParameter("memail"));
		s.setMephone(request.getParameter("mephone"));
		s.setLocal1(request.getParameter("local1"));
		s.setLocaladd1(request.getParameter("localadd1"));
		s.setLocalmob1(request.getParameter("localmob1"));
		s.setLocal2(request.getParameter("local2"));
		s.setLocaladd1(request.getParameter("localadd2"));
		s.setLocalmob2(request.getParameter("localmob2"));
		s.setAdmissionclass(request.getParameter("admissionclass"));
		s.setSection(request.getParameter("section"));
		s.setRollno(request.getParameter("rollno"));
		s.setHousegroup(request.getParameter("housegroup"));
		s.setOldschool(request.getParameter("oldschool"));
		s.setReasonleav(request.getParameter("reasonleav"));
		s.setHobby(request.getParameter("hobby"));
		s.setSpecialinterest(request.getParameter("specialinterest"));
		s.setRelaiontype1(request.getParameter("relationtype1"));
		s.setRelationtype2(request.getParameter("relationtype2"));
		s.setAdmissiondate(request.getParameter("admissiondate"));
		s.setAdmissiondateen(request.getParameter("admissiondateen"));
		HttpSession session=request.getSession(true);
		UserModel rs=(UserModel) session.getAttribute("userdetail");
		System.out.println(s.getFmobile());
		
		String inputter="";
			inputter = rs.getUsername();
	
		
		StudentOperations o=new StudentOperations();
		try{
		if(o.studentRegistration(s,inputter)==true)
		{
				String studentid=o.selectstudentid();
				o.insertfatherdetail(s, studentid);
				o.insertmotherdetail(s, studentid);
				o.insertbirthcertifiatedetail(s, studentid);
				o.insertaddressdetail(s, studentid);
				o.insertlocalguardiandetail1(s, studentid);
				o.insertlocalguardiandetail2(s, studentid);
				request.setAttribute("msg", "Successful!");
				RequestDispatcher rd=request.getRequestDispatcher("studentadmission.click");
				rd.forward(request,response);
		}
		else
		{
			request.setAttribute("msg", "Unsuccessful!");
			RequestDispatcher rd=request.getRequestDispatcher("studentregistrationjsp");
			rd.forward(request,response);
		}
		}catch(Exception e){
		
		}
	}

}
