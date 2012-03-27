package models;

import java.util.*;
import javax.persistence.*;
import play.data.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity(name="Teacher") 
public class Teacher extends Model {
	
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
	public int yearOfJoining;
	
	@Column(nullable=false)
	@Enumerated
	@Required
	public Enums.teacherGrade tGrade;
	
	public String roomNo;
	
	@Column(nullable=false)
	@Required
	public String phoneNo;
	
	@Column(nullable=false)
	@Required
	@Email
	public String email;
	
	@Column(nullable=false)
	@ManyToOne
	@Required
	public Institute institute;
	
	@Column(nullable=false)
	@OneToOne
	public User user;
	
	@Column(nullable=false)
	@ManyToMany
	@Required
	public List<Subject> subjects;

	public static Teacher getById(String teacherId) {
		return find
				.where()
				.eq("id",teacherId)
				.findUnique();
	}
	
	public static Finder<String,Teacher> find = new Finder(String.class,Teacher.class);
}
