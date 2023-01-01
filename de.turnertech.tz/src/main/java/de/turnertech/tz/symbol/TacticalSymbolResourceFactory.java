package de.turnertech.tz.symbol;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
public class TacticalSymbolResourceFactory {
    
    private TacticalSymbolResourceFactory() {/* Static Factory */}

    private static ArrayList<TacticalSymbolResource> tacticalSymbols;

    /**
     * We use java.util logging. This is the name of the logger we are using.
     * 
     * @since 1.1
     */
    public static final String LOGGER_NAME = "de.turnertech.tz";

    static final Logger logger;

    static {
        logger = Logger.getLogger(LOGGER_NAME);
    }

    /**
     * <p>Reads the index file and populates an internal storage of 
     * {@link TacticalSymbolResource} instances. Note, that thes instances do not have
     * the images in memory, only URLs to the assets so that you can easily
     * load them using your system of choice.</p>
     * 
     * @return if the initialisation was successfull or not.
     * @since 1.2
     */
    public static boolean initialise() {

        if(tacticalSymbols != null) {
            logger.warning("Detected repeated calls to initialise. This should not happen, the factory cannot be initialised twice.");
            return true;
        }

        try (InputStream input = TacticalSymbolResourceFactory.class.getResourceAsStream("index")) {
            tacticalSymbols = new ArrayList<>(1000);
            Scanner scanner = new Scanner(input, "UTF-8");
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                URL resource = TacticalSymbolResourceFactory.class.getResource(line[0]);
                ArrayList<TacticalSymbolTag> tagList = new ArrayList<>();
                for(int i = 1; i < line.length; ++i) {
                    tagList.add(TacticalSymbolTag.from(line[i]).orElseThrow());
                }
                tagList.trimToSize();
                tacticalSymbols.add(new TacticalSymbolResource(line[0].hashCode(), resource, tagList));
            }
            scanner.close();
            tacticalSymbols.trimToSize();
        } catch(Exception exception) {
            logger.log(Level.SEVERE, "Could not read the index file! This is an internal failure, please report it to the project");
            logger.log(Level.SEVERE, exception.toString());
            tacticalSymbols = null;
            return false;
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
     * <p>A search mechanism using "AND" logic to retrieve all {@link TacticalSymbolResource}s 
     * with all of the desired {@link TacticalSymbolTag}s</p>
     * 
     * @param tags The {@link TacticalSymbolTag}s to be used to search for the symbols
     * @return A collection of symbols matching all tags
     * @since 1.2
     */
    public static Collection<TacticalSymbolResource> getTacticalSymbols(TacticalSymbolTag ... tags) {
        if(!isInitialised()) {
            initialise();
        }
        LinkedList<TacticalSymbolResource> returnList = new LinkedList<>();
        for(TacticalSymbolResource tacticalSymbol : tacticalSymbols) {
            if(tacticalSymbol.getTags().containsAll(Arrays.asList(tags))) {
                returnList.add(tacticalSymbol);
            }
        }
        return returnList;
    }

    /**
     * Simply returns the internal storage wrapped in an unmodifiable list.
     * 
     * @return All of the loaded {@link TacticalSymbolResource}s
     * @since 1.2
     */
    public static Collection<TacticalSymbolResource> getTacticalSymbols() {
        if(!isInitialised()) {
            initialise();
        }
        return Collections.unmodifiableCollection(tacticalSymbols);
    }

}
