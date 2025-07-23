# Rest-Converter


## Description
A EUPL licensed, spring boot web service to convert
UBL, CII and FatturaPA XMLs into one another 
based on Martins Java11+ [fork](https://github.com/5now/EeISI-mapper)
of [EEISI/EICAR](https://github.com/AgID/EeISI-mapper/).

## Build

Get and build `mvn install -Prelease` Martins fork and install 
it in your local maven cache.
`mvn install:install-file -Dfile="eigor-api\target\eigor-api-full-4.4.4-SNAPSHOT.jar" -DgroupId="it.infocert.eigor" -DartifactId=eigor-api -Dversion="4.4.4-SNAPSHOT" -Dpackaging=jar -DgeneratePom=true`
Then `mvn clean package` will build you a war.

## Deploy 

The war is self-running so in case of a emergency a `java -jar mustang-mapper-1.0.0.war` will work.
You risk `An error occurred while configuring...` exceptions if /converterdata is not in the same directory like your war.


## Run 
Access e.g. 
http://127.0.0.1:8000/swagger-ui/index.html
for a HTML frontend

