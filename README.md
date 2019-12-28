# contentapp-backend

This project implemented by using Spring.(Spring Security,JPA,HIBERNATE)
# database
Database : PostgreSQL<br/>
You must create a database in PostgreSQL and replace name of database in application.properties file and change username and password.<br/>
spring.datasource.url = jdbc:postgresql://localhost:5433/YOUR_DB_NAME<br/>
spring.datasource.username = YOUR_USERNAME<br/>
spring.datasource.password = YOUR_PASSWORD<br/>
You must add persons and their role from database<br/>
Example;<br/>
person table;<br/>
id:1 <br/>
username:admin<br/>
password::$2a$10$/kJjmY.pIc/h4jyK1o/5Wet7ztu.TnzvhmY.M69Myvvpe.7abYQXK ("pass" BEncripted)<br/>
admin_id:null  (null for admins)<br/><br/>

id:2<br/>
username:user<br/>
password:$2a$10$/kJjmY.pIc/h4jyK1o/5Wet7ztu.TnzvhmY.M69Myvvpe.7abYQXK<br/>
admin_id:1<br/>
role table;<br/>
id:1<br/>
role:ADMIN<br/>
<br/>
id:2<br/>
role:USER<br/>
person_role table;<br/>
person_id:1<br/>
role_id:1<br/>
<br/>
person_id:2<br/>
role_id:2<br/>
<br/>
#app
If you want to add a record to content table from database you must give big number to its primary key like 1000.Cause pk is generated automaticly by spring.<br/>
<br/>
If there is an another app that running on your pc and using port 8080 you must change the this apps port from application.properties file;<br/>
server.port = 8081
