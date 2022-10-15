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

import test.webapp.employee.dao.DepartmentDao;
import test.webapp.employee.model.Department;
import test.webapp.employee.resources.Kafka;
import test.webapp.employee.resources.Path;
import test.webapp.employee.resources.Topic;

@Service
@Qualifier(Path.DEPARTMENT_SERVICE)
@Transactional
public class DepartmentConsumerService implements WebappConsumerService<Department> {
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentConsumerService.class);
	
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	@KafkaListener(topics=Topic.DEPARTMENT_GET_ALL, groupId=Kafka.GROUP_ID)
	public List<Department> readAll() {
		List<Department> list = departmentDao.findAll();
		logger.info(String.format("Incoming message - %s - %s", Topic.DEPARTMENT_GET_ALL, list));
		return list;
	}

	@Override
	@KafkaListener(topics=Topic.DEPARTMENT_GET, groupId=Kafka.GROUP_ID)
	public Optional<Department> readOne(int id) {
		Optional<Department> dept = departmentDao.findById(id);
		dept.ifPresentOrElse(
				x -> logger.info(String.format("Incoming message - %s - %s", Topic.DEPARTMENT_GET, x)),
				() -> logger.info(String.format("Incoming message - %s - NOT FOUND at ID %s", Topic.DEPARTMENT_GET, id)));
		return departmentDao.findById(id);
	}

	@Override
	@KafkaListener(topics=Topic.DEPARTMENT_POST, groupId=Kafka.GROUP_ID)
	public Department create(Department entity) {
		logger.info(String.format("Incoming message - %s - %s", Topic.DEPARTMENT_POST, entity));
		return departmentDao.save(entity);
	}

	@Override
	@KafkaListener(topics=Topic.DEPARTMENT_PUT, groupId=Kafka.GROUP_ID)
	public Department update(Department entity) {
		logger.info(String.format("Incoming message - %s - %s", Topic.DEPARTMENT_PUT, entity));
		return departmentDao.save(entity);
	}

	@Override
	@KafkaListener(topics=Topic.DEPARTMENT_DELETE, groupId=Kafka.GROUP_ID)
	public Optional<Department> delete(int id) {
		Optional<Department> deptToDelete = readOne(id);
		deptToDelete.ifPresentOrElse(
				x -> logger.info(String.format("Incoming message - %s - %s", Topic.DEPARTMENT_DELETE, x)),
				() -> logger.info(String.format("Incoming message - %s - NOT FOUND at ID %s", Topic.DEPARTMENT_DELETE, id)));
		departmentDao.deleteById(id);
		return deptToDelete;
	}
	
}
