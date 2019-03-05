Errai Demonstration
===================

This is a demo application that demonstrates several Errai technologies.

Errai is a GWT-based framework for building rich web applications using next-generation web technologies. See [Errai](http://erraiframework.org).

GWT is a development toolkit for building and optimizing complex browser-based applications. With GWT, client and server parts of a web application are written in Java. 
See [GWT Project](http://www.gwtproject.org). 

This demonstration is based on [errai-jpa-demo-todo-list](https://github.com/errai/errai/tree/master/errai-demos/errai-jpa-demo-todo-list) 
but it has been updated to a "contact list application" and simplified as much as possible. 

Prerequisites
-------------

 * Java JDK 8
 * Maven 3 (run `mvn --version` on the command line to check)
   
 * WildFly 10.0.0.Final 
   * Warning: It seems that Errai 4.1.0 will work only with WildFly 10.0.0 (To be checked 
     when possible)
   * Wildfly should be automatically downloaded by Maven. It is not required to install 
     it mannually.

If you wish to configure a datasource in WidlFly, edit the file `standalone/configuration/standalone.xml`
and add this immediately after the similar entry for `ExampleDS`:

    <datasource jndi-name="java:jboss/datasources/ErraiTodoDS" pool-name="ErraiTodoDS" enabled="true" use-java-context="true">
      <connection-url>jdbc:h2:mem:erraiTodo;DB_CLOSE_DELAY=-1</connection-url>
      <driver>h2</driver>
      <security>
        <user-name>sa</user-name>
        <password>sa</password>
      </security>
    </datasource>

Of course, you are encouraged to configure the data source to connect to a more permanent database
such as PostgreSQL or MySQL instead of H2. With the above "in-memory" configuration, the data you
enter into the demo will not survive restarts of the app server.

Code-and-Refresh
----------------

To execute the application while in development you should use the GWT's dev mode.

You do that by executing in the folder of the project:

    % mvn gwt:run

Then click "Launch in Default Browser" on the GWT Dev Mode window that appears. Or 
you can open Chrome and enter the following url: http://127.0.0.1:8888/errai-demonstration

Notes: 
- Maven will download and use WildFly. The Maven property `errai.jboss.home` (in the `pom.xml`) 
contains the full path to the home directory of the application server (i.e., WildFly). 
- For this reason the first time you execute this command it may take some time to 
  execute. Please be patient.

Debug Client Code
-----------------

If you use Chrome you can debug client code using the menu option "View/Developer/Developer Tools". 

When you start the application using "mvn gwt:run" a server code is started (using 
the address 127.0.0.1:9876). This server code is able to map between the generated javascript and 
the original java. You should be able to access the java code in "127.0.0.1:9876/sourcemaps/ContactList". 
There you can see the java code and set breakpoints. 

Debug Server Code
-----------------

If you wish to debug the server code you need to open the project in a Java IDE. It 
is recommended to use Eclipse or IntelliJ.

You should set the breakpoints in the source code of the server part of the applications.

Then type in a command line:

    % mvn gwt:debug

Maven will start in debug mode and will wait until the IDE is connected to the debug 
session. In Eclipse you can do this by creating a "Remote Java Application" debug configuration setting host 
to localhost and por to 8000.

Build and Deploy
----------------

We recommend to download and install Wildfly version 10.0.0.Final from [Wildfly.org](http://wildfly.org/downloads/).

If you have installed manually WidlFly then you can use the following instructions 
to install the application in WildFly.

To build a .war file with the application

    % mvn clean package 

and deploy it to the local running WildFly instance (in this example WILDFLY_HOME is 
where Wildfly is installed):

    % cp target/errai-demonstration.war WILDFLY_HOME/standalone/deployments
    % touch WILDFLY_HOME/standalone/deployments/errai-demonstration.war.dodeploy

Note that the last command is optional since Wildfly will auto-deploy the war when 
it is detected in the deployments folder. 

If you have a Windows system then the last command should be:

    % echo>> WILDFLY_HOME/standalone/deployments/errai-demonstration.war.dodeploy

Once the above command has completed, you should be able to access the app at the following URL:

    http://localhost:8080/errai-demonstration/

See [Wildfly Application Deployment](https://docs.jboss.org/author/display/WFLY10/Application+deployment) for further 
details.

Gradle
------

To debug the server code in docker/wildfly see: [link](https://stackoverflow.com/questions/46082411/debugging-a-wildfly-application-on-docker-through-eclipse)

The command is:

    docker run -it -p 8080:8080 -p 8787:8787 jboss/wildfly /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 --debug

How to convert docker run into compose: [link](https://stackoverflow.com/questions/49984686/convert-a-docker-run-command-into-a-docker-compose)

See also: [link1](http://docs.wildfly.org/14/Developer_Guide.html#JPA_Reference_Guide)

To solve the debug port problem with wildly and docker see [link](https://stackoverflow.com/questions/53198798/remote-debugging-no-connection-to-wildfly-14-on-openjdk-11-at-port-8787)

How to configure H2 to store data in the file system: [link](https://stackoverflow.com/questions/9461770/where-does-h2s-embedded-databases-store-the-data)

>>> NOTA: PROVAVELMENTE O WILDFLY 15 NÃO TEM DEFINIDO O DATASOURCE QUE ESTÁ REFERIDO NO 
persistence.xml <<<<

To open a bash shell in the docker wildfly do:

    docker exec -i -t demo_wildfly /bin/bash

Admin console: http://127.0.0.1:9990

>> Testing in a local wildfly 15 installation. The problem seems to be related to the 
@injectd objects are not working. See EntityManagerFactory...

Note:
Testing in local wildfly 15:
1- copy war to deployment wildfly
2- run standlone
3- a h2 database in ~/test-db/test is created
4- open the database with h2 console (after stoping wildfly)
5- the table is created but it is empty!!!

>>> It should be related to the h2 driver version and the transaction model?!
    - Even if we manually insert a record in the table JPA will not "load" it in the application!!!!
- Problem fixed: See persistence.xml

