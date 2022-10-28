# Made by: JJ-NavaC
## Compile without JADE
```console
javac Main.java -d classes/
```
## Run without JADE
```console
java -cp classes/ Main
```

## Compile with JADE
```console
javac -cp lib/jade.jar src/<class>.java src/<class1>.java -d classes/
```
## Run with JADE
```console
java -cp lib/jade.jar:classes/ jade.Boot -gui <AgentName>:<class>

java -cp lib/jade.jar:classes/ jade.Boot -container <AgentName>:<class1>
