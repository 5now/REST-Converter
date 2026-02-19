# Rest-Converter


## Description
A EUPL licensed, spring boot web service to convert
UBL, CII and FatturaPA XMLs into one another 
based on Martins Java11+ [fork](https://github.com/5now/EeISI-mapper)
of [EEISI/EIGOR](https://github.com/AgID/EeISI-mapper/).

## Build

Get and build `mvn install -Prelease` from 
Martins fork of EeISI-mapper and install 
it in your local maven cache.
Then `mvn clean package` will then build you a jar.

## Deploy 

The jar is self-running so a `java -jar REST-converter-1.7.0.jar` will work.
You will need to deploy src/main/resources/converterdata  as /converterdata 
in the same directory, otherwise `An error occurred while configuring...` exceptions w.


## Run

Access e.g. 
http://127.0.0.1:8000/swagger-ui/index.html
for a HTML frontend

## Internal EEISI/EIGOR config

The eigor.properties in resources, based on
[this](https://github.com/AgID/EeISI-mapper/blob/master/src/site/markdown/enable-customizations.md)
contains one additional reverse engineered item, but some 
converters are apparently work in progress. Only the 
converters from the subdirectories in converter-commons are loaded, 
so at least the ones which did not work were removed.

The validation can not be switched off and it requires files 
that can not be included in the classpath ("correcting" it in 
eigor.properties won't work), thats the reason for the need 
to deploy converterdata as mentioned in the deploy-section.