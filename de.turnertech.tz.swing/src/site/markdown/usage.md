# Usage

Example module definition requiring this module.

```java
module my.module {
    requires de.turnertech.tz.swing;
}
```

Below a basic usage example to create a JList with all of the symbols provided by the library.

```java
import java.awt.Dimension;
import java.util.Collection;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import de.turnertech.tz.swing.TacticalSymbol;
import de.turnertech.tz.swing.TacticalSymbolFactory;

public class Application {
    public static void main(String[] args) {

        DefaultListModel<ImageIcon> listModel = new DefaultListModel<>();
        JList<ImageIcon> elementsPane = new JList<>(listModel);
        elementsPane.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        elementsPane.setVisibleRowCount(-1);

        Collection<TacticalSymbol> symbols = TacticalSymbolFactory.getTacticalSymbols();
        for(TacticalSymbol symbol : symbols) {
            // Here we are also resizing the image to suite us. The smaller copy is cached
            // in the background.
            listModel.addElement(symbol.getImageIcon(48, 48));
        }
        
        JScrollPane elementsScrollPane = new JScrollPane(elementsPane);

        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(200,200));
        frame.setContentPane(elementsScrollPane);
        frame.setVisible(true);
    }
}
```

![Example](images/example.png)

How to get the name of the JUL logger we are using.

```java
import de.turnertech.tz.swing.TacticalSymbolFactory;

public class Application {
    public static void main(String[] args) {
        System.out.println(TacticalSymbolFactory.LOGGER_NAME);
    }
}
```