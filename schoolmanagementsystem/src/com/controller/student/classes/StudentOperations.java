package com.controller.student.classes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.school.model.StudentModel;
import com.school.dbconnection.DbConnection;
//import com.controller.dbconnect.Dbconnect;
public class StudentOperations {
	Connection conn=null;
	Statement stmt=null;
	ResultSet r=null;
	PreparedStatement ps=null;
	
	public String totalstudents() throws SQLException{
		String query="select count(*) as totalstudents from studentinfo";
		String total="";
		try{
			conn=DbConnection.getConnection();
			ps=conn.prepareStatement(query);
			r=ps.executeQuery();
			while(r.next()){
				total=r.getString("totalstudents");
			}
		}
		catch(Exception e){
			System.out.println("totalstudents error"+e);
		}
		finally{
			if(r!=null){
				r.close();
			}
		}
		return total;
	}
	public boolean studentRegistration(StudentRegistrationModel s, String inputter){
		boolean status=false;
		String query="insert into studentinfo(LegacyId,studentname,sex,smotherlanguage,sethinicgroup,sreligion,dob,doben,differentlyabledYN,differentlyabledtype,admissionclass,section,rollno,housegroup,oldschool,reasonleav,hobby,specialinterest,inputter,entrydate,admissiondate,admissiondateen)values('"+s.getLegacyId()+"','"+s.getStudentname()+"','"+s.getSex()+"','"+s.getSmotherlanguage()+"','"+s.getSethinicgroup()+"','"+s.getSReligion()+"','"+s.getDob()+"','"+s.getDoben()+"','"+s.getDifferentlyabledYN()+"','"+s.getDifferentlyabledtype()+"','"+s.getAdmissionclass()+"','"+s.getSection()+"','"+s.getRollno()+"','"+s.getHousegroup()+"','"+s.getOldschool()+"','"+s.getReasonleav()+"','"+s.getHobby()+"','"+s.getSpecialinterest()+"','"+inputter+"',CURDATE(),'"+s.getAdmissiondate()+"','"+s.getAdmissiondateen()+"')";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(query);
			status=true;
			System.out.println("Studentinfo Registered !");
		}
		catch(Exception e){
			System.out.println("StudentOperatins.studentRegistration error"+e);
		}
		return status;
	}
	public String selectstudentid(){
		ResultSet rs=null;
		String maxid="";
		String query="select max(studentid) from studentinfo";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()){
				maxid=rs.getString("max(studentid)");
			}
		}
		catch(Exception e){
			System.out.println("StudentOperations.selectstudentid error"+e);
		}
		return maxid;
	}
	public void insertfatherdetail(StudentRegistrationModel s,String studentid){
		String query="insert into sfatherdetailtbl(studentid,fathername,faddress,foffice,fposition,fincome,fmobile,ftelephone,femail,fephone,fcitizenshipno,fcitizenshipissuedby,fcitizenshipissueddate,fcitizenshipissueddateen,flicenseno,flicenseissuedby,flicenseissueddate,flicenseissueddateen,fofficialidno,fofficialidissuedby,fofficialidissueddate,fofficialidissueddateen,fvoteridno,fvoteridissuedby,fvoteridissueddate,fvoteridissueddateen,fpassportno,fpassportissuedby,fpassportissueddate,fpassportissueddateen)values('"+studentid+"','"+s.getFathername()+"','"+s.getFaddress()+"','"+s.getFoffice()+"','"+s.getFposition()+"','"+s.getFincome()+"','"+s.getFmobile()+"','"+s.getFtelephone()+"','"+s.getFemail()+"','"+s.getFephone()+"','"+s.getFcitizenshipno()+"','"+s.getFcitizenshipissuedby()+"','"+s.getFcitizenshipissueddate()+"','"+s.getFcitizenshipissueddateen()+"','"+s.getFlicenseno()+"','"+s.getFlicenseissuedby()+"','"+s.getFlicenseissueddate()+"','"+s.getFlicenseissueddateen()+"','"+s.getFofficialidno()+"','"+s.getFofficialidissuedby()+"','"+s.getFofficialidissueddate()+"','"+s.getFofficialidissueddateen()+"','"+s.getFvoteridno()+"','"+s.getFvoteridissuedby()+"','"+s.getFvoteridissueddate()+"','"+s.getFvoteridissueddateen()+"','"+s.getFpassportno()+"','"+s.getFpassportissuedby()+"','"+s.getFpassportissueddate()+"','"+s.getFpassportissueddateen()+"')";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(query);		
			System.out.println("father detail inserted");
		}
		catch(Exception e){
			System.out.println("StudentOperations.insertfatherdetail error"+e);
		}
	}
	public void insertmotherdetail(StudentRegistrationModel s,String studentid){
		String query="insert into smotherdetailtbl(studentid,mothername,maddress,moffice,mposition,mincome,mmobile,mtelephone,memail,mephone,mcitizenshipno,mcitizenshipissuedby,mcitizenshipissueddate,mcitizenshipissueddateen,mlicenseno,mlicenseissuedby,mlicenseissueddate,mlicenseissueddateen,mofficialidno,mofficialidissuedby,mofficialidissueddate,mofficialidissueddateen,mvoteridno,mvoteridissuedby,mvoteridissueddate,mvoteridissueddateen,mpassportno,mpassportissuedby,mpassportissueddate,mpassportissueddateen)values('"+studentid+"','"+s.getMothername()+"','"+s.getMaddress()+"','"+s.getMoffice()+"','"+s.getMposition()+"','"+s.getMincome()+"','"+s.getMmobile()+"','"+s.getMtelephone()+"','"+s.getMemail()+"','"+s.getMephone()+"','"+s.getMcitizenshipno()+"','"+s.getMcitizenshipissuedby()+"','"+s.getMcitizenshipissueddate()+"','"+s.getMcitizenshipissueddateen()+"','"+s.getMlicenseno()+"','"+s.getMlicenseissuedby()+"','"+s.getMlicenseissueddate()+"','"+s.getMlicenseissueddateen()+"','"+s.getMofficialidno()+"','"+s.getMofficialidissuedby()+"','"+s.getMofficialidissueddate()+"','"+s.getMofficialidissueddateen()+"','"+s.getMvoteridno()+"','"+s.getMvoteridissuedby()+"','"+s.getMvoteridissueddate()+"','"+s.getMvoteridissueddateen()+"','"+s.getMpassportno()+"','"+s.getMpassportissuedby()+"','"+s.getMpassportissueddate()+"','"+s.getMpassportissueddateen()+"')";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(query);	
			System.out.println("mother detail inserted");
		}
		catch(Exception e){
			System.out.println("StudentOperations.insertmotherdetail error"+e);
		}
	}
	public void insertbirthcertifiatedetail(StudentRegistrationModel s,String studentid){
		String query="insert into sbirthcertificatetbl(studentid,sbirthcertificateno,sbirthcertificateissuedby,sbirthcertificateissueddate,sbirthcertificateissueddateen)values('"+studentid+"','"+s.birthcertificateno+"','"+s.birthcertificateissuedby+"','"+s.birthcertificateissueddate+"','"+s.birthcertificateissueddateen+"') ";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(query);	
			System.out.println("birthcertificate detail inserted");
		}
		catch(Exception e){
			System.out.println("StudentOperations.insertbirthcertificatedetail error"+e);
		}
	}
	public void insertaddressdetail(StudentRegistrationModel s,String studentid){
		String query="insert into saddresstbl(studentid,District,VdcMun, Wardno,tole,tempaddress)values('"+studentid+"','"+s.getDistrict()+"','"+s.getVdcMun()+"','"+s.getWardNo()+"','"+s.getTole()+"','"+s.getTempaddress()+"')";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(query);	
			System.out.println("address detail inserted");
		}
		catch(Exception e){
			System.out.println("StudentOperations.insertaddressdetail error"+e);
		}
	}
	public void insertlocalguardiandetail1(StudentRegistrationModel s,String studentid){
		String query="insert into slocalguardiantbl(studentid,localguardianname,localadd,relationtype,localmob)values('"+studentid+"','"+s.getLocal1()+"','"+s.getLocaladd1()+"','"+s.getRelaiontype1()+"','"+s.getLocalmob1()+"')";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(query);	
			System.out.println("localguardian detail inserted");
		}
		catch(Exception e){
			System.out.println("StudentOperations.insertlocalguardiandetail error"+e);
		}
	}
	public void insertlocalguardiandetail2(StudentRegistrationModel s,String studentid){
		String query="insert into slocalguardiantbl(studentid,localguardianname,localadd,relationtype,localmob)values('"+studentid+"','"+s.getLocal2()+"','"+s.getLocaladd2()+"','"+s.getRelationtype2()+"','"+s.getLocalmob2()+"')";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(query);	
			System.out.println("localguardian detail inserted");
		}
		catch(Exception e){
			System.out.println("StudentOperations.insertlocalguardiandetail error"+e);
		}
	}
	
	public ResultSet districts(){
		ResultSet rs=null;
		String query="select * from schoolmanagementsystemdb.districtcodes";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			 rs=stmt.executeQuery(query);
		}
		catch(Exception e){
			System.out.println("StudentOperations.districts error"+e);
		}
		
		return rs;
	}
	public ResultSet disabletypelist(){
		ResultSet rs=null;
		String query="select * from schoolmanagementsystemdb.disabledtype";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			 rs=stmt.executeQuery(query);
		}
		catch(Exception e){
			System.out.println("StudentOperations.districts error"+e);
		}
		
		return rs;
	}
	public List<StudentModel> studentDetails(){
		List<StudentModel> list=new ArrayList<StudentModel>();
		StudentModel sm=null;
		String query="select * from studentinfo;";
		try{
			conn=DbConnection.getConnection();
			if(conn!=null){
				ps=conn.prepareStatement(query);
				r=ps.executeQuery(query);
				while(r.next()){
					sm=new StudentModel();
					sm.setAdmissionclass(r.getString("admissionclass"));
					sm.setAdmissiondate(r.getString("admissiondate"));
					sm.setRollno(r.getString("rollno"));
					sm.setSection(r.getString("section"));
					sm.setStudentid(r.getString("studentid"));
					sm.setStudentname(r.getString("studentname"));
					list.add(sm);
				}
				if(list.size()>0){
					conn.close();
					ps=null;
					r=null;
					return list;
				}
			}
			else{
				System.out.println("connection is null");
			}
			
		}
		catch(Exception e){
			System.out.println("StudentOperations.studentDetails error"+e);
		}
		return null;
		
	}
	public boolean deletelanguage(String id) {
		boolean status = false;
		return status;
	}
	public ResultSet registeredstudentdetail(String studentid){
		String query="select *,sfatherdetailtbl.*,smotherdetailtbl.*,sbirthcertificatetbl.*,saddresstbl.* from studentinfo join sfatherdetailtbl on studentinfo.studentid=sfatherdetailtbl.studentid JOIN smotherdetailtbl on studentinfo.studentid=smotherdetailtbl.studentid JOIN  sbirthcertificatetbl on studentinfo.studentid=sbirthcertificatetbl.studentid JOIN saddresstbl on studentinfo.studentid=saddresstbl.studentid where studentinfo.studentid='"+studentid+"'";
		ResultSet rs=null;
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
		}
		catch(Exception e){
			System.out.println("StudentOperations.registeredstudentdetails error"+e);
		}
		return rs;
	}
	public ResultSet getlanguage(){
		String query="select * from languagetbl";
		ResultSet rs=null;
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
		}
		catch(Exception e){
			System.out.println("StudentOperations.getlanguage error"+e);
		}
		return rs;
	}
	public ResultSet getcaste(){
		String query="select * from castetbl";
		ResultSet rs=null;
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
		}
		catch(Exception e){
			System.out.println("StudentOperations.getcaste error"+e);
		}
		return rs;
	}
	public ResultSet getsection(){
		String query="select * from sectiontbl";
		ResultSet rs=null;
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
		}
		catch(Exception e){
			System.out.println("StudentOperations.getsection error"+e);
		}
		return rs;
	}
	public ResultSet gethousegroup(){
		String query="select * from housegrouptbl";
		ResultSet rs=null;
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
		}
		catch(Exception e){
			System.out.println("StudentOperations.gethousegroup error"+e);
		}
		return rs;
	}
	public ResultSet getspecialinterest(){
		String query="select * from specialinteresttbl";
		ResultSet rs=null;
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
		}
		catch(Exception e){
			System.out.println("StudentOperations.getspecialinterest error"+e);
		}
		return rs;
	}
//Add initial Details
	public void addlanguage(String languagename){
		String query="insert into languagetbl(languagename) values ('"+languagename+"')";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(query);
		}
		catch(Exception e){
			System.out.println("StudentOperations.addlanguage error"+e);
		}
	}
	public void addcaste(String castename){
		String query="insert into castetbl(castename) values ('"+castename+"')";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(query);
		}
		catch(Exception e){
			System.out.println("StudentOperations.addcaste error"+e);
		}
	}
	public void addsection(String sectionname){
		String query="insert into sectiontbl(sectionname) values ('"+sectionname+"')";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(query);
		}
		catch(Exception e){
			System.out.println("StudentOperations.addsection error"+e);
		}
	}
	public void addhousegroup(String housegroupname){
		String query="insert into housegrouptbl(housegroupname) values ('"+housegroupname+"')";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(query);
		}
		catch(Exception e){
			System.out.println("StudentOperations.addhousegroup error"+e);
		}
	}
	public void addspecialinterest(String specialinterestname){
		String query="insert into specialinteresttbl(specialinterestname) values ('"+specialinterestname+"')";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(query);
		}
		catch(Exception e){
			System.out.println("StudentOperations.addspecialinterest error"+e);
		}
	}
	public void addexamtype(String examtypename, String description) throws SQLException{
		String query="insert into exam_type(examtypename, description) values ('"+examtypename+"','"+description+"')";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(query);
		}
		catch(Exception e){
			System.out.println("StudentOperations.addspecialinterest error"+e);
		}
		finally{
			if(conn!=null){
				conn.close();
			}
			if(stmt!=null){
				stmt.close();
			}
		}
	}
	public boolean addsubject(String subjectname,String subjecttype){
		boolean status=false;
		int a;
		String query="insert into subjectlist(subjectname,subjecttype) values ('"+subjectname+"','"+subjecttype+"')";
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			a=stmt.executeUpdate(query);
			if(a>0){
				status=true;
			}
		}
		catch(Exception e){
			System.out.println("StudentOperations.addsubject error"+e);
		}
		return status;
	}
	public ResultSet selectsubject(){
		String query="select * from subjectlist";
		ResultSet rs=null;
		try{
			conn=DbConnection.getConnection();
			Statement stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
		}
		catch(Exception e){
			System.out.println("StudentOperations.selectsubject error"+e);
		}
		return rs;
	}
	public ResultSet selectclass(){
		ResultSet rs=null;
		String query="select * from classlist";
		try{
			conn=DbConnection.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
		}
		catch(Exception e){
			System.out.println("selectclass error"+e);
		}
		return rs;
	}
	public ResultSet selectexamtype(){
		ResultSet rs=null;
		String query="select * from exam_type";
		try{
			conn=DbConnection.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
		}
		catch(Exception e){
			System.out.println("selectexamtype error"+e);
		}
		return rs;
	}
	public ResultSet selectexam(){
		ResultSet rs=null;
		String query="select *,exam_type.examtypename from exam join exam_type on exam.examtypeid=exam_type.examtypeid";
		try{
			conn=DbConnection.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(query);
		}
		catch(Exception e){
			System.out.println("selectexam error"+e);
		}
		return rs;
	}

	public void addclass(String classname) {
		String query="insert into classlist (classname) values ('"+classname+"')";
		try{
			conn=DbConnection.getConnection();
			stmt=conn.createStatement();
			stmt.executeUpdate(query);
		}
		catch(Exception e){
			System.out.println("addclass error"+e);
		}
	}
	public boolean deletesubject(String subjectid) {
		boolean status=false;
		int a;
		String query="delete from subjectlist where subjectid='"+subjectid+"'";
		try{
			conn=DbConnection.getConnection();
			stmt=conn.createStatement();
			a=stmt.executeUpdate(query);
			if(a>0){
				status=true;
			}
		}
		catch(Exception e){
			System.out.println("deletesubject error"+e);
		}
		finally{
			if(conn!=null){
				try{
				conn.close();
				System.out.println("connection closed");
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
			if(stmt!=null){
				try{
				stmt.close();
				System.out.println("statement closed");
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
		}
		return status;
	}
	public boolean deleteexam(String id) throws SQLException {
		boolean status=false;
		int a;
		String query="delete from exam where examid='"+id+"'";
		try{
			conn=DbConnection.getConnection();
			stmt=conn.createStatement();
			a=stmt.executeUpdate(query);
			if(a>0){
				status=true;
			}
		}
		catch(Exception e){
			System.out.println("deleteexam error"+e);
		}
		finally{
			if(conn!=null){
				conn.close();
			}
			if(stmt!=null){
				stmt.close();
			}
		}
		return status;
	}
	public boolean createnewexam(Model m) throws SQLException {
		int a;
		boolean status=false;
		String query="insert into exam (examtypeid,examname,startdate) values('"+m.getExamtype()+"','"+m.getExamname()+"','"+m.getStartdate()+"')";
		try{
			conn=DbConnection.getConnection();
			stmt=conn.createStatement();
			a=stmt.executeUpdate(query);
			if(a>0){
				status=true;
			}
		}
		catch(Exception e){
			System.out.println("createnewnexam error"+e);
		}
		finally{
			if(conn!=null){
				conn.close();
			}
			if(stmt!=null){
				stmt.close();
			}
		}
		return status;
	}
	public boolean deleteStudent(String studentid) {
		
		try{
			String query1="delete from studentinfo where studentid='"+studentid+"'",
			query2="delete from sbirthcertificatetbl where studentid='"+studentid+"'",
			query3="delete from sfatherdetailtbl where studentid='"+studentid+"'",
			query4="delete from slocalguardiantbl where studentid='"+studentid+"'",
			query5="delete from smotherdetailtbl where studentid='"+studentid+"'";
			conn=DbConnection.getConnection();
			stmt=conn.createStatement();
			stmt.addBatch(query1);
			stmt.addBatch(query2);
			stmt.addBatch(query3);
			stmt.addBatch(query4);
			stmt.addBatch(query5);
			int i[]=stmt.executeBatch();
			if(i.length==5){
				conn.close();
				ps=null;
				return true;
			}
		}
		catch(Exception e){}
		return false;
	}
	
	//examination 
	public ResultSet getClassSubjects(){
		ResultSet rs=null;
		String query="select * from coursetbl where gradeid=?";
		try{
			conn=DbConnection.getConnection();
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
		}
		catch(Exception e){
			System.out.println("selectclass error"+e);
		}
		return rs;
	}
	
}
