# No matching image for arm64 - mac w.r.t eclipse-temurin:17-jdk-alpine
#FROM eclipse-temurin:17-jdk-alpine
# so using bellsoft/liberica-openjdk-alpine-musl:17, this works fine with mac - arm 64 arch
FROM bellsoft/liberica-openjdk-alpine-musl:17

VOLUME /tmp

ARG JAR_FILE

COPY ${JAR_FILE} app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar"]

