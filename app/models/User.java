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
	public static User authenticate(String id, String password) {
		return find.where()
				.eq("id",id)
				.eq("password",password)
				.findUnique();
	}
}