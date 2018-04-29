to start up the projectm, we need to do things as following:
1. execute the sql script  DDL.sql in the root path
2. modify the configure file ${ROOT}/src/main/resources/application.properties as your database configuration
    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
    spring.datasource.url=jdbc:mysql://localhost:3306/test?characterEncoding=utf8
    spring.datasource.username=root
    spring.datasource.password=root
3. right click of the ${ROOT}/src/main/top/wolearning/controller/WoLearningApplication file,
    the click Run

Notes: the document is written based on the idea IDE.