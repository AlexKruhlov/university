package ua.rafae.service;

import ua.rafael.dao.AcademPerfomanceSession;
import ua.rafael.model.AcademPerfomance;
import validator.AcademPerfomanceValidator;


public class AcademPerfomanceService {
	private AcademPerfomanceSession academPerfomanceSession;

	public AcademPerfomanceService(AcademPerfomanceSession academPerfomanceSession) {
		this.academPerfomanceSession = academPerfomanceSession;
	}
	
	public void createTable() {
		academPerfomanceSession.createTable();
	}
	
	public void insert(final AcademPerfomance academPerfomance){
		new AcademPerfomanceValidator().validate(academPerfomance);
		academPerfomanceSession.insert(academPerfomance);
	}
	
	public void delete(final int id){
		academPerfomanceSession.delete(id);
	}
	
	public void update(final AcademPerfomance academPerfomance){
		new AcademPerfomanceValidator().validate(academPerfomance);
		academPerfomanceSession.update(academPerfomance);
	}
	
	public void selectAll(){
		academPerfomanceSession.selectAll();
	}
}
