package models;

import java.util.*;
import javax.persistence.*;
import play.data.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity(name="Institute")
public class Institute extends Model {
	
	@Id
	public String id;
	
	@Column(nullable=false)
	@Required
	public String name;
	
	public static Finder<String,Institute> find = new Finder(String.class,Institute.class);
}