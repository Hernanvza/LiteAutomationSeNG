@echo off

set JAVA_HOME=C:\Program Files\Java\jdk-17.0.2  set MAVEN_HOME=C:\apache-maven-3.9.1             set PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%

cd C:\Users\hernan.valenzuela\Documents\Proyectos\LiteAutomation\SeleniumTestNGKarateProject\src\test  mvn test -Dtest=AmazonPurchaseNegativeTest,AmazonPurchaseTest,PruebaNGTest,ExampleTest