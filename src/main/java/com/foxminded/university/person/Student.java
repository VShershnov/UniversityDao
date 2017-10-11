package main.java.com.foxminded.university.person;

import main.java.com.foxminded.university.person.Student;
import main.java.com.foxminded.university.Group;

public class Student extends UniversityPerson {
	
private Group group;
	
	public Student() {
	}
	
	public Student(int id, String name) {
		super.setId(id);
		super.setFullName(name);
	}

	public Group getGroup() {
		return group;		
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void removeStudentFromStudentGroup(Student student) {
		group.getStudents().remove(student);
	}

	@Override
	public String toString() {
		return "Student" + getId() + " [FullName=" + getFullName()
				+ ", group=" + group + "]";
	}			
}
