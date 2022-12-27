# Taktische-Zeichen-Java

Taktische Zeichen für Hilfsorganisationen als 256 png in eine Java Bibliotech.

![Zugführer - THW](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/src/main/resources/de/turnertech/taktische_zeichen/personen/thw/Zugführer_TZ.png)
![Löschzug](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/src/main/resources/de/turnertech/taktische_zeichen/einheiten/feuerwehr/Löschzug.png)
![Leitstelle](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/src/main/resources/de/turnertech/taktische_zeichen/einrichtungen/Leitstelle.png)
![Gerettete Person](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/src/main/resources/de/turnertech/taktische_zeichen/personen/Gerettete_Person.png)
![Gefahr durch Explosivstoffe](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/src/main/resources/de/turnertech/taktische_zeichen/gefahren/Gefahr_durch_Explosivstoffe.png)
![Zugtrupp - THW](https://raw.githubusercontent.com/liturner/Taktische-Zeichen-Java/main/src/main/resources/de/turnertech/taktische_zeichen/einheiten/thw/Zugtrupp.png)

## Zuschreibung

Vielen dank zu den Projekt [jonas-koeritz/Taktische-Zeichen](https://github.com/jonas-koeritz/Taktische-Zeichen) für die bereistellung die Bilder unter [![License: CC0-1.0](https://img.shields.io/badge/License-CC0%201.0-lightgrey.svg)](http://creativecommons.org/publicdomain/zero/1.0/)!

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

Diese Projekt hat zwei Hauptfunktionalitäten:

1. Eine Skript um die Dateien von [jonas-koeritz/Taktische-Zeichen](https://github.com/jonas-koeritz/Taktische-Zeichen) in eine Java freundlich Strukture umzuwandeln zu können.
2. Eine Java 11 Maven Projekt, der eine Sammlung von 256px PNG Dateien in eine Java Module liefert durch Maven Central.

Bemerkungen:

- Ich bin unsicher ob die verwendung con UTF-8 Pfäde in Java stabil ist. Falls Problemen auftreten, einfach eine Issue erstellen!
