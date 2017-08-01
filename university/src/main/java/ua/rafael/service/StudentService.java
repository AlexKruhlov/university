package ua.rafael.service;

import java.util.List;

import ua.rafael.dao.StudentSession;
import ua.rafael.model.Student;
import validator.StudentValidator;

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
	
	public void update(final Student student){
		new StudentValidator().validate(student);
		studentSession.update(student);
	}
	
	public List<Student> selectAll(){
		return studentSession.selectAll();
	}
	
	public void dropTable() {
		studentSession.dropTable();
	}
}
