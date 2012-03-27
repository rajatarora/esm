package models;

import java.util.*;
import javax.persistence.*;
import play.data.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity(name="TeacherAssignment")
public class TeacherAssignment extends Model {

	@Id
	public String id;

	@ManyToOne
	public EClass ec;

	@ManyToOne
	public Paper paper;

	@ManyToOne
	public Teacher teacher;

	public static List<TeacherAssignment> getTAByClassId(String classId) {
		String query = "FIND teacherassignment WHERE ec_id = :id";
		return find
				.setQuery(query)
				.setParameter("id",classId)
				.findList();
	}

	public static Finder<String,TeacherAssignment> find = new Finder(String.class,TeacherAssignment.class);
}
