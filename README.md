# D&D 5e Magic Items

This is a Java Spring MVC and Hibernante project to display a list of Magic Items inside a MySQL Database.



## How to Use

First, run a MySQL database with [jdbc:mysql://localhost:3306/dnd5e_magic_items_database?useSSL=false&amp;serverTimezone=UTC](jdbc:mysql://localhost:3306/dnd5e_magic_items_database?useSSL=false&amp;serverTimezone=UTC)
with a 'root' username and empty password. You can change this in this [XML Config File](https://github.com/jawwadbr/hb-mvc-magicItems-5e/blob/main/WebContent/WEB-INF/config-Springmvc-servlet.xml) inside the 'Step 1: Define Database DataSource / connection pool'.

After running the server, use the [sql-sample](https://github.com/jawwadbr/hb-mvc-magicItems-5e/blob/main/SQL%20Sample/sql-sample) 
data provided in this repository to create a database and all tables to be able to display something when testing.

Second, configure [Tomcat](https://tomcat.apache.org) inside your prefered IDE to run this project at [http://localhost:8080](http://localhost:8080) or any available port,
then run the project as Server.

If everything went correctly you should be able to see something like this:

![](https://i.imgur.com/6pqp4A6.png "example")
