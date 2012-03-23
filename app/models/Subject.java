package models;

import java.util.*;
import javax.persistence.*;
import play.data.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity(name="Subject")
public class Subject extends Model {
	
	@Id
	public String id;
	
	@Column(nullable=false)
	public String name;
	
	public static Finder<String,Subject> find = new Finder(String.class,Subject.class);
}