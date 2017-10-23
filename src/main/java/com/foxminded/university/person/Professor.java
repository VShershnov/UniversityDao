package com.foxminded.university.person;

import java.util.HashSet;
import java.util.Set;

import com.foxminded.university.person.Professor;
import com.foxminded.university.Course;

public class Professor extends UniversityPerson{


	//Set of professor teaching courses
	private Set<Course> courses;
	
	public Professor() {
		this.courses = new HashSet<Course>();
	}
	
	public Professor(Integer id, String name) {
		super.setId(id);
		super.setFullName(name);
		this.courses = new HashSet<Course>();
	}
	
	public void addCourse(Course course){
		if (course!=null)
			courses.add(course);
	}
	
	public void removeCourse(Course course){
		courses.remove(course);
	}
	
	public Set<Course> getCourses() {
		return courses;
	}

	public Course getCourse(Course course) {
		for (Course c: courses){
			if (c.equals(course))
				return c;
		}
		return null;
	}

	public void removeProfessorFromProfessorCourses(Professor prof) {
		for (Course c: courses){
			c.getProfessors().remove(prof);
		}		
	}

	public String toString() {
		return "Professor" + getId() + " [FullName="
				+ getFullName() + ", Courses=" + courses.size() + "]";
	}	
}
