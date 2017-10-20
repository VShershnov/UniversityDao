package test.java.com.foxminded.university;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import main.java.com.foxminded.schedule.Schedule;
import main.java.com.foxminded.schedule.ScheduleSlot;
import main.java.com.foxminded.schedule.TimeUnit;
import main.java.com.foxminded.university.Course;
import main.java.com.foxminded.university.Group;
import main.java.com.foxminded.university.Room;
import main.java.com.foxminded.university.University;
import main.java.com.foxminded.university.person.Professor;
import main.java.com.foxminded.university.person.Student;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UniversityTest {
	
	private University university;

	private Group gr1;
	private Group gr2;
	
	private Student st1;
	private Student st2;
	private Student st3;
	
	private Room room1;
	
	private Professor prMath;
	private Professor prInfo;
	
	private Course math;
	private Course java;		
	
	private Schedule schedule;
	
	private List<ScheduleSlot> sheduleSlots;
	
		
	@Before
	public void setUpBefore(){		
		university = new University(1);
		
		gr1 = new Group(1, "FIOT");
		gr2 = new Group(2, "QA");
		
		st1 = new Student(1, "Andrey Petrov");
		st2 = new Student(2, "Dmitro Shevchenko");
		st3 = new Student(3, "Tatiana Sapunova");
		
		room1 = new Room(1,5,"Kyiv");
		
		prMath = new Professor(1, "Nikolay Ivanovich");
		prInfo = new Professor(2, "Lidiya Stepanovna");
		
		math = new Course(1, "Math", 4);
		java = new Course(2, "Java", 6);
		
		sheduleSlots = new ArrayList<ScheduleSlot>();
		int i=0;
		for (int d=1; d<31; d++){
			for (int t=9; t<21; t++){
				TimeUnit time = new TimeUnit(t,d,1);
				ScheduleSlot s1 = new ScheduleSlot(i++, time, room1);
				sheduleSlots.add(s1);
			}
		}
		schedule = new Schedule(sheduleSlots);
		university.setAllSchedule(schedule);
	}
	
	@After
	public void tearDown(){
		university = null;
		gr1 = null;
		gr2 = null;
		st1 = null;
		st2 = null;
		st3 = null;
		room1 = null;
		prMath = null;
		prInfo = null;
		math = null;
		java = null;
		sheduleSlots = null;		
	}
	
	
	@Test
	public void testAddGroup01() {
		university.addGroup(gr1);
		assertEquals(1, university.getAllGroups().size());
	}

	@Test
	public void testAddGroup02() {
		university.addGroup(null);
		assertEquals(0, university.getAllGroups().size());
	}
	
	@Test
	public void testAddGroup03() {
		university.addGroup(gr1);
		university.addGroup(gr1);
		assertEquals(1, university.getAllGroups().size());
	}
	
	@Test
	public void testAddRoom01() {
		university.addRoom(room1);
		assertEquals(1, university.getAllRooms().size());
	}

	@Test
	public void testAddRoom02() {
		university.addRoom(null);
		assertEquals(0, university.getAllRooms().size());
	}
	
	@Test
	public void testAddRoom03() {
		university.addRoom(room1);
		university.addRoom(room1);
		assertEquals(1, university.getAllRooms().size());
	}
	
	@Test
	public void testAddProfessor01() {
		university.addProfessor(prMath);
		assertEquals(1, university.getAllProfessors().size());
	}

	@Test
	public void testAddProfessor02() {
		university.addProfessor(null);
		assertEquals(0, university.getAllProfessors().size());
	}
	
	@Test
	public void testAddProfessor03() {
		university.addProfessor(prMath);
		university.addProfessor(prMath);
		assertEquals(1, university.getAllProfessors().size());
	}
	
	@Test
	public void testAddCourse01() {
		university.addCourse(math);
		assertEquals(1, university.getAllCourses().size());
	}

	@Test
	public void testAddCourse02() {
		university.addCourse(null);
		assertEquals(0, university.getAllCourses().size());
	}
	
	@Test
	public void testAddCourse03() {
		university.addCourse(math);
		university.addCourse(math);
		assertEquals(1, university.getAllCourses().size());
	}

	@Test
	public void testAddStudentStudent01() {
		university.addStudent(st1);
		assertEquals(1, university.getAllStudents().size());
	}

	@Test
	public void testAddStudentStudent02() {
		university.addStudent(null);
		assertEquals(0, university.getAllStudents().size());
	}
	

	
	@Test
	public void testAddStudentStudentGroup01() {
		university.addGroup(gr1);
		university.addStudent(st1, gr1);
		
		assertEquals(1, university.getAllStudents().size());
		assertEquals(1, university.getAllGroups().size());
		assertEquals(1, university.getGroup(gr1).getStudents().size());
		assertEquals(gr1, university.getGroup(gr1).getStudent(st1).getGroup());
		assertEquals(gr1, university.getStudent(st1).getGroup());
	}
	
	@Test
	public void testAddStudentStudentGroup02() {
		university.addStudent(null, null);
		
		assertEquals(0, university.getAllStudents().size());
		assertEquals(0, university.getAllGroups().size());
	}
	
	@Test
	public void testAddStudentStudentGroup03() {
		university.addGroup(gr1);
		university.addStudent(st1, gr1);
		university.addStudent(st2, gr2);
	
		assertEquals(2, university.getAllStudents().size());
		assertEquals(2, university.getAllGroups().size());
		assertEquals(1, university.getGroup(gr1).getStudents().size());
		assertEquals(1, university.getGroup(gr2).getStudents().size());
		assertEquals(gr1, university.getGroup(gr1).getStudent(st1).getGroup());
		assertEquals(gr1, university.getStudent(st1).getGroup());
		assertEquals(gr2, university.getGroup(gr2).getStudent(st2).getGroup());
		assertEquals(gr2, university.getStudent(st2).getGroup());
	}
	
	@Test
	public void testAddStudentStudentGroup04() {
		university.addGroup(gr1);
		university.addStudent(st1, gr1);
		university.addStudent(st3, gr1);
		
		assertEquals(2, university.getAllStudents().size());
		assertEquals(1, university.getAllGroups().size());
		assertEquals(2, university.getGroup(gr1).getStudents().size());
		assertEquals(gr1, university.getGroup(gr1).getStudent(st1).getGroup());
		assertEquals(gr1, university.getStudent(st1).getGroup());
		assertEquals(gr1, university.getGroup(gr1).getStudent(st3).getGroup());
		assertEquals(gr1, university.getStudent(st3).getGroup());
	}
	
	@Test
	public void testAddStudentStudentGroup05() {
		university.addGroup(gr1);
		university.addStudent(st1, gr1);
		university.addStudent(st1, gr2);
		
		assertEquals(1, university.getAllStudents().size());
		assertEquals(2, university.getAllGroups().size());
		assertEquals(0, university.getGroup(gr1).getStudents().size());
		assertEquals(1, university.getGroup(gr2).getStudents().size());
		assertEquals(null, university.getGroup(gr1).getStudent(st1));
		assertEquals(gr2, university.getStudent(st1).getGroup());
		assertEquals(gr2, university.getGroup(gr2).getStudent(st1).getGroup());		
	}
	
	@Test
	public void testAddStudentStudentGroup06() {
		university.addGroup(gr1);
		university.addStudent(st1, gr1);
		university.addStudent(st1, gr1);
		
		assertEquals(1, university.getAllStudents().size());
		assertEquals(1, university.getAllGroups().size());
		assertEquals(1, university.getGroup(gr1).getStudents().size());
		assertEquals(gr1, university.getGroup(gr1).getStudent(st1).getGroup());
		assertEquals(gr1, university.getStudent(st1).getGroup());		
	}
	

	@Test
	public void testAddCourseToGroup01() {
		university.addCourse(math);
		university.addGroup(gr1);
		university.addCourseToGroup(math, gr1);
	
		assertEquals(1, university.getCourse(math).getGroups().size());
		assertEquals(1, university.getGroup(gr1).getCourses().size());
		assertEquals(1, university.getGroup(gr1).getCourse(math).getGroups().size());
	}
	
	@Test
	public void testAddCourseToGroup02() {
		university.addCourseToGroup(math, gr1);
		
		assertEquals(1, university.getAllCourses().size());
		assertEquals(1, university.getAllGroups().size());
		assertEquals(1, university.getGroup(gr1).getCourses().size());
		assertEquals(1, university.getCourse(math).getGroups().size());
	}
	
	
		
	@Test
	public void testAddCourseToGroup03() {
		university.addCourseToGroup(null, null);
		
		assertEquals(0, university.getAllCourses().size());
		assertEquals(0, university.getAllGroups().size());		
	}
	
	@Test
	public void testAddCourseToGroup04() {
		university.addCourseToGroup(math, gr1);
		university.addCourseToGroup(math, gr2);
	
		assertEquals(1, university.getAllCourses().size());
		assertEquals(2, university.getAllGroups().size());
		assertEquals(1, university.getGroup(gr1).getCourses().size());
		assertEquals(1, university.getGroup(gr2).getCourses().size());
		assertEquals(2, university.getCourse(math).getGroups().size());
	}
	
		
	@Test
	public void testAddCourseToGroup05() {			
		university.addCourseToGroup(math, gr1);
		university.addCourseToGroup(java, gr1);
				
		assertEquals(2, university.getAllCourses().size());
		assertEquals(1, university.getAllGroups().size());
		assertEquals(2, university.getGroup(gr1).getCourses().size());
		assertEquals(1, university.getCourse(math).getGroups().size());
		assertEquals(1, university.getCourse(java).getGroups().size());		
	}
	
	@Test
	public void testAddCourseToGroup06() {		
		university.addCourseToGroup(math, gr1);
		university.addCourseToGroup(math, gr1);
		
		assertEquals(1, university.getAllCourses().size());
		assertEquals(1, university.getAllGroups().size());
		assertEquals(1, university.getGroup(gr1).getCourses().size());
		assertEquals(1, university.getCourse(math).getGroups().size());		
	}
	
	
		
	@Test
	public void testAddProfessorToCourse01() {
		university.addCourse(math);
		university.addProfessor(prMath);
		university.addProfessorToCourse(prMath, math);
	
		assertEquals(1, university.getCourse(math).getProfessors().size());
		assertEquals(1, university.getProfessor(prMath).getCourses().size());
	}
	
	@Test
	public void testAddProfessorToCourse02() {
		university.addProfessorToCourse(prMath, math);
		
		assertEquals(1, university.getAllCourses().size());
		assertEquals(1, university.getAllProfessors().size());
		assertEquals(1, university.getCourse(math).getProfessors().size());
		assertEquals(1, university.getProfessor(prMath).getCourses().size());
	}
	
	
		
	@Test
	public void testAddProfessorToCourse03() {
		university.addProfessorToCourse(null, null);
		
		assertEquals(0, university.getAllCourses().size());
		assertEquals(0, university.getAllProfessors().size());		
	}
	
	@Test
	public void testAddProfessorToCourse04() {
		university.addProfessorToCourse(prMath,math);
		university.addProfessorToCourse(prInfo,math);
	
		assertEquals(1, university.getAllCourses().size());
		assertEquals(2, university.getAllProfessors().size());
		assertEquals(1, university.getProfessor(prMath).getCourses().size());
		assertEquals(1, university.getProfessor(prInfo).getCourses().size());
		assertEquals(2, university.getCourse(math).getProfessors().size());
	}
	
		
	@Test
	public void testAddProfessorToCourse05() {	
		university.addProfessorToCourse(prMath,math);
		university.addProfessorToCourse(prMath,java);
						
		assertEquals(2, university.getAllCourses().size());
		assertEquals(1, university.getAllProfessors().size());
		assertEquals(2, university.getProfessor(prMath).getCourses().size());
		assertEquals(1, university.getCourse(math).getProfessors().size());	
		assertEquals(1, university.getCourse(java).getProfessors().size());	
	}
	
	@Test
	public void testAddProfessorToCourse06() {		
		university.addProfessorToCourse(prMath,java);
		university.addProfessorToCourse(prMath,java);
		
		assertEquals(1, university.getAllCourses().size());
		assertEquals(1, university.getAllProfessors().size());
		assertEquals(1, university.getProfessor(prMath).getCourses().size());
		assertEquals(1, university.getCourse(java).getProfessors().size());	
	}
	

	@Test
	public void testRemoveGroup() {
		university.addStudent(st1, gr1);
		university.addCourseToGroup(math, gr1);
		
		sheduleSlots.get(353).setGroup(gr1);
		sheduleSlots.get(352).setGroup(gr1);
		sheduleSlots.get(353).setCourse(math);			
		
		Schedule dayStudentSchedule = schedule.getDailyScheduleForStudent(30, st1);		
		Schedule monthStudentSchedule = schedule.getMonthlyScheduleForStudent(1, st1);
		assertEquals(2, dayStudentSchedule.getScheduleSlots().size());
		assertEquals(2, monthStudentSchedule.getScheduleSlots().size());
		
		university.removeGroup(gr1);
		
		assertEquals(0, university.getAllGroups().size());
		assertEquals(null, university.getGroup(gr1));
		assertEquals(null, university.getStudent(st1).getGroup());
		assertEquals(0, university.getCourse(math).getGroups().size());
		
		dayStudentSchedule = university.getAllSchedule().getDailyScheduleForStudent(30, st1);		
		monthStudentSchedule = university.getAllSchedule().getMonthlyScheduleForStudent(1, st1);
		
		assertEquals(0, dayStudentSchedule.getScheduleSlots().size());
		assertEquals(0, monthStudentSchedule.getScheduleSlots().size());
	}
	
	@Test
	public void testRemoveGroupAsRemoveEmptyGroup() {
		university.addStudent(st1, gr1);
		university.addCourseToGroup(math, gr1);
		
		sheduleSlots.get(353).setGroup(gr1);
		sheduleSlots.get(352).setGroup(gr1);
		sheduleSlots.get(353).setCourse(math);
		
		university.removeGroup(gr2);
		
		assertEquals(1, university.getAllGroups().size());
		assertEquals(gr1, university.getGroup(gr1));
		assertEquals(1, university.getCourse(math).getGroups().size());
		assertEquals(gr1, university.getStudent(st1).getGroup());
		
		assertEquals(2, university.getAllSchedule().getDailyScheduleForStudent(30, st1).getScheduleSlots().size());
		assertEquals(2, university.getAllSchedule().getMonthlyScheduleForStudent(1, st1).getScheduleSlots().size());				
	}
	
	
	@Test
	public void testRemoveProfessor() {
		university.addStudent(st1, gr1);
		university.addProfessorToCourse(prMath,math);
		university.addCourseToGroup(math, gr1);
		
		sheduleSlots.get(353).setProfessor(prMath);
		sheduleSlots.get(353).setGroup(gr1);
		sheduleSlots.get(353).setCourse(math);
		
		Schedule dayProfessorSchedule = schedule.getDailyScheduleForProfessor(30, prMath);		
		Schedule monthProfessorSchedule = schedule.getMonthlyScheduleForProfessor(1, prMath);		
		assertEquals(1, dayProfessorSchedule.getScheduleSlots().size());
		assertEquals(1, monthProfessorSchedule.getScheduleSlots().size());
		
		university.removeProfessor(prMath);
		
		assertEquals(null, university.getProfessor(prMath));
		assertEquals(0, university.getGroup(gr1).getCourse(math).getProfessors().size());
		assertEquals(0, university.getCourse(math).getProfessors().size());
		assertEquals(0, university.getStudent(st1).getGroup().getCourse(math).getProfessors().size());
		
		dayProfessorSchedule = schedule.getDailyScheduleForProfessor(30, prMath);		
		monthProfessorSchedule = schedule.getMonthlyScheduleForProfessor(1, prMath);	
		
		assertEquals(0, dayProfessorSchedule.getScheduleSlots().size());
		assertEquals(0, monthProfessorSchedule.getScheduleSlots().size());
	}

		
	@Test
	public void testRemoveProfessorAsRemoveSecondProfessor() {
		university.addStudent(st1, gr1);
		university.addProfessorToCourse(prMath,math);		
		university.addProfessorToCourse(prInfo,math);
		university.addCourseToGroup(math, gr1);
				
		sheduleSlots.get(353).setProfessor(prMath);
		sheduleSlots.get(353).setGroup(gr1);
		sheduleSlots.get(353).setCourse(math);
		sheduleSlots.get(352).setProfessor(prInfo);
		sheduleSlots.get(352).setGroup(gr1);
		sheduleSlots.get(352).setCourse(math);
		
		Schedule dayProfessorSchedule1 = schedule.getDailyScheduleForProfessor(30, prMath);	
		Schedule dayProfessorSchedule2 = schedule.getDailyScheduleForProfessor(30, prInfo);		
		Schedule monthProfessorSchedule1 = schedule.getMonthlyScheduleForProfessor(1, prMath);	
		Schedule monthProfessorSchedule2 = schedule.getMonthlyScheduleForProfessor(1, prInfo);
		
		assertEquals(1, dayProfessorSchedule1.getScheduleSlots().size());
		assertEquals(1, monthProfessorSchedule1.getScheduleSlots().size());
		assertEquals(1, dayProfessorSchedule2.getScheduleSlots().size());
		assertEquals(1, monthProfessorSchedule2.getScheduleSlots().size());
		
		university.removeProfessor(prInfo);
		
		assertEquals(1, university.getAllProfessors().size());
		assertEquals(null, university.getProfessor(prInfo));
		assertEquals(1, university.getGroup(gr1).getCourse(math).getProfessors().size());
		assertEquals(1, university.getCourse(math).getProfessors().size());
		assertEquals(1, university.getStudent(st1).getGroup().getCourse(math).getProfessors().size());
		
		dayProfessorSchedule1 = schedule.getDailyScheduleForProfessor(30, prMath);	
		dayProfessorSchedule2 = schedule.getDailyScheduleForProfessor(30, prInfo);		
		monthProfessorSchedule1 = schedule.getMonthlyScheduleForProfessor(1, prMath);	
		monthProfessorSchedule2 = schedule.getMonthlyScheduleForProfessor(1, prInfo);	
		
		assertEquals(1, dayProfessorSchedule1.getScheduleSlots().size());
		assertEquals(1, monthProfessorSchedule1.getScheduleSlots().size());
		assertEquals(0, dayProfessorSchedule2.getScheduleSlots().size());
		assertEquals(0, monthProfessorSchedule2.getScheduleSlots().size());
	}

	@Test
	public void testRemoveProfessorasRemoveEmptyProfessor03() {
		university.addStudent(st1, gr1);
		university.addProfessorToCourse(prMath,math);
		university.addCourseToGroup(math, gr1);
		
		sheduleSlots.get(353).setProfessor(prMath);
		sheduleSlots.get(353).setGroup(gr1);
		sheduleSlots.get(353).setCourse(math);
		
		
		Schedule dayProfessorSchedule = schedule.getDailyScheduleForProfessor(30, prMath);
		Schedule monthProfessorSchedule = schedule.getMonthlyScheduleForProfessor(1, prMath);
		assertEquals(1, dayProfessorSchedule.getScheduleSlots().size());
		assertEquals(1, monthProfessorSchedule.getScheduleSlots().size());
		
		university.removeProfessor(prInfo);
		
		assertEquals(prMath, university.getProfessor(prMath));
		assertEquals(1, university.getGroup(gr1).getCourse(math).getProfessors().size());
		assertEquals(1, university.getCourse(math).getProfessors().size());
		assertEquals(1, university.getStudent(st1).getGroup().getCourse(math).getProfessors().size());
		
		dayProfessorSchedule = schedule.getDailyScheduleForProfessor(30, prMath);		
		monthProfessorSchedule = schedule.getMonthlyScheduleForProfessor(1, prMath);	
		
		assertEquals(1, dayProfessorSchedule.getScheduleSlots().size());
		assertEquals(1, monthProfessorSchedule.getScheduleSlots().size());
	}
	
	@Test
	public void testRemoveCourse() {
		university.addStudent(st1, gr1);
		university.addCourseToGroup(math, gr1);
		university.addProfessorToCourse(prMath, math);
				
		sheduleSlots.get(353).setGroup(gr1);		
		sheduleSlots.get(353).setCourse(math);
		sheduleSlots.get(353).setProfessor(prMath);
			
		Schedule dayStudentSchedule = schedule.getDailyScheduleForStudent(30, st1);
		Schedule monthStudentSchedule = schedule.getMonthlyScheduleForStudent(1, st1);
		
		assertEquals(math, dayStudentSchedule.getScheduleSlot(sheduleSlots.get(353)).getCourse());
		assertEquals(math, monthStudentSchedule.getScheduleSlot(sheduleSlots.get(353)).getCourse());
		
		university.removeCourse(math);
		
		assertEquals(null, university.getCourse(math));
		assertEquals(null, university.getGroup(gr1).getCourse(math));
		assertEquals(null, university.getProfessor(prMath).getCourse(math));
		assertEquals(null, university.getStudent(st1).getGroup().getCourse(math));
		
		assertEquals(null, university.getAllSchedule()
				.getScheduleSlot(sheduleSlots.get(353)).getCourse());
		assertEquals(null, dayStudentSchedule.getScheduleSlot(sheduleSlots.get(353)).getCourse());
		assertEquals(null, monthStudentSchedule.getScheduleSlot(sheduleSlots.get(353)).getCourse());		
		
		assertEquals(0, dayStudentSchedule.getScheduleSlot(sheduleSlots.get(353)).getProfessor().getCourses().size());
		assertEquals(0, monthStudentSchedule.getScheduleSlot(sheduleSlots.get(353)).getProfessor().getCourses().size());		
	}

	@Test
	public void testRemoveCourseAsSecondCourse() {
		university.addStudent(st1, gr1);
		university.addCourseToGroup(math, gr1);
		university.addCourseToGroup(java, gr1);
		university.addProfessorToCourse(prMath, math);
		university.addProfessorToCourse(prMath, java);
				
		sheduleSlots.get(352).setGroup(gr1);
		sheduleSlots.get(352).setCourse(java);
		sheduleSlots.get(352).setProfessor(prMath);
		sheduleSlots.get(353).setGroup(gr1);
		sheduleSlots.get(353).setCourse(math);
		sheduleSlots.get(353).setProfessor(prMath);
					
		Schedule dayStudentSchedule = schedule.getDailyScheduleForStudent(30, st1);
		Schedule monthStudentSchedule = schedule.getMonthlyScheduleForStudent(1, st1);
				
		university.removeCourse(java);
		
		assertEquals(1, university.getAllCourses().size());
		assertEquals(1, university.getGroup(gr1).getCourses().size());
		assertEquals(1, university.getProfessor(prMath).getCourses().size());
		assertEquals(1, university.getStudent(st1).getGroup().getCourses().size());		
		
		assertEquals(null, university.getAllSchedule()
				.getScheduleSlot(sheduleSlots.get(352)).getCourse());
		assertEquals(null, dayStudentSchedule.getScheduleSlot(sheduleSlots.get(352)).getCourse());
		assertEquals(null, monthStudentSchedule.getScheduleSlot(sheduleSlots.get(352)).getCourse());
		assertEquals(1, dayStudentSchedule.getScheduleSlot(sheduleSlots.get(352)).getProfessor().getCourses().size());
		assertEquals(1, monthStudentSchedule.getScheduleSlot(sheduleSlots.get(352)).getProfessor().getCourses().size());
		
		assertEquals(math, university.getAllSchedule()
				.getScheduleSlot(sheduleSlots.get(353)).getCourse());
		assertEquals(math, dayStudentSchedule.getScheduleSlot(sheduleSlots.get(353)).getCourse());
		assertEquals(math, monthStudentSchedule.getScheduleSlot(sheduleSlots.get(353)).getCourse());
		assertEquals(1, dayStudentSchedule.getScheduleSlot(sheduleSlots.get(353)).getProfessor().getCourses().size());
		assertEquals(1, monthStudentSchedule.getScheduleSlot(sheduleSlots.get(353)).getProfessor().getCourses().size());
	}	
	
	
	@Test
	public void testRemoveStudent() {
		university.addStudent(st1, gr1);
		university.addStudent(st2, gr1);
		university.addProfessorToCourse(prMath,math);
		university.addCourseToGroup(math, gr1);
		
		sheduleSlots.get(353).setProfessor(prMath);
		sheduleSlots.get(353).setGroup(gr1);
		sheduleSlots.get(353).setCourse(math);
				
		Schedule dayStudentSchedule1 = schedule.getDailyScheduleForStudent(30, st1);
		Schedule monthStudentSchedule1 = schedule.getMonthlyScheduleForStudent(1, st1);
		Schedule dayStudentSchedule2 = schedule.getDailyScheduleForStudent(30, st2);
		Schedule monthStudentSchedule2 = schedule.getMonthlyScheduleForStudent(1, st2);
		
		assertEquals(1, dayStudentSchedule1.getScheduleSlots().size());
		assertEquals(1, monthStudentSchedule1.getScheduleSlots().size());
		assertEquals(1, dayStudentSchedule2.getScheduleSlots().size());
		assertEquals(1, monthStudentSchedule2.getScheduleSlots().size());
		assertEquals(2, university.getAllSchedule()
				.getScheduleSlot(sheduleSlots.get(353)).getGroup().getStudents().size());
		
		university.removeStudent(st1);
		
		assertEquals(null, university.getStudent(st1));
		assertEquals(null, university.getGroup(gr1).getStudent(st1));
		assertEquals(null, university.getGroup(gr1).getCourse(math).getGroup(gr1).getStudent(st1));
		assertEquals(null, university.getCourse(math).getGroup(gr1).getStudent(st1));		
		
		dayStudentSchedule1 = schedule.getDailyScheduleForStudent(30, st1);	
		dayStudentSchedule2 = schedule.getDailyScheduleForStudent(30, st2);		
		monthStudentSchedule1 = schedule.getMonthlyScheduleForStudent(1, st1);	
		monthStudentSchedule2 = schedule.getMonthlyScheduleForStudent(1, st2);	
		
		assertEquals(0, dayStudentSchedule1.getScheduleSlots().size());
		assertEquals(0, monthStudentSchedule1.getScheduleSlots().size());
		assertEquals(1, dayStudentSchedule2.getScheduleSlots().size());
		assertEquals(1, monthStudentSchedule2.getScheduleSlots().size());
		
		assertEquals(1, university.getAllSchedule()
				.getScheduleSlot(sheduleSlots.get(353)).getGroup().getStudents().size());
	}
	
	@Test
	public void testRemoveRoom() {
		university.addRoom(room1);
		university.addStudent(st1, gr1);				
		sheduleSlots.get(353).setGroup(gr1);		
			
		Schedule dayStudentSchedule = schedule.getDailyScheduleForStudent(30, st1);
		assertEquals(1, dayStudentSchedule.getScheduleSlots().size());
		
		university.removeRoom(room1);
		
		assertEquals(0, university.getAllRooms().size());				
				
		assertEquals(null, university.getAllSchedule()
				.getScheduleSlot(sheduleSlots.get(353)).getRoom());
		
		dayStudentSchedule = schedule.getDailyScheduleForStudent(30, st1);
		assertEquals(null, dayStudentSchedule.getScheduleSlot(sheduleSlots.get(353)).getRoom());
	}	
	
	@Test
	public void testGetGroup() {
		university.addGroup(gr1);
		
		assertEquals(null, university.getGroup(null));		
	}	
}
