FROM openjdk:17
ENV ENVIRONMENT = dev
MAINTAINER Thiemo Orrico <thiemobile@o2online.de>
ADD backend/target/tm-dev.jar tm-dev.jar
CMD [ "sh", "-c", "java -Dserver.port=$PORT -jar /tm-dev.jar" ]