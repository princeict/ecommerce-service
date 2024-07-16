#FROM openjdk:11 as build
FROM maven:3.8.1-jdk-11-openj9
# Set working directory
WORKDIR /var/www/html/
COPY . /var/www/html
COPY settings.xml /root/.m2/
COPY settings.xml /root/.m2/settings-docker.xml
#RUN apt-get update -y
#RUN apt-get install -y iputils-ping

CMD ["/bin/sh"]