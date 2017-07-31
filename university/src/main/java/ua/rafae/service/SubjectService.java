package ua.rafae.service;

import java.util.List;

import ua.rafael.dao.SubjectSession;
import ua.rafael.model.Subject;
import validator.SubjectValidator;

public class SubjectService {
	SubjectSession subjectDao;

	public SubjectService(SubjectSession subjectDao) {
		this.subjectDao = subjectDao;
	}
	
	public void insert(final Subject subject){
		new SubjectValidator().validate(subject);
		subjectDao.insert(subject);
	}
	
	public void delete(final int id){
		subjectDao.delete(id);
	}
	
	public void update(final Subject subject){
		new SubjectValidator().validate(subject);
		subjectDao.update(subject);
	}
	
	public List<Subject> selectAll(){
		return subjectDao.selectAll();
	}
	
	
}
