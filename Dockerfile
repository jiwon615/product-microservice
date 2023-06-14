FROM openjdk:17
VOLUME /tmp
COPY build/libs/product-service-1.0.jar JimartProductService.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "JimartProductService.jar"]