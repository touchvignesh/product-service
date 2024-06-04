FROM alpine:latest
RUN apk add --no-cache openjdk21
RUN apk add --no-cache tzdata
COPY build/libs/product-service-1.0-SNAPSHOT.jar /product-service-1.0-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "/product-service-1.0-SNAPSHOT.jar"]
