package models;

import java.util.*;
import javax.persistence.*;
import play.data.*;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity(name="Room")
public class Room extends Model {
	
	@Id
	@GeneratedValue
	public Long id;
	
	@Column(nullable=false)
	public String name;

	public static Room getById(Long roomId) {
		return find
				.where()
				.eq("id",roomId)
				.findUnique();
	}
	
	public static Finder<Long,Room> find = new Finder(Long.class,Room.class);
}
