package models;

import java.util.*;
import javax.persistence.*;
import play.data.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity(name="Paper")
public class Paper extends Model {
	
	@Id
	public String id;
	
	@Column(nullable=false)
	@ManyToOne
	@Required
	public Subject subject;
	
	@Column(nullable=false)
	@ManyToOne
	@Required
	public Class c;
	
	public static Finder<String,Paper> find = new Finder(String.class,Paper.class);
}