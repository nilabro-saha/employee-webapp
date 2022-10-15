package test.webapp.employee.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.webapp.employee.model.Employee;
import test.webapp.employee.resources.Path;
import test.webapp.employee.resources.Topic;

@Service
@Qualifier(Path.EMPLOYEE_SERVICE)
@Transactional
public class EmployeeProducerService implements WebappProducerService<Employee> {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeProducerService.class);
	
	@Autowired
	private KafkaTemplate<String, Employee> kafkaPutTemplate;
	
	@Autowired
	private KafkaTemplate<String, Integer> kafkaGetTemplate;

	@Override
	public void readAll() {
		logger.info(String.format("Outgoing message - %s", Topic.EMPLOYEE_GET_ALL));
		this.kafkaGetTemplate.send(Topic.EMPLOYEE_GET_ALL, 0);
	}

	@Override
	public void readOne(int id) {
		logger.info(String.format("Outgoing message - %s - ID %s", Topic.EMPLOYEE_GET, id));
		this.kafkaGetTemplate.send(Topic.EMPLOYEE_GET, id);
	}

	@Override
	public void create(Employee entity) {
		logger.info(String.format("Outgoing message - %s - %s", Topic.EMPLOYEE_POST, entity));
		this.kafkaPutTemplate.send(Topic.EMPLOYEE_POST, entity);
	}

	@Override
	public void update(Employee entity) {
		logger.info(String.format("Outgoing message - %s - %s", Topic.EMPLOYEE_PUT, entity));
		this.kafkaPutTemplate.send(Topic.DEPARTMENT_PUT, entity);
	}

	@Override
	public void delete(int id) {
		logger.info(String.format("Outgoing message - %s - ID %s", Topic.EMPLOYEE_DELETE, id));
		this.kafkaGetTemplate.send(Topic.EMPLOYEE_DELETE, id);
	}
	
}
