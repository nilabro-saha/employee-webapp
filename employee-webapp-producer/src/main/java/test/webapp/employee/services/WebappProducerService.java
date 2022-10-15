package test.webapp.employee.services;

import test.webapp.employee.model.ModelEntity;

public interface WebappProducerService<T extends ModelEntity> {
	
	public void readAll();
	
	public void readOne(int id);
	
	public void create(T entity);
	
	public void update(T entity);
	
	public void delete(int id);
	
}
