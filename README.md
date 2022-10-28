# Lineal Regression with Agents
##### You must have 'openjdk 11.0.16' and 'javac 11.0.16' preinstalled on your Linux/UNIX OS
###### Made by: JJ-NavaC

Compile
```console
javac Main.java -d classes/
```
Run
```console
java -cp classes/ Main
```
# With JADE
Compile
```console
javac -cp lib/jade.jar src/*.java -d classes/
```
Run
```console
java -cp lib/jade.jar:classes/ jade.Boot -gui <AgentName>:<class>

java -cp lib/jade.jar:classes/ jade.Boot -container <Agent1Name>:<class1>

java -cp lib/jade.jar:classes/ jade.Boot -container <Agent2Name>:<class2>