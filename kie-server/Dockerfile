FROM quay.io/kiegroup/kie-server:7.74.1.Final
ADD standalone.conf /opt/jboss/wildfly/bin/standalone.conf
RUN /opt/jboss/wildfly/bin/add-user.sh -a -u 'kieserver' -p 'kieserver1!' -g 'kie-server,admin,rest-all' -s