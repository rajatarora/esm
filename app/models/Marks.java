package models;

import java.util.*;
import javax.persistence.*;
import play.data.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity(name="Marks")
public class Marks extends Model {
	
	@Id
	@GeneratedValue
	public Long id;
	
	@Column(nullable=false)
	@ManyToOne
	public Exam exam;
	
	@Column(nullable=false)
	@ManyToOne
	public Student student;
	
	@Column(nullable=false)
	public int marks;
	
	public static Finder<Long,Marks> find = new Finder(Long.class,Marks.class);
}