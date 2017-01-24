# Wildfly Swarm -Swagger Fraction- Test Application

This applications can be used to test the bug in the Wildfly Swarm Swagger fraction that prevents the user from
setting the basePath. https://issues.jboss.org/browse/SWARM-839

After running Main.java you should see the configured context root ('/context') as basePath in the Swagger definition
at http://localhost:8080/context/swagger.json