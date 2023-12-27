FROM us-docker.pkg.dev/come-play-with-us/media-docker/base-image/build-java17:latest as build
COPY . /usr/demo

USER root
WORKDIR /usr/demo
RUN mvn package

### Runtime build
FROM us-docker.pkg.dev/come-play-with-us/media-docker/base-image/runtime-java17:latest as runtime
COPY --from=build /usr/demo/target/demo-fgql-service-0.0.1.jar  app/demo-fgql-service.jar
USER root
ENTRYPOINT ["java","-jar","app/demo-fgql-service.jar"]