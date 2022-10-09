FROM java:8-jre
ADD ./target/CmatchRecommend-0.0.1-SNAPSHOT.jar /usr/src/CmatchRecommend-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar","CmatchRecommend-0.0.1-SNAPSHOT.jar"]