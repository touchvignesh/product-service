FROM alpine:latest
RUN apk add --no-cache openjdk21
RUN apk add --no-cache tzdata
COPY build/libs/product-service-1.0-SNAPSHOT.jar /product-service-1.0-SNAPSHOT.jar
COPY scripts/setenv.sh /setenv.sh
RUN chmod +x /setenv.sh
EXPOSE 8080
ENTRYPOINT ["/setenv.sh"]
CMD ["java", "-jar", "/product-service-1.0-SNAPSHOT.jar"]
