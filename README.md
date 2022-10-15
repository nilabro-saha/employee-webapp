## Start Kafka, Create Topics & Pass Objects through Postman

1. Start Kafka (installed using Homebrew)
```bash
brew services start kafka
```
2. Start zookeeper
```bash
brew services start zookeeper
```
3. Start producer and consumer applications at with bootstrap server at localhost:9092.
4. Create kafka topics for employee crud application
```bash
kafka-topics --create --bootstrap-server localhost:9092 --topic employee_get
```
```bash
kafka-topics --create --bootstrap-server localhost:9092 --topic employee_get_all
```
```bash
kafka-topics --create --bootstrap-server localhost:9092 --topic employee_put
```
```bash
kafka-topics --create --bootstrap-server localhost:9092 --topic employee_post
```
```bash
kafka-topics --create --bootstrap-server localhost:9092 --topic employee_delete
```
5. Create kafka topics for department crud application
```bash
kafka-topics --create --bootstrap-server localhost:9092 --topic department_get
```
```bash
kafka-topics --create --bootstrap-server localhost:9092 --topic department_get_all
```
```bash
kafka-topics --create --bootstrap-server localhost:9092 --topic department_put
```
```bash
kafka-topics --create --bootstrap-server localhost:9092 --topic department_post
```
```bash
kafka-topics --create --bootstrap-server localhost:9092 --topic department_delete
```
6. See all running kafka topics
```bash
kafka-topics --list --bootstrap-server localhost:9092
```
**Note:** To stop zookeeper and kafka, use:
```bash
brew services stop zookeeper
```
```bash
brew services stop kafka
```
7. Example JSON objects to add:
```json
{
	"id": 3,
	"firstName": "Aakash",
	"lastName": "Dey",
	"email": "adey@gmail.com",
	"salary": 20000.0,
	"departmentId": 3,
	"managerId": 3
}
```
```json
{
	"id": 1,
	"firstName": "Nilabro",
	"lastName": "Saha",
	"email": "nsaha@gmail.com",
	"salary": 20000.0,
	"departmentId": 1,
	"managerId": 1
}
```
```json
{
	"id": 2,
	"firstName": "Anirban",
	"lastName": "Das",
	"email": "adas@gmail.com",
	"salary": 20000.0,
	"departmentId": 2,
	"managerId": 2
}
```
