# Taktische-Zeichen-Java

Collection of Tactical Symbols as used by the German Aid Organisations, provided as 256px PNG images through a set of Java 11+ Modules.

![Zugführer - THW](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/symbol/personen/thw/Zugführer_TZ.png)
![Löschzug](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/symbol/einheiten/feuerwehr/Löschzug.png)
![Leitstelle](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/symbol/einrichtungen/Leitstelle.png)
![Gerettete Person](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/symbol/personen/Gerettete_Person.png)
![Gefahr durch Explosivstoffe](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/symbol/gefahren/Gefahr_durch_Explosivstoffe.png)
![Zugtrupp - THW](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/symbol/einheiten/thw/Zugtrupp.png)

## Description

This project has:

1. A script to convert the files from [jonas-koeritz/Taktische-Zeichen](https://github.com/jonas-koeritz/Taktische-Zeichen) into a java frienldly resource pack.
2. A Java 11, Maven Multi Module project producing a couple of Maven Central artefacts, utilising the Java 11 module system [here the Maven Site](https://liturner.github.io/Taktische-Zeichen-Java/)

## Attribution

A big thankyou to the project [jonas-koeritz/Taktische-Zeichen](https://github.com/jonas-koeritz/Taktische-Zeichen) for licensing the images provided here under the CC0-1.0 license. I did not produce any of the images in this library, I am only distributing them via a Java friendly mechanism.

This project has followed the same naming convention as a few other existing projects. Please take a few minutes to browse through them:

- [Taktische-Zeichen](https://github.com/jonas-koeritz/Taktische-Zeichen)
- [Taktische-Zeichen-drawio](https://github.com/MartinBoehmer/Taktische-Zeichen-drawio)

## Licenses

- [![License: MIT](https://img.shields.io/badge/License-MIT%201.0-lightgrey.svg)](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/LICENSE) This repository, the source code and compiled Jar files.
- [![License: CC0-1.0](https://img.shields.io/badge/License-CC0%201.0-lightgrey.svg)](https://creativecommons.org/publicdomain/zero/1.0/) The PNG files in this project (passing on the CC0 license given to the origional files).

## Building & Deploying

### The Website

The Maven Site is a fully fledged multi-module site, deployed to GitHub Pages. To be certain that the build fully works run the following commands in order (there are some nuances due to the tests module).

1. mvn clean
2. mvn verify
3. mvn site
4. mvn site:stage
5. mvn site-deploy

### The Package

At current you may need to run mvn release:prepare twice. The tests fail the first time, but not the second?
