# This example is taken from
# https://www.youtube.com/watch?v=6vjo3pMXW7I

FROM tomcat:8.5-alpine

# copying war from target folder to container's tomcat
COPY target/SpringBootJavaProject-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/SpringBootJavaProject.war
#
RUN ["touch","/usr/local/tomcat/webapps/SpringBootJavaProject.war"]

# Testing volume
RUN mkdir /data
RUN touch /data/greeting.txt
RUN echo "hello" > /data/greeting.txt
RUN ls -ltr /data
# this volume will be created at /var/lib/docker/volumes in docker host machine. I was not able to find it for 'Docker for Mac' version of docker though.
# I tried -v ~/Desktop/Temp/sampledockervolume:/data option with docker run command but for some reason, I could not make it work. I didn't see greeting.txt created at ~/Desktop/Temp/sampledockervolume
VOLUME ["/data"]

# Running spring boot war application
ENTRYPOINT ["java","-jar", "/usr/local/tomcat/webapps/SpringBootJavaProject.war"]