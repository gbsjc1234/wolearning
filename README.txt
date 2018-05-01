to start up the projectm, we need to do things as following:
1. execute the sql script  DDL.sql and DML.sql in the root path
2. modify the configure file ${ROOT}/src/main/resources/application.properties as your database configuration
    spring.datasource.driver-class-name=com.mysql.jdbc.Driver
    spring.datasource.url=jdbc:mysql://localhost:3306/test?characterEncoding=utf8
    spring.datasource.username=root
    spring.datasource.password=root
3. right click of the ${ROOT}/src/main/top/wolearning/controller/WoLearningApplication file,
    the click Run

Notes: the document is written based on the idea IDE.

centos7 install mysql:
# 下载mysql源安装包
shell> wget http://dev.mysql.com/get/mysql57-community-release-el7-8.noarch.rpm
# 安装mysql源
shell> yum localinstall mysql57-community-release-el7-8.noarch.rpm
检查mysql源是否安装成功

shell> yum repolist enabled | grep "mysql.*-community.*"
看到上图所示表示安装成功。
可以修改vim /etc/yum.repos.d/mysql-community.repo源，改变默认安装的mysql版本。比如要安装5.6版本，将5.7源的enabled=1改成enabled=0。然后再将5.6源的enabled=0改成enabled=1即可。

shell> yum install mysql-community-server

shell> systemctl start mysqld

