package models;

import java.util.*;
import javax.persistence.*;
import play.data.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity(name="TimeSlot")
public class TimeSlot extends Model {
	
	@Id
	@GeneratedValue
	public Long id;
	
	@Column(nullable=false)
	@ManyToOne
	@Required
	public Class c;
	
	@Column(nullable=false)
	@Required
	public Enums.dayOfWeek day;
	
	@Column(nullable=false)
	@ManyToOne
	@Required
	public Paper paper;
	
	@Column(nullable=false)
	@Required
	public Enums.timeSlot start;
	
	@Column(nullable=false)
	@Required
	public Enums.timeSlot end;
	
	@Column(nullable=false)
	@ManyToOne
	@Required
	public Room room;
	
	public static Finder<Long,TimeSlot> find = new Finder(Long.class,TimeSlot.class);
}