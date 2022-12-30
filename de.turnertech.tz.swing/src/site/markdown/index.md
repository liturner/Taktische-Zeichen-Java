# Taktische-Zeichen-Swing

![Gerettete Person](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/symbol/personen/Gerettete_Person.png)
![Gefahr durch Explosivstoffe](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/symbol/gefahren/Gefahr_durch_Explosivstoffe.png)
![Zugtrupp - THW](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/symbol/einheiten/thw/Zugtrupp.png)

Taktische-Zeichen-Java is a Java project containing a set of tactical symbols from the project [jonas-koeritz/Taktische-Zeichen](https://github.com/jonas-koeritz/Taktische-Zeichen), packaged and distributed in a Java 11 friendly manner, using the Java Module System.

This maven artefact (jar) depends on the de.turnertech:taktische-zeichen (Taktische-Zeichen in the menu on the left) artefact containing the actual symbols, and some tools for getting a list of ImageIcons. The java.desktop module is also transitively required. For more information on the modules and classes, check out the [Javadoc](apidocs/de.turnertech.tz.swing/module-summary.html) under Project Reports on the left.

Maven and Gradle dependency information is [here](dependency-info.html).

Check out the [Usage](usage.html) page for some hints on how to integrate this module into your code.