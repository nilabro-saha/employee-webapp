package test.webapp.employee.services;

import java.util.List;
import java.util.Optional;

import test.webapp.employee.model.ModelEntity;

public interface WebappConsumerService<T extends ModelEntity> {
	
	public List<T> readAll();
	
	public Optional<T> readOne(int id);
	
	public T create(T entity);
	
	public T update(T entity);
	
	public Optional<T> delete(int id);
	
}
