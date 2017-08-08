package ua.rafael.service;

import java.util.List;

import ua.rafael.dao.StudentSession;
import ua.rafael.model.Student;
import validation.StudentValidator;

public class StudentService {
	StudentSession studentSession;

	public StudentService(StudentSession studentSession) {
		this.studentSession = studentSession;
	}
	
	public void createTable() {
		studentSession.createTable();
	}
	
	public void insert(final Student student){
		new StudentValidator().validate(student);
		studentSession.insert(student);
	}
	
	public void delete(final int id){
		studentSession.delete(id);
	}
	
	public void update(final long id, final Student student) {
		final Student studentFromDB = findById(id);
		if (studentFromDB != null) {
			student.setId(id);
			studentSession.update(student);
		}
	}
	
	public List<Student> findAll(){
		return studentSession.selectAll();
	}
	
	public Student findById(final long id) {
		return studentSession.selectById(id);
	}
	
	public Student findByName(final String firstName,final String lastName) {
		return studentSession.selectByName(firstName, lastName);
	}
	
	public void dropTable() {
		studentSession.dropTable();
	}
}
