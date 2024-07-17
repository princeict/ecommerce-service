FROM maven:3.8.1-jdk-11-openj9
# Set working directory
WORKDIR /var/www/html/
COPY . /var/www/html

ENTRYPOINT ["java", "-jar", "ecommerce-service.jar"]