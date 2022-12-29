package de.turnertech.tz.swing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;

import de.turnertech.tz.api.TacticalSymbolTag;

/**
 * <p>A static factory class for creating and accessing the tactical symbols
 * provided in this module via a programmer friendly method.</p>
 * 
 * <p>Make sure to call {@link #initialise} early in your application startup
 * to get the most expensive part of starting up out of the way. This triggers
 * the reading of the index file and will create an ArrayList of TacticalSymbol
 * with instances for every symbol. If not explicitely called, it will be 
 * called on the first attempt to access the symbols. This may cause a slight
 * stutter in your application, as on my machine the initialisation takes over
 * 100ms</p>
 * 
 * @since 1.2
 */
public class TacticalSymbolFactory {
    
    private TacticalSymbolFactory() {/* Static Factory */}

    private static ArrayList<TacticalSymbol> tacticalSymbols;

    /**
     * We use java.util logging. This is the name of the logger we are using.
     * 
     * @since 1.2
     */
    public static final String LOGGER_NAME = "de.turnertech.tz";

    static final Logger logger;

    static {
        logger = Logger.getLogger(LOGGER_NAME);
    }

    /**
     * <p>Uses {@link de.turnertech.tz.symbol.TacticalSymbolFactory} to initialise an internal
     * list aof all available tactical symbols wrapped and prepared in {@link TacticalSymbol}
     * instances</p>
     * 
     * @return if the initialisation was successfull or not.
     * @since 1.2
     */
    public static boolean initialise() {

        if(tacticalSymbols != null) {
            logger.warning("Detected repeated calls to initialise. This should not happen, the factory cannot be initialised twice.");
            return true;
        }

        if(!de.turnertech.tz.symbol.TacticalSymbolFactory.initialise()) {
            logger.severe("Could not initialised the symbol.TacticalSymbolFactory!");
            return false;
        }

        Collection<de.turnertech.tz.symbol.TacticalSymbol> symbols = de.turnertech.tz.symbol.TacticalSymbolFactory.getTacticalSymbols();
        tacticalSymbols = new ArrayList<>(symbols.size());
        for(de.turnertech.tz.symbol.TacticalSymbol symbol : symbols) {
            tacticalSymbols.add(new TacticalSymbol(symbol));
        }

        return true;
    }

    /**
     * <p>Resets the cache back to a default state. After calling clear, a subsequent call to 
     * {@link #isInitialised()} will return false.</p>
     * 
     * @since 1.2
     */
    public static void reset() {
        tacticalSymbols = null;
        de.turnertech.tz.symbol.TacticalSymbolFactory.reset();
    }

    /**
     * Simple check to see if the internal storage has been initialised.
     * 
     * @return if the symbols instances have been prepared.
     * @since 1.2
     */
    public static boolean isInitialised() {
        return tacticalSymbols != null;
    }

    /**
     * <p>A search mechanism using "AND" logic to retrieve all {@link TacticalSymbol}s 
     * with all of the desired {@link TacticalSymbolTag}s</p>
     * 
     * @param tags The {@link TacticalSymbolTag}s to be used to search for the symbols
     * @return A collection of symbols matching all tags
     * @since 1.2
     */
    public static Collection<TacticalSymbol> getTacticalSymbols(TacticalSymbolTag ... tags) {
        if(!isInitialised()) {
            initialise();
        }
        LinkedList<TacticalSymbol> returnList = new LinkedList<>();
        for(TacticalSymbol tacticalSymbol : tacticalSymbols) {
            if(tacticalSymbol.getTags().containsAll(Arrays.asList(tags))) {
                returnList.add(tacticalSymbol);
            }
        }
        return returnList;
    }

    /**
     * Simply returns the internal storage wrapped in an unmodifiable list.
     * 
     * @return All of the loaded {@link TacticalSymbol}s
     * @since 1.2
     */
    public static Collection<TacticalSymbol> getTacticalSymbols() {
        if(!isInitialised()) {
            initialise();
        }
        return Collections.unmodifiableCollection(tacticalSymbols);
    }

}
