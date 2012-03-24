package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import models.*;

import views.html.*;

public class Application extends Controller {
	
	public static class Login {
		public String username;
		public String password;
	}
	
	public static Result login() {
		String username = session("username");
		if(username == null) {
			return ok(
				login.render(form(Login.class))
			);
		}
		return redirect(routes.Application.dashboard());
	}
	
	public static Result dashboard() {
	String username = session("username");
		if(username == null) {
			return ok(
				login.render(form(Login.class))
			);
		}
		return ok("Logged in " + username);
	}
	
	public static Result authenticate() {
		Form<Login> loginForm = form(Login.class).bindFromRequest();
		String username = loginForm.get().username;
		String password = loginForm.get().password;
		if(User.userExists(username,password))
			session("username",username);
		else flash("loginError","Invalid username or password");
		return redirect(routes.Application.login());
	}
	
	public static Result logout() {
		session().clear();
		return redirect(routes.Application.login());
	}
}