# Taktische-Zeichen-Java

![Zugführer - THW](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/symbol/personen/thw/Zugführer_TZ.png)
![Löschzug](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/symbol/einheiten/feuerwehr/Löschzug.png)
![Leitstelle](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/symbol/einrichtungen/Leitstelle.png)

Taktische-Zeichen-Java is a Java project containing a set of tactical symbols from the project [jonas-koeritz/Taktische-Zeichen](https://github.com/jonas-koeritz/Taktische-Zeichen), packaged and distributed in a Java 11 friendly manner, using the Java Module System.

This is the parent module page. On the left under "Modules" you will find links to the sub module pages, which include the information and reports for the modules which this project produces. I have tried to keep the modules as lightweight as possible. You can either grab "just the images" from the "Taktische-Zeichen" module, or instead grab a set of Swing helpers using the "Taktische-Zeichen-Swing" module.

## Module & Package Structure

![UML Model](images/uml-model.png)

## Roadmap

- Add a JavaFX module.
- Figure out how to get the aggregate Javadoc working

## Attribution

A big thankyou to the project [jonas-koeritz/Taktische-Zeichen](https://github.com/jonas-koeritz/Taktische-Zeichen) for licensing the images provided here under [![License: CC0-1.0](https://img.shields.io/badge/License-CC0%201.0-lightgrey.svg)](https://creativecommons.org/publicdomain/zero/1.0/). I did not produce any of the images in this library, I am only distributing them via a Java friendly mechanism.

## Lessons Learned

- Allways start with a maven sub-group! When I started this project, it was my first Maven Central deployment. I pushed the first jar to de.turnertech.taktische-zeichen. This would have been better grouped under de.turnertech.tz, as now there are other modules, it makes the root messy. In future I will use de.turnertech.{project-acronym}.{artefact}.
