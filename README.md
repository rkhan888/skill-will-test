To run this apring boot application following pre-requisites required:
- java 1.8
- maven installed
- docker up and running

How To Run:

- clone the repo in the local
- generate docker image by running following command in the project directory
	- mvn clean package docker:build -DskipTests
- pull MySql docker image using docker command
	- docker pull mysql:5.6
- start MySql container
	- docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=skillwill -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql:5.6
- start the spring boot application container
	- docker run -d -p 8080:8080 --name skillwill-test --link mysql-container:mysql skillwill-test
- enter into MySql container and load the DB with dummy data
	- docker exec -it mysql-container bash
	- mysql -u root -proot
	- use skillwill
	- INSERT INTO `student` VALUES (1, 20, 'john', 'doe'),(28,33,'Brisa','Littel'),(94,16,'Cortez','McLaughlin'),(69,19,'Cody','DuBuque'),(43,28,'Noah','Morar'),(50,28,'Milford','Hagenes'),(12,26,'Lelia','Kemmer'),(24,34,'Marina','Marvin'),(84,30,'Joanie','Gusikowski'),(75,18,'Virginie','Fadel'),(4,24,'Viviane','Langosh'),(62,22,'Santino','Frami'),(92,24,'Hannah','Schimmel'),(72,16,'Branson','Crist'),(23,34,'Kara','Carroll'),(17,34,'Tillman','Gislason'),(98,20,'Hazel','Labadie'),(81,28,'Houston','Metz'),(44,28,'Sunny','Kuhlman'),(11,19,'Amiya','Paucek'),(20,34,'Maximillia','Windler');
	- exit
- Now the rest API is ready to be consumed! Enjoy