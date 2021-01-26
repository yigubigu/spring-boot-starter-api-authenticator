projName=api-authenticator
group=api
subGroup=authenticator
rm pom.xml
mvn archetype:generate -DgroupId=com.ruize.$group.$subGroup -DartifactId=spring-boot-starter-$projName -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
mv spring-boot-starter-$projName/pom.xml .
rm -rf spring-boot-starter-$projName
./run-ubuntu.sh
mvn archetype:generate -DgroupId=com.ruize.$group.$subGroup -DartifactId=$projName -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
mvn archetype:generate -DgroupId=com.ruize.$group.$subGroup -DartifactId=$projName-spring-boot-autoconfig -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
mvn archetype:generate -DgroupId=com.ruize.$goup.$subGroup -DartifactId=$projName-spring-boot-starter -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
mvn archetype:generate -DgroupId=com.ruize.$group.$subGroup  -DartifactId=$projName-spring-boot-sample-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false