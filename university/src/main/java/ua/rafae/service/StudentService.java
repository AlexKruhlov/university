package ua.rafae.service;

import ua.rafael.dao.StudentSession;
import ua.rafael.model.Student;
import validator.StudentValidator;

public class StudentService {
	StudentSession studentSession;

	public StudentService(StudentSession studentSession) {
		this.studentSession = studentSession;
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
	
	public void selectAll(){
		studentSession.selectAll();
	}
}
