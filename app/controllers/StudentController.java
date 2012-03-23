package controllers;

import play.*;
import play.mvc.*;
import views.html.*;
import models.Student;

public class StudentController extends Controller {
	
	public static Result getAll() {
		return ok(views.html.student.render(Student.all()));
	}
	
}