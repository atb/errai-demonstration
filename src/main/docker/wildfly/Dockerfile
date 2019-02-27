FROM jboss/wildfly:15.0.1.Final

RUN cd /opt/jboss/wildfly/standalone/configuration/ && \
    sed -i 's|<deployment-scanner|<deployment-scanner auto-deploy-exploded="true"|g' standalone.xml
