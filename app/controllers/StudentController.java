package controllers;

import play.*;
import play.mvc.*;
import views.html.*;
import models.*;

import java.util.*;

public class StudentController extends Controller {
	
	public static Result getAll() {
		return ok(views.html.student1.render(Student.all()));
	}

	/* Get the timetable allotted to a certain student */
	public static Result getTimeTable() {
	
		/* Check if a user is logged in */
		if(!Application.loggedIn()) {
			flash("loginError","Please login first");
			return ok(
				login.render(form(Application.Login.class))
			);
		}

		/* Check if the logged in user is a student */
		String username = session("username");
		Enums.userRole role = User.getRole(username);
		if(role != Enums.userRole.STUDENT) {
			session().clear();
			flash("loginError","You aren't logged in as STUDENT");
			flash("logoutNotice","You are now logged out");
			return ok(
				login.render(form(Application.Login.class))
			);
		}

		/* Display the student's timetable */
		List<EClass> cl = models.Student.getClassesByUsername(username);
		int classSize = cl.size();
		String classId = cl.get(classSize-1).id;
		
		List<TimeSlot> timeTable = TimeSlot.getTimeTable(classId);
		
		List<TeacherAssignment> teacherAssignments = TeacherAssignment.getTAByClassId(classId);
		List<Teacher> teachers = new ArrayList();
		
		for(int i=0; i<teacherAssignments.size(); i++) {
			Teacher t = teacherAssignments.get(i).teacher;
			teachers.add(Teacher.getById(t.id));
		}

		List<Room> rooms = new ArrayList();

		for(int i=0; i<timeTable.size(); i++) {
			Room r = timeTable.get(i).room;
			rooms.add(Room.getById(r.id));
		}

		HashSet set = new HashSet(rooms);
		rooms.clear();
		rooms.addAll(set);
		
		return ok(
			student.render(timeTable,teachers,teacherAssignments,rooms)
		);
	}
	
}
