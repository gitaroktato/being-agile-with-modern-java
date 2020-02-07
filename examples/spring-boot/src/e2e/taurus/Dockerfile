FROM openjdk:11

RUN apt update && \
    apt install -y python3-pip && \
    pip3 install bzt
ENTRYPOINT [ "bzt" ]
