FROM alpine:latest
RUN apk add --no-cache openjdk21
RUN apk add --no-cache tzdata
ENV TZ=Asia/Kolkata
COPY build/libs/product-service-1.0-SNAPSHOT.jar /product-service-1.0-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "/product-service-1.0-SNAPSHOT.jar"]
