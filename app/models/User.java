package models;

import java.util.*;
import javax.persistence.*;
import play.data.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity(name="User")
public class User extends Model {
	
	@Id
	public String id;
	
	@Column(nullable=false)
	public String password;
	
	@Column(nullable=false)
	public Enums.userRole role;
	
	public static Finder<String,User> find = new Finder(String.class,User.class);
	
	/* User Authentication */
	public static boolean userExists(String id, String password) {
		User u = find.where()
					.eq("id",id)
					.eq("password",password)
				.findUnique();
		if(u == null) return false;
		return true;
	}
	
	/* Get the user role */
	public static Enums.userRole getRole(String id) {
		User u = find
				.fetch("role")
				.where()
				.eq("id",id)
				.findUnique();
		return u.role;
	}
}