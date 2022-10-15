package test.webapp.employee.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.webapp.employee.dao.EmployeeDao;
import test.webapp.employee.model.Employee;
import test.webapp.employee.resources.Kafka;
import test.webapp.employee.resources.Path;
import test.webapp.employee.resources.Topic;

@Service
@Qualifier(Path.EMPLOYEE_SERVICE)
@Transactional
public class EmployeeConsumerService implements WebappConsumerService<Employee> {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeConsumerService.class);
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@KafkaListener(topics=Topic.EMPLOYEE_GET_ALL, groupId=Kafka.GROUP_ID)
	public List<Employee> readAll() {
		List<Employee> list = employeeDao.findAll();
		logger.info(String.format("Incoming message - %s - %s", Topic.EMPLOYEE_GET_ALL, list));
		return list;
	}

	@Override
	@KafkaListener(topics=Topic.EMPLOYEE_GET, groupId=Kafka.GROUP_ID)
	public Optional<Employee> readOne(int id) {
		Optional<Employee> emp = employeeDao.findById(id);
		emp.ifPresentOrElse(
				x -> logger.info(String.format("Incoming message - %s - %s", Topic.EMPLOYEE_GET, x)),
				() -> logger.info(String.format("Incoming message - %s - NOT FOUND at ID %s", Topic.EMPLOYEE_GET, id)));
		return emp;
	}

	@Override
	@KafkaListener(topics=Topic.EMPLOYEE_POST, groupId=Kafka.GROUP_ID)
	public Employee create(Employee entity) {
		logger.info(String.format("Incoming message - %s - %s", Topic.EMPLOYEE_POST, entity));
		return employeeDao.save(entity);
	}

	@Override
	@KafkaListener(topics=Topic.EMPLOYEE_PUT, groupId=Kafka.GROUP_ID)
	public Employee update(Employee entity) {
		logger.info(String.format("Incoming message - %s - %s", Topic.EMPLOYEE_PUT, entity));
		return employeeDao.save(entity);
	}

	@Override
	@KafkaListener(topics=Topic.EMPLOYEE_DELETE, groupId=Kafka.GROUP_ID)
	public Optional<Employee> delete(int id) {
		Optional<Employee> empToDelete = readOne(id);
		empToDelete.ifPresentOrElse(
				x -> logger.info(String.format("Incoming message - %s - %s", Topic.EMPLOYEE_DELETE, x)),
				() -> logger.info(String.format("Incoming message - %s - NOT FOUND at ID %s", Topic.EMPLOYEE_DELETE, id)));
		employeeDao.deleteById(id);
		return empToDelete;
	}
	
}
