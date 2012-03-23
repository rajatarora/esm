package models;

import java.util.*;
import javax.persistence.*;
import play.data.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity(name="Class")
public class Class extends Model {
	
	@Id
	public String id;
	
	@Column(nullable=false)
	@ManyToOne
	public Course course;
	
	@Column(nullable=false)
	public int semester;
	
	public static Finder<String,Class> find = new Finder(String.class,Class.class);
}