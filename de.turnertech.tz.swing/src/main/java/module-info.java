/**
 * A Resource Pack containing numerous tactical symbols from the German "Taktische Zeichen". This module contains
 * a wide array of 256px PNG symbols, and a few classes to help access them in an efficient and programmer friendly
 * manner.
 */
module de.turnertech.tz.swing {
    exports de.turnertech.tz.swing;

    requires transitive de.turnertech.tz.symbol;

    requires java.logging;
    requires transitive java.desktop;
}
