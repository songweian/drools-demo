docker run -it --name kie-server \
  -p 8082:8080 \
  -e JAVA_OPTS="-Xms256m -Xmx512m -Djava.net.preferIPv4Stack=true" \
  -e KIE_SERVER_ID=kie-server-docker \
  -e KIE_SERVER_USER=kie \
  -e KIE_SERVER_PWD=123456 \
  -e org.kie.server.location=http://kie-server.orb.local:8080/kie-server/services/rest/server \
  -e KIE_SERVER_LOCATION=http://kie-server.orb.local:8080/kie-server/services/rest/server \
  -e KIE_SERVER_CONTROLLER=http://http://wizardly_kilby.orb.local:8080/business-central/rest/controller \
  -e KIE_SERVER_CONTROLLER_USER=kie \
  -e KIE_SERVER_CONTROLLER_PWD=123456 \
quay.io/kiegroup/kie-server:7.74.1.Final

docker run -it --name kie-server -p 8082:8080 -p 9992:9990 quay.io/kiegroup/kie-server:7.74.1.Final