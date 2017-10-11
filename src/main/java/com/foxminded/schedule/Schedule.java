package main.java.com.foxminded.schedule;

import java.util.ArrayList;
import java.util.List;

import main.java.com.foxminded.schedule.Schedule;
import main.java.com.foxminded.schedule.ScheduleSlot;
import main.java.com.foxminded.university.Course;
import main.java.com.foxminded.university.Group;
import main.java.com.foxminded.university.Room;
import main.java.com.foxminded.university.person.Professor;
import main.java.com.foxminded.university.person.Student;

public class Schedule {

	private List<ScheduleSlot> scheduleSlots;	
	
	public Schedule() {
		this.scheduleSlots = new ArrayList<ScheduleSlot>();
	}	

	public Schedule(List<ScheduleSlot> scheduleSlots) {
		this.scheduleSlots = scheduleSlots;		
	}
	
	public void addSchedulerSlot (ScheduleSlot scheduleSlot){
		scheduleSlots.add(scheduleSlot);
	}
	
	public void removeSchedulerSlot (ScheduleSlot scheduleSlot){
		scheduleSlots.remove(scheduleSlot);
	}
	
	public List<ScheduleSlot> getScheduleSlots() {
		return scheduleSlots;
	}

	public void setScheduleSlots(List<ScheduleSlot> scheduleSlots) {
		this.scheduleSlots = scheduleSlots;
	}

	public ScheduleSlot getScheduleSlot(ScheduleSlot scheduleSlot) {
		for (ScheduleSlot ss: scheduleSlots){
			if (ss.equals(scheduleSlot))
				return ss;
		}
		return null;
	}

	@Override
	public String toString() {
		return "ScheduleSlots=" + scheduleSlots.size();
	}

	public void removeGroupFromScheduleSlots(Group group) {
		for(ScheduleSlot ss: scheduleSlots){			
			if(ss.getGroup()!=null && ss.getGroup().equals(group))
				ss.setGroup(null);			
		}		
	}

	public void removeCourseFromScheduleSlots(Course course) {
		for(ScheduleSlot ss: scheduleSlots){			
			if(ss.getCourse()!=null && ss.getCourse().equals(course))
				ss.setCourse(null);			
		}		
	}

	public void removeProfessorFromScheduleSlots(Professor prof) {
		for(ScheduleSlot ss: scheduleSlots){			
			if(ss.getProfessor()!=null && ss.getProfessor().equals(prof))
				ss.setProfessor(null);			
		}		
	}

	public void removeRoomFromScheduleSlots(Room room) {
		for(ScheduleSlot ss: scheduleSlots){
			if(ss.getRoom()!=null && ss.getRoom().equals(room))
				ss.setRoom(null);				
		}		
	}
	
	public Schedule getDailyScheduleForProfessor(Integer day, Professor prof){
		Schedule schedule = new Schedule();
		for(ScheduleSlot ss: scheduleSlots){			
			if(ss.getProfessor()!=null && ss.getProfessor().equals(prof) && ss.getTime().getDay().equals(day))
				schedule.addSchedulerSlot(ss);			
		}		
		return schedule;		
	}
	
	public Schedule getDailyScheduleForStudent(Integer day, Student student){
		Schedule schedule = new Schedule();
		for(ScheduleSlot ss: scheduleSlots){			
			if(ss.getGroup()!=null && student.equals(ss.getGroup().getStudent(student)) && ss.getTime().getDay().equals(day))
						schedule.addSchedulerSlot(ss);			
		}		
		return schedule;	
	}
	
	public Schedule getMonthlyScheduleForProfessor(Integer month, Professor prof){
		Schedule schedule = new Schedule();
		for(ScheduleSlot ss: scheduleSlots){			
			if(ss.getProfessor()!=null && ss.getProfessor().equals(prof) && ss.getTime().getMonth().equals(month))
				schedule.addSchedulerSlot(ss);			
		}		
		return schedule;		
	}
	
	public Schedule getMonthlyScheduleForStudent(Integer month, Student student){
		Schedule schedule = new Schedule();
		for(ScheduleSlot ss: scheduleSlots){			
			if(ss.getGroup()!=null && student.equals(ss.getGroup().getStudent(student)) && ss.getTime().getMonth().equals(month))
				schedule.addSchedulerSlot(ss);			
		}		
		return schedule;			
	}
}
