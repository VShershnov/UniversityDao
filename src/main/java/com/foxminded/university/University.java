package main.java.com.foxminded.university;

import java.util.HashSet;
import java.util.Set;

import main.java.com.foxminded.university.Course;
import main.java.com.foxminded.university.Group;
import main.java.com.foxminded.university.Room;
import main.java.com.foxminded.schedule.Schedule;
import main.java.com.foxminded.university.person.Professor;
import main.java.com.foxminded.university.person.Student;

public class University {
	
	private Integer id;
	
	private Set<Group> allGroups;
	
	private Set<Professor> allProfessors;
	
	private Set<Student> allStudents;
	
	private Set<Course> allCourses;
	
	private Set<Room> allRooms;
	
	private Schedule allSchedule;
		
	public University(){
		this.allGroups = new HashSet<Group>();
		this.allProfessors = new HashSet<Professor>();
		this.allStudents = new HashSet<Student>();
		this.allCourses = new HashSet<Course>();
		this.allRooms = new HashSet<Room>();
		this.allSchedule = new Schedule();
	}
	
	public University(Integer id){
		this();
		this.id = id;
	}

	
	public void addGroup(Group group) {
		if (group!=null)
			allGroups.add(group);		
	}

	public void addRoom(Room room){
		if (room!=null)
			allRooms.add(room);
	}
	
	public void addProfessor(Professor prof) {
		if (prof!=null)
			allProfessors.add(prof);
	}
	
	public void addCourse(Course course) {
		if (course!=null)
			allCourses.add(course);
	}
	
	public void addStudent(Student student) {
		if (student!=null)
			allStudents.add(student);
	}	
	
	public void addStudent(Student student, Group group) {
		
		if(student!=null && group!=null){
			if (!allGroups.contains(group)){
				allGroups.add(group);
				System.out.println("To University #" + id + " added NEW " + group + "\n");
			}		
			
			//remove student from previous group 
			if(student.getGroup()!=null)
				getGroup(getStudent(student).getGroup()).removeStudent(student);
			
			
			student.setGroup(group);
			
			if (!allStudents.contains(student)){
				allStudents.add(student);
				System.out.println("To University #" + id + " added NEW " + student + "\n");
			}
			
			getGroup(group).addStudent(student);	
		}
	}
	
	
	public void addCourseToGroup(Course course, Group group) {

		if(course!=null && group!=null){
			if (!allGroups.contains(group)) {
				allGroups.add(group);
				System.out.println("To University #" + id + " added NEW " + group
						+ "\n");
			}
	
			if (!allCourses.contains(course)) {
				allCourses.add(course);
				System.out.println("To University #" + id + " added NEW " + course
						+ "\n");
			}
	
			getGroup(group).addCourse(course);
			getCourse(course).addGroup(group);
		}
	}
	
	public void addProfessorToCourse(Professor prof, Course course) {

		if(course!=null && prof!=null){
			if (!allProfessors.contains(prof) && prof!=null) {
				allProfessors.add(prof);
				System.out.println("To University #" + id + " added NEW " + prof
						+ "\n");
			}
	
			if (!allCourses.contains(course) && course!=null) {
				allCourses.add(course);
				System.out.println("To University #" + id + " added NEW " + course
						+ "\n");
			}
	
			getProfessor(prof).addCourse(course);
			getCourse(course).addProfessor(prof);
		}
	}
		
	public void setStudentGroup(Student student, Group group){
		addStudent(student, group);
	}
	
	//remove conditions
	public void removeGroup(Group group) {
		if(group!=null){
			allSchedule.removeGroupFromScheduleSlots(group);
			group.removeGroupFromGroupCourses(group);
			group.removeGroupFromGroupStudents();
			allGroups.remove(group);
		}				
	}
		 	
	public void removeProfessor(Professor prof){
		if(prof!=null){
			allSchedule.removeProfessorFromScheduleSlots(prof);
			prof.removeProfessorFromProfessorCourses(prof);
			allProfessors.remove(prof);		
		}		
	}
	
	public void removeCourse(Course course) {
		if(course!=null){
			allSchedule.removeCourseFromScheduleSlots(course);			
			course.removeCourseFromCourseGroups(course);
			course.removeCourseFromCourseProfessors(course);
			allCourses.remove(course);		
		}
	}
	
	public void removeStudent(Student student) {
		if(student!=null){
			student.removeStudentFromStudentGroup(student);			
			allStudents.remove(student);		
		}
	}
	
	public void removeRoom(Room room) {
		if(room!=null){
			allSchedule.removeRoomFromScheduleSlots(room);				
			allRooms.remove(room);		
		}		
	}
	
			
	public Schedule getAllSchedule() {
		return allSchedule;
	}

	public void setAllSchedule(Schedule schedule) {
		this.allSchedule = schedule;
	}

	public Set<Course> getAllCourses() {
		return allCourses;
	}

	public void setAllCourses(Set<Course> allCourses) {
		this.allCourses = allCourses;
	}
			
	public Set<Room> getAllRooms() {
		return allRooms;
	}

	public void setAllRooms(Set<Room> allRooms) {
		this.allRooms = allRooms;
	}

	public Set<Group> getAllGroups() {
		return allGroups;
	}
	
	public void setAllGroups(Set<Group> allGroups) {
		this.allGroups = allGroups;
	}
	
	public Set<Professor> getAllProfessors() {
		return allProfessors;
	}
	
	public void setAllProfessors(Set<Professor> allProfessors) {
		this.allProfessors = allProfessors;
	}
	
	public Set<Student> getAllStudents() {
		return allStudents;
	}

	public void setAllStudents(Set<Student> allStudents) {
		this.allStudents = allStudents;
	}

	@Override
	public String toString() {
		return "University" + id + "\n"
				+ "allGroups=" + allGroups + "\n"
				+ "allProfessors=" + allProfessors + "\n"
				+ "allStudents="+ allStudents + "\n"
				+ "allCourses=" + allCourses + "\n"
				+ "allRooms="	+ allRooms + "\n"
				+ "allSchedule=" + allSchedule;		
	}
	
	public Group getGroup(Group group) {
		for (Group g: allGroups){
			if (g.equals(group))
				return g;
		}
		return null;
	}
	
	public Professor getProfessor(Professor prof) {
		for (Professor p: allProfessors){
			if (p.equals(prof))
				return p;
		}
		return null;
	}

	public Course getCourse(Course course) {
		for (Course c: allCourses){
			if (c.equals(course))
				return c;
		}
		return null;
	}
	
	public Student getStudent(Student student) {
		for (Student s: allStudents){
			if (s.equals(student))
				return s;
		}
		return null;
	}
}
