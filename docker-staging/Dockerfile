#FROM openjdk:11 as build
FROM maven:3.8.1-jdk-11-openj9
# Set working directory
WORKDIR /var/www/html/
COPY . /var/www/html
#RUN apt-get update -y
#RUN apt-get install -y iputils-ping
ENTRYPOINT ["java", "-jar", "apa-config.jar"]
#CMD ["/bin/sh"]
