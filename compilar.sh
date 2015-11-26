# seteo de ANT_HOME
export ANT_HOME=~/apache-ant-1.9.6/

# seteo de private.properties
# esto es para que cada uno descomente su private.properties dependiendo de la cuenta
# o maquina en la que esté
rm -r ./WebApp/nbproject/private/
mkdir ./WebApp/nbproject/private/

# marccio fing
STR=$'deploy.ant.properties.file=/ens/home01/m/marccio.silva/.netbeans/8.0/tomcat80.properties\nj2ee.server.home=/ens/home01/m/marccio.silva/apache-tomcat-8.0.28\nj2ee.server.instance=tomcat80:home=/ens/home01/m/marccio.silva/apache-tomcat-8.0.28\njavac.debug=true\njavadoc.preview=true\nselected.browser=default\nuser.properties.file=/ens/home01/m/marccio.silva/.netbeans/8.0/build.properties'
# marccio casa
# STR=$'deploy.ant.properties.file=/home/marccio/.netbeans/8.0.2/tomcat80.properties\nj2ee.server.domain=/home/marccio/.netbeans/8.0.2/apache-tomcat-8.0.15.0_base\nj2ee.server.home=/home/marccio/apache-tomcat-8.0.15\nj2ee.server.instance=tomcat80:home=/home/marccio/apache-tomcat-8.0.15:base=apache-tomcat-8.0.15.0_base\njavac.debug=true\njavadoc.preview=true\nselected.browser=default\nuser.properties.file=/home/marccio/.netbeans/8.0.2/build.properties'
# marccio laptop
# STR=$'deploy.ant.properties.file=/home/marccio/.netbeans/8.0.2/tomcat80.properties\nj2ee.server.domain=/home/marccio/.netbeans/8.0.2/apache-tomcat-8.0.15.0_base\nj2ee.server.home=/usr/local/apache-tomcat-8.0.15\nj2ee.server.instance=tomcat80:home=/usr/local/apache-tomcat-8.0.15:base=apache-tomcat-8.0.15.0_base\njavac.debug=true\njavadoc.preview=true\nselected.browser=default\nuser.properties.file=/home/marccio/.netbeans/8.0.2/build.properties'

# martin fing
#STR=$'deploy.ant.properties.file=/ens/home01/m/martin.rucci/.netbeans/8.0/tomcat80.properties\nj2ee.server.home=/ens/home01/m/martin.rucci/apache-tomcat-8.0.28\nj2ee.server.instance=tomcat80:home=/ens/home01/m/martin.rucci/apache-tomcat-8.0.28\nj2ee.server.instance=tomcat80:home=/ens/home01/m/martin.rucci/apache-tomcat-8.0.28/\njavac.debug=true\njavadoc.preview=true\nselected.browser=default'

# gaston
#STR=$''

# sofia
#STR=$''

# ignacio
#STR=$''

# comando para sobreescribir el private.properties ya existente
echo "$STR" > ./WebApp/nbproject/private/private.properties 
# build servidor central
ant -buildfile ./ServidorCentral/build.xml compile jar
# build de web app
ant -lib ~/apache-ant-1.9.6/lib/ -buildfile ./WebApp/build.xml compile do-dist
# build y run de estacion de trabajo
ant -buildfile ./EstacionDeTrabajo/build.xml compile jar

