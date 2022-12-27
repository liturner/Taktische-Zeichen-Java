# Taktische-Zeichen-Java

A Java library containing the Taktische Zeichen für Hilfsorganisationen.

## Credits

Firstly, thankyou very much to the [jonas-koeritz/Taktische-Zeichen](https://github.com/jonas-koeritz/Taktische-Zeichen) project for providing the images! This library is only possible thanks to the amazing work taking place over on the other project. Here I am only taking images and adding them to a .jar, the hard work is done elsewhere!

This project has been named in keeping with the other related projects. Please check them out at:

- [Taktische-Zeichen](https://github.com/jonas-koeritz/Taktische-Zeichen)
- [Taktische-Zeichen-drawio](https://github.com/MartinBoehmer/Taktische-Zeichen-drawio)

## Dependency Info

```xml
<dependency>
  <groupId>de.turnertech</groupId>
  <artifactId>taktische-zeichen</artifactId>
  <version>1.0</version>
</dependency>
```

## Description

This project has two primary parts:

1. A converter script to rename and move the files generated from the [jonas-koeritz/Taktische-Zeichen](https://github.com/jonas-koeritz/Taktische-Zeichen) project into a Java friendly package structure.
2. A Maven project for compiling and packaging a Java module project containing the images, which can then be published to maven central.

A few considerations:

- Due to a desire to keep the size down, I am opting to use only the 256 PNG images. For Java Programming, this should be more than enough.
- I am not certain of the effect of UTF-8 paths in Java packages? It seems to work for me, but if it causes you issues please report them and I can easily replace certain charachters.
