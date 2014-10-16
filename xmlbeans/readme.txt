Xmlbeans: Converting XSD to JAVA objects (schemaClasses.jar)

1.Run xGeneration.bat

OR OR

1.Run the ANT file, which reads XSD(s) and generated the corresponding 
-JAVA object representation of XSD.

2.Jar the generated classes (JAVA class representation of XSD files) and copy
-to custom-lib folder for amven to upload the custom lib.

3.Use the generated 'schemaClasses.jar' for further xmlBeans POC.

mvn install:install-file -DgroupId=custom -DartifactId=schemaClasses -Dversion=1.0 -Dfile=C:\software\projects\source\poc\standAlone\custom-libs\standAlone-XBeans.jar -Dpackaging=jar -DgeneratePom=true
