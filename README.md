*ESPAÑOL*  
--------  
Parser externo para la herramienta SemanticMerge escrito en Java.  
Pese a imprimirse por pantalla manualmente, los ficheros de prueba y los ficheros YAML generados SÍ están relacionados.  
Un formato erróneo o incorrelado del YAML produce que no funcione el parser.  
Para hacerlo funcionar se utiliza el archivo JAR con el comando: _.\semanticmergetool.exe  --source=x.prueba --destination=y.prueba --externalparser="-jar DumbParser.jar" --virtualmachine="C:\Program Files\Java\jdk-11.0.8\bin\java.exe"_   
En caso de modificar el archivo original, se construye de nuevo el JAR con: _jar cvfe DumbParser.jar DumbParser DumbParser.class_
 
 
*ENGLISH*
---------  
External parser written in Java for SemanticMerge tool.  
Even though the output file is written manually in the terminal, the sample files and the output YAML files are do correlated.  
A bad formatting of the file or uncorrelated files will make the parser not work.  
To execute the external parser, the JAR its used instead of a .exe file. Command: _.\semanticmergetool.exe  --source=x.prueba --destination=y.prueba --externalparser="-jar DumbParser.jar" --virtualmachine="C:\Program Files\Java\jdk-11.0.8\bin\java.exe"_  
In case of modifying the original file, the JAR is built with the command: _jar cvfe DumbParser.jar DumbParser DumbParser.class_
