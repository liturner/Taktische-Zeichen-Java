# Usage

Example module definition requiring this module.

```java
module my.module {
    requires de.turnertech.tz.symbol;
}
```

Below a basic usage example to loop and print through all of the symbols provided by the library.

```java
import java.util.Collection;
import de.turnertech.tz.symbol.TacticalSymbolResource;
import de.turnertech.tz.symbol.TacticalSymbolResourceFactory;

public class Application {
    public static void main(String[] args) {

        // Technically optional, but recomended in production as it is 
        // a fairly expensive one off function.
        TacticalSymbolResourceFactory.initialise();
        
        // Loop and print out all of the symbol paths on the class path. You could
        // use thes URLs in e.g. a Swing Image.
        Collection<TacticalSymbolResource> symbols = TacticalSymbolResourceFactory.getTacticalSymbols();
        for(TacticalSymbolResource symbol : symbols) {
            System.out.println(symbol.getResourceURL());
        }
    }
}
```

How to get the name of the JUL logger we are using.

```java
import de.turnertech.tz.symbol.TacticalSymbolResourceFactory;

public class Application {
    public static void main(String[] args) {
        System.out.println(TacticalSymbolResourceFactory.LOGGER_NAME);
    }
}
```