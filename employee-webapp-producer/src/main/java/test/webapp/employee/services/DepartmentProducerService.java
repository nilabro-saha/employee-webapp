package test.webapp.employee.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.webapp.employee.model.Department;
import test.webapp.employee.resources.Path;
import test.webapp.employee.resources.Topic;

@Service
@Qualifier(Path.DEPARTMENT_SERVICE)
@Transactional
public class DepartmentProducerService implements WebappProducerService<Department> {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeProducerService.class);
	
	@Autowired
	private KafkaTemplate<String, Department> kafkaPutTemplate;
	
	@Autowired
	private KafkaTemplate<String, Integer> kafkaGetTemplate;

	@Override
	public void readAll() {
		logger.info(String.format("Outgoing message - %s", Topic.DEPARTMENT_GET_ALL));
		this.kafkaGetTemplate.send(Topic.DEPARTMENT_GET_ALL, 0);
	}

	@Override
	public void readOne(int id) {
		logger.info(String.format("Outgoing message - %s - ID %s", Topic.DEPARTMENT_GET, id));
		this.kafkaGetTemplate.send(Topic.DEPARTMENT_GET, id);
	}

	@Override
	public void create(Department entity) {
		logger.info(String.format("Outgoing message - %s - %s", Topic.DEPARTMENT_POST, entity));
		this.kafkaPutTemplate.send(Topic.DEPARTMENT_POST, entity);
	}

	@Override
	public void update(Department entity) {
		logger.info(String.format("Outgoing message - %s - $s", Topic.DEPARTMENT_PUT, entity));
		this.kafkaPutTemplate.send(Topic.DEPARTMENT_PUT, entity);
	}

	@Override
	public void delete(int id) {
		logger.info(String.format("Outgoing message - %s - ID %s", Topic.DEPARTMENT_DELETE, id));
		this.kafkaGetTemplate.send(Topic.DEPARTMENT_DELETE, id);
	}
	
}
