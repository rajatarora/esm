package models;

import java.util.*;
import javax.persistence.*;
import play.data.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity(name="Student")
public class Student extends Model {
	
	@Id
	public String id;
	
	@Column(nullable=false)
	@Required
	public String name;
	
	@Column(nullable=false)
	@Required
	public Date dateOfBirth;
	
	@Column(nullable=false)
	@Required
	public String courseId;
	
	public String phoneNo;
	
	@Column(nullable=false)
	@Required
	public String address;
	
	public String email;
	
	@Column(nullable=false)
	@Required
	public String libraryNo;
	
	@Column(nullable=false)
	@ManyToOne
	public Institute institute;
	
	@Column(nullable=false)
	@Required
	public int Year;
	
	@Column(nullable=false)
	@ManyToOne
	public Class inClass;
	
	@Column(nullable=false)
	@OneToOne
	public User user;
	
	public static List<Student> all() {
		return find.all();
	}
	
	public static Finder<String,Student> find = new Finder(String.class,Student.class);
}