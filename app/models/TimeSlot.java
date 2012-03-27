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
	public EClass c;
	
	@Column(nullable=false)
	@Required
	public int day;
	
	@Column(nullable=false)
	@ManyToOne
	@Required
	public Paper paper;
	
	@Column(nullable=false)
	@Required
	public int start;
	
	@Column(nullable=false)
	@Required
	public int end;
	
	@Column(nullable=false)
	@ManyToOne
	@Required
	public Room room;

	
	public static List<TimeSlot> getTimeTable(String classId) {
		String query = "FIND TimeSlot WHERE c_id = :id";
		List<TimeSlot> timetable = find
								.setQuery(query)
								.setParameter("id",classId)
								.findList();
		return timetable;
	}
	
	
	public static Finder<Long,TimeSlot> find = new Finder(Long.class,TimeSlot.class);
}
