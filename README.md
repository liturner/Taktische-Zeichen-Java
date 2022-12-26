# Taktische-Zeichen-Java

A Java library containing the Taktische Zeichen images.

## Credits

Firstly, thankyou very much to ... for providing the images with such an open licence! This library is only possible thanks to the amazing work taking place over on the other project. Here I am only taking images and adding them to a .jar, the hard work is done elsewhere!

This project has been named in keeping with the other related projects:

- Taktische-Zeichen
- Taktische-Zeichen-drawio

## Description

This project has two primary parts:

1. A name converter script to rename and move the files generated from the ... roject into a Java Friendly package structure
2. A Maven project for compiling and packaging a Java module project containing the images, which is then published to maven central

A few considerations:

- Due to a desire to keep the size down, I am opting to use only the 256 PNG images. For Java Programming, this should be more than enough.
- Java coding has limitations, and does not support charachters like ä, ü, and ß in package names. Coupled with most code being written in English, I will convert the folder names to english paths, but will keep the german names for the symbols (replacing the unsupported charachters). This should provide a "java friendly" module, while still retaining its useability.
