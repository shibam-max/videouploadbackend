Make sure that Myql DB is up and running
Make sure to create a database in MYSql and point the backend to the specific DB
For example,
I have created the video_demo DB inside Mysql
set the properties in application properties file
For example,
spring.datasource.url= jdbc:mysql://localhost:3306/video_demo
Please update the application.properties file to set the DB username and password
For example,
spring.datasource.username=root
spring.datasource.password=Shibam@12345
Specify the port where backend application will run
server.port=8082
Build the image using,
sudo docker build -t <Image Name> .
Run the image using,
sudo docker run -d --network="host" <Image Name>
