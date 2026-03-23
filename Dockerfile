FROM bellsoft/liberica-openjdk-alpine:21 AS builder
WORKDIR /app
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
RUN chmod +x ./gradlew
RUN ./gradlew dependencies --no-daemon
COPY src src
RUN ./gradlew clean bootJar --exclude-task test --no-daemon

FROM bellsoft/liberica-openjre-alpine:21
WORKDIR /app
ENV SPRING_PROFILE=production
COPY --from=builder /app/build/libs/*-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]