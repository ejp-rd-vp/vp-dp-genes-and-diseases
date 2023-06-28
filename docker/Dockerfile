FROM openjdk:18-jdk-alpine
VOLUME /tmp
EXPOSE 8095
RUN addgroup -S ejp && adduser -S ejp -G ejp
USER ejp:ejp
COPY --from=build target/*.jar /opt/app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /opt/app.jar"]
