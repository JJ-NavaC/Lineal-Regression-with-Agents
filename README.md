# Lineal Regression with Agents
###### Made by: JJ-NavaC
#### You must have 'openjdk 11.0.16' and 'javac 11.0.16' preinstalled on your Linux/UNIX OS

##### Compile
```console
javac Main.java -d classes/
```
##### Run
```console
java -cp classes/ Main
```
## With JADE
##### Compile
```console
javac -cp lib/jade.jar src/*.java -d classes/
```
##### Run
```console
java -cp lib/jade.jar:classes/ jade.Boot -gui SLR_Agent:SLR_Agent
```

```console
java -cp lib/jade.jar:classes/ jade.Boot -container DG_Agent:DG_Agent
```

```console
java -cp lib/jade.jar:classes/ jade.Boot -container MLR1_Agent:MLR1_Agent
```

```console
java -cp lib/jade.jar:classes/ jade.Boot -container MLR2_Agent:MLR2_Agent
```

```console
java -cp lib/jade.jar:classes/ jade.Boot -container Sender_Agent:Sender_Agent
```