package models;

import java.util.*;
import javax.persistence.*;
import play.data.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity(name="Exam")
public class Exam extends Model {
	
	@Id
	public String id;
	
	@Column(nullable=false)
	@ManyToOne
	public Paper paper;
	
	@Column(nullable=false)
	public Enums.examType eType;
	
	@Column(nullable=false)
	@ManyToOne
	public Class c;
	
	public static Finder<String,Exam> find = new Finder(String.class,Exam.class);
}