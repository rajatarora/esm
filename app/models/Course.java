package models;

import java.util.*;
import javax.persistence.*;
import play.data.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity(name="Course") 
public class Course extends Model {

	@Id
	public String id;
	
	@Column(nullable=false)
	@Required
	public String name;
	
	@Column(nullable=false)
	@Required
	public String type;
	
	@Column(nullable=false)
	@Required
	public int duration;
	
	@Column(nullable=false)
	@ManyToOne
	public Institute institute;
	
	
	
	public static List<Course> all() {
		return find.all();
	}
	
	public static Finder<String,Course> find = new Finder(String.class,Course.class);
}