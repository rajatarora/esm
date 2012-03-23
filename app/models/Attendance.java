package models;

import java.util.*;
import javax.persistence.*;
import play.data.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity(name="Attendance")
public class Attendance extends Model {
	
	@Id
	@GeneratedValue
	public Long id;
	
	@Column(nullable=false)
	@Required
	public Date date;
	
	@Column(nullable=false)
	@ManyToOne
	@Required
	public Student student;
	
	@Column(nullable=false)
	@ManyToOne
	@Required
	public TimeSlot timeSlot;
	
	@Column(nullable=false)
	@Required
	public boolean present;
	
	public static Finder<Long,Attendance> find = new Finder(Long.class,Attendance.class);
}