FROM java:8
MAINTAINER shane@suirtech.com
VOLUME /tmp
EXPOSE 7001
ENV USER_NAME stadmin
ENV APP_HOME /home/$USER_NAME/user-app
RUN useradd -ms /bin/bash $USER_NAME
RUN mkdir $APP_HOME
ADD target/user-app.jar $APP_HOME/user-app.jar
RUN chown $USER_NAME $APP_HOME/user-app.jar
USER $USER_NAME
WORKDIR $APP_HOME
RUN bash -c 'touch user-app.jar'
ENTRYPOINT ["java","-jar","user-app.jar"]
