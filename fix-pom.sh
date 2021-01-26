sed -i '21,74d' /work/pom.xml
sed -i '11 a <packaging>pom</packaging>' /work/pom.xml
sed -i 's/<maven.compiler.source>1.7<\/maven.compiler.source>/<maven.compiler.source>1.8<\/maven.compiler.source>/g' /work/pom.xml
sed -i 's/<maven.compiler.target>1.7<\/maven.compiler.target>/<maven.compiler.target>1.8<\/maven.compiler.target>/g' /work/pom.xml



