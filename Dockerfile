FROM openjdk:11-jdk

EXPOSE 80

RUN apt-get update && apt-get install -y zip

RUN apt-get update && apt-get install -y \
    curl \
    && curl -s https://get.sdkman.io | bash \
    && bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install kotlin"

WORKDIR /app

COPY . /app

CMD ["bash", "-c", "source $HOME/.sdkman/bin/sdkman-init.sh && kotlin Application.kt"]
