FROM openjdk:11-slim as packager
# First stage: JDK 11 with modules required for Spring Boot
RUN /usr/local/openjdk-11/bin/jlink \
    --module-path /usr/local/openjdk-11/jmods \
    --verbose \
    --add-modules java.base,java.logging,java.xml,jdk.unsupported,java.sql,java.naming,java.desktop,java.management,java.security.jgss,java.instrument \
    --compress 2 \
    --no-header-files \
    --output /opt/jdk-11-minimal

# Second stage, add only our custom jdk 11 distro and our app
FROM debian:stretch-slim
COPY --from=packager /opt/jdk-11-minimal /opt/jdk-11-minimal
COPY build/libs/*.jar /opt/

VOLUME /tmp

ENV JAVA_HOME=/opt/jdk-11-minimal
ENV PATH="$PATH:$JAVA_HOME/bin"

EXPOSE 8080
CMD /opt/jdk-11-minimal/bin/java -jar /opt/*.jar
