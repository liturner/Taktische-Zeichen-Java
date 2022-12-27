package de.turnertech.taktische_zeichen;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A basic helper class containing some static helpers to list, locate and access the provided images.
 * 
 * @since 1.0
 */
public class Helper {
    
    /**
     * We use java.util logging. This is the name of the logger we are using.
     * 
     * @since 1.1
     */
    public static final String LOGGER_NAME = "de.turnertech.taktische_zeichen";

    private static final Logger logger;

    static {
        logger = Logger.getLogger(LOGGER_NAME);
    }

    private Helper() {
        // Private constructor as its a static helper class.
    }

    /**
     * This function is slow! Do not use it in productive code!
     * 
     * Retrieves a {@link Collections#unmodifiableCollection(Collection)} containing the resource
     * paths for all of the included assets.
     * 
     * This function will silently fail and return an empty or incomplete list if anything goes wrong.
     * 
     * @return Read Only Collection of resource names pointing to the supplied images.
     * 
     * @since 1.1
     */
    public static Collection<String> getResources() {
        LinkedList<String> filenames = new LinkedList<>();

        try(InputStream indexStream = Helper.class.getResource("index").openStream()) {
            Scanner scanner = new Scanner(indexStream);
            while (scanner.hasNextLine()) {
                filenames.add(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Could not retrive file names from Jar file.", e);
        }

        return Collections.unmodifiableCollection(filenames);
    }
}
