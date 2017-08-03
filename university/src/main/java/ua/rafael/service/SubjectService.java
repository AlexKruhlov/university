package ua.rafael.service;

import java.util.List;

import ua.rafael.dao.SubjectSession;
import ua.rafael.model.Subject;
import validator.SubjectValidator;

public class SubjectService {
	SubjectSession subjectSession;

	public SubjectService(SubjectSession subjectSession) {
		this.subjectSession = subjectSession;
	}
	
	public void createTable() {
		subjectSession.createTable();
	}
	
	public void insert(final Subject subject){
		new SubjectValidator().validate(subject);
		subjectSession.insert(subject);
	}
	
	public void delete(final int id){
		subjectSession.delete(id);
	}
	
	public void update(final Subject subject){
		new SubjectValidator().validate(subject);
		subjectSession.update(subject);
	}
	
	public List<Subject> selectAll(){
		return subjectSession.selectAll();
	}
	
	public void dropTable() {
		subjectSession.dropTable();
	}
}
