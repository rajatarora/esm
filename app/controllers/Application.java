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
		if(!loggedIn()) {
			return ok(
				login.render(form(Login.class))
			);
		}
		else {
			String username = session("username");
			Enums.userRole role = User.getRole(username);
			return ok("Logged in " + username + " role = " + role);
		}
		//return redirect(routes.Application.dashboard());
	}
	
	public static Result dashboard() {
		if(!loggedIn()) {
			return ok(
				login.render(form(Login.class))
			);
		}
		return ok("logged in");
	}
	
	public static Result authenticate() {
		Form<Login> loginForm = form(Login.class).bindFromRequest();
		String username = loginForm.get().username;
		String password = loginForm.get().password;
		if(User.exists(username,password))
			session("username",username);
		else flash("loginError","Invalid username or password");
		return redirect(routes.Application.login());
	}
	
	public static Result logout() {
		if(loggedIn()) {
			session().clear();
			flash("logoutNotice","You have been logged out");
		}
		return redirect(routes.Application.login());
	}

	public static boolean loggedIn() {
		String username = session("username");
		if(username == null) return false;
		return true;
	}
}
