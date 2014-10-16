@echo on
echo ### Generate XML Beans Package JAR file + mvn install

@set DIR_BATCH_FILE=%CD%

@IF EXIST src. (
	rmdir src /S/q
	@call ping 1.1.1.1 -n 1 -w 3000 > nul
)

@call ant
@copy standAlone-XBeans.jar ..\custom-libs
@del standAlone-XBeans.jar
@cd ..\custom-libs
@call mvn install:install-file -DgroupId=custom -DartifactId=standAlone-XBeans -Dversion=1.0 -Dfile=standAlone-XBeans.jar -Dpackaging=jar -DgeneratePom=true
@cd %DIR_BATCH_FILE%
echo ### DONE
