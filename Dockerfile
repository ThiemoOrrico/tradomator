FROM openjdk:17
ENV ENVIRONMENT = dev
MAINTAINER Thiemo Orrico <thiemobile@o2online.de>
ADD backend/target/tm-dev.jar tm-dev.jar
CMD [ "sh", "-c", "java -Dserver.port=$PORT -Dspring.data.mongodb.uri=$Mongo_DB_URI -jar /tm-dev.jar" ]