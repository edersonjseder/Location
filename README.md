# Location Webservice RESTful in Spring, JAX-RS e Jersey, Hibernate 4 e MySQL

Here you will find a small project that aims to expose a REST service to list cities. it was upgraded to use some of the newest versions of frameworks to achieve better productive, faster and good results for development.

It was developed in Java 8 (1.8.0) and uses Tomcat 8.5 to deploy the application. The RESTFull service
Data manipulation layer is made by JAX-RS and Jersey, which are very easy to implement and maintain. It's used 
Spring 4 MVC for DI and using it with Jersey together and Maven as our dependency manager and MySQL 
Database for the entities.

There are some scripts for MySQL with some inserts of a few entries in each table and the creation of the Schema, which is necessary. The application creates 
the tables and its relationships

# Proposed exercise

 <i><b>The purposes of this project:</b></i>

* Creates Entity classes of City and Country for the tables and its relationships

* The Data manipulation layer uses the framework Hibernate 4 in MySQL database.

* It uses Dependency Injection of Spring Framework to instanciate the service classes

* Uses JAX-RS specification with Jersey implementation to create GET and POST requisitions using REST service
  to retrieve a list of cities in the database, and return them as a JSON object.

* There is an Android application that consumes this project as a service and makes the operation to load data into the database using Web services in REST

<i><b>The Deployment of this project:</b></i>

The .war file is attached with this project. And also can be done using eclipse by following these steps:
<ol>
<li>Right click on the location project folder</li>
<li>Running the menu <i><b> > Run > As > Maven install</b></i></li><br/> 

<i>

Expected Result:<br/> 
Results :<br/> <br/> 

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0<br/> <br/> 

[INFO]<br/> 
[INFO] --- maven-war-plugin:2.2:war (default-war) @ location ---<br/> 
[INFO] Packaging webapp<br/> 
[INFO] Assembling webapp [location] in [/root/workspace/location/target/location]<br/> 
[INFO] Processing war project<br/> 
[INFO] Copying webapp resources [/root/workspace/location/src/main/webapp]<br/> 
[INFO] Webapp assembled in [291 msecs]<br/> 
[INFO] Building war: /root/workspace/location/target/location.war<br/> 
[INFO] WEB-INF/web.xml already added, skipping<br/> 
[INFO] <br/> 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ location ---<br/> 
[INFO] Installing /root/workspace/location/target/location.war to /root/.m2/repository/com/aroundinfo/project/location/0.0.1-SNAPSHOT/location-0.0.1-SNAPSHOT.war<br/> 
[INFO] Installing /root/workspace/location/pom.xml to /root/.m2/repository/com/aroundinfo/project/location/0.0.1-SNAPSHOT/location-0.0.1-SNAPSHOT.pom<br/> 
[INFO] ------------------------------------------------------------------------<br/> 
[INFO] BUILD SUCCESS<br/> 
[INFO] ------------------------------------------------------------------------<br/> 
[INFO] Total time: 9.876 s<br/> 
[INFO] Finished at: 2017-04-16T22:10:30-04:00<br/> 
[INFO] Final Memory: 13M/198M<br/> 
[INFO] ------------------------------------------------------------------------<br/> 
The .war file will be in the <i>target</i> folder of the project (in my case, in <i><b>/root/workspace/location/target</b></i>)
</i>
<li>Stop the Tomcat Server service</li>
<li>To deploy in Tomcat 8 server, copy the .war file in the webapps in <i>tomcat directory</i> (<i><b>your_host/tomcat/apache-tomcat-8.5.13/webapps</b></i> the menu <i><b> > Run > As > Maven install</b></i>)</li><br/> 
<li>Restart the Tomcat Server service and test the .war using the browser with the URL: http://your_ip:8080/location/rest/cities/city (can be the default localhost:8080)</li>
<li>After you have it deployed (check the /logs dir for any problems), it should be accessible via: <u><i>http://your_host:your_port/location/rest/cities/city</i></u>. Or in the default, one of those:<br/>
<u><i>http://the_ip:the_port/location/rest/cities</i></u>
<u><i>http://the_ip:the_port/location/rest/country</i></u><br/>
</li>
</ol>

<i><b>The Database usage of this project:</b></i>

The database is MySQL Database 5 and it's used the following credentials to access:<p>
<p><b>Username:</b> <i>root</i><br/>
<p><b>Password:</b> <i>a</i><br/>
<p><b>Schema:</b> <i>aroundinfo</i><br/>
<p><b>Url:</b> <i>jdbc:mysql://localhost:3306/aroundinfo</i><br/>

And can be changed at the <i>connection.properties</i> file in the .war file to better attend portability. Please change for the proper database.

<i><b>The Database usage of this project:</b></i>
