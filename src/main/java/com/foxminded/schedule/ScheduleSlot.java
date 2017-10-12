package main.java.com.foxminded.schedule;

import main.java.com.foxminded.dao.Identified;
import main.java.com.foxminded.university.Course;
import main.java.com.foxminded.university.Room;
import main.java.com.foxminded.university.person.Professor;
import main.java.com.foxminded.university.Group;

public class ScheduleSlot implements Identified<Integer> {
	
	private Integer id;
	
	private Room room;
	
	private Course course;
	
	private TimeUnit time;
	
	private Professor professor;
	
	private Group group;
	
	
	public ScheduleSlot() {
	}

	public ScheduleSlot(Integer id, Room room, TimeUnit time) {
		this.id = id;
		this.room = room;
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public TimeUnit getTime() {
		return time;
	}

	public void setTime(TimeUnit time) {
		this.time = time;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}	

	@Override
	public String toString() {
		return "ScheduleSlot" + id + " [time=" + time + ", room" + room.getId() + ", course="
				+ course.getName() + ", professor=" + professor.getFullName()
				+ ", group=" + group.getName() + "]\n";
	}		
}
