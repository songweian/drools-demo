FROM jboss/wildfly:23.0.2.Final
COPY --chown=jboss:jboss business-central.war /opt/jboss/wildfly/standalone/deployments/
COPY --chown=jboss:jboss standalone.conf /opt/jboss/wildfly/bin/
RUN /opt/jboss/wildfly/bin/add-user.sh -a -u 'kieserver' -p 'kieserver1!' -g 'kie-server,admin,rest-all' -s