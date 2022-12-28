package de.turnertech.tz;

import java.util.logging.Logger;

/**
 * A basic helper class internal to the module.
 * 
 * @since 1.0
 */
class Helper {
    
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

    private Helper() {
        // Private constructor as its a static helper class.
    }

}
