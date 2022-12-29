# Taktische-Zeichen-Java

Taktische Zeichen für Hilfsorganisationen als 256px PNG in eine Java Bibliotech.

![Zugführer - THW](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/personen/thw/Zugführer_TZ.png)
![Löschzug](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/einheiten/feuerwehr/Löschzug.png)
![Leitstelle](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/einrichtungen/Leitstelle.png)
![Gerettete Person](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/personen/Gerettete_Person.png)
![Gefahr durch Explosivstoffe](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/gefahren/Gefahr_durch_Explosivstoffe.png)
![Zugtrupp - THW](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/de.turnertech.tz/src/main/resources/de/turnertech/tz/einheiten/thw/Zugtrupp.png)

## Zuschreibung

Vielen dank zu den Projekt [jonas-koeritz/Taktische-Zeichen](https://github.com/jonas-koeritz/Taktische-Zeichen) für die bereistellung die Bilder unter [![License: CC0-1.0](https://img.shields.io/badge/License-CC0%201.0-lightgrey.svg)](https://creativecommons.org/publicdomain/zero/1.0/)!

Diese Projekt ist absichtlich ähnlich wie einige bereits existierende Projekte. Bitte besuch die mal!:

- [Taktische-Zeichen](https://github.com/jonas-koeritz/Taktische-Zeichen)
- [Taktische-Zeichen-drawio](https://github.com/MartinBoehmer/Taktische-Zeichen-drawio)

## Maven Central Dependency

```xml
<dependency>
  <groupId>de.turnertech</groupId>
  <artifactId>taktische-zeichen</artifactId>
  <version>...</version>
</dependency>
```

## Beschreibung

Diese Projekt hat:

1. Eine Skript um die Dateien von [jonas-koeritz/Taktische-Zeichen](https://github.com/jonas-koeritz/Taktische-Zeichen) in eine Java freundlich Strukture umzuwandeln zu können.
2. Eine Java 11 Maven Projekt, mit ein paar Maven / Java modulen [here](https://liturner.github.io/Taktische-Zeichen-Java/)

## Lizenzen

- [![License: MIT](https://img.shields.io/badge/License-MIT%201.0-lightgrey.svg)](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/LICENSE) Diesem Repository und den kompilierten JAR Datei
- [![License: CC0-1.0](https://img.shields.io/badge/License-CC0%201.0-lightgrey.svg)](https://creativecommons.org/publicdomain/zero/1.0/) Die PNG Dateien in diesem Repository und in den kompilierten JAR.

## Bemerkungen:

- Ich bin unsicher ob die verwendung con UTF-8 Pfäde in Java stabil ist. Falls Problemen auftreten, einfach eine Issue erstellen!

## Building & Deploying

### The Website

The Maven Site is a fully fledged multi-module site, deployed to GitHub Pages. To be certain that the build fully works run the following commands in order (there are some nuances due to the tests module).

1. mvn clean
2. mvn verify
3. mvn site
4. mvn site:stage
5. mvn site-deploy

