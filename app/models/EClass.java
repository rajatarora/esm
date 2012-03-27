package models;

import java.util.*;
import javax.persistence.*;
import play.data.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity(name="EClass")
public class EClass extends Model {
	
	@Id
	public String id;
	
	@Column(nullable=false)
	@ManyToOne
	public Course course;
	
	@Column(nullable=false)
	public int semester;

	@Column(nullable=false)
	public int year;

	public static Finder<String,EClass> find = new Finder(String.class,EClass.class);
}
