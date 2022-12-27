package de.turnertech.taktische_zeichen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A basic helper class containing some static helpers to list, locate and access the provided images.
 * 
 * @since 1.0
 */
public class Helper {
    
    private Helper() {
        // Private constructor as its a static helper class.
    }

    /**
     * Temporary function to test Javadoc
     * 
     * @return Hello
     * @since 1.0
     */
    public static String returnHello() {
        return "Hello";
    }

    public static List<String> getResources() {
        return getResourceFiles("");
    }

    private static List<String> getResourceFiles(String path) {
        List<String> filenames = new ArrayList<>();
    
        try (
                InputStream in = getResourceAsStream(path);
                BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String resource;
    
            while ((resource = br.readLine()) != null) {
                filenames.add(resource);
            }
        } catch (IOException e) {

        }
    
        return filenames;
    }
    
    private static InputStream getResourceAsStream(String resource) {
        final InputStream in
                = getContextClassLoader().getResourceAsStream(resource);
    
        return in == null ? Helper.class.getResourceAsStream(resource) : in;
    }
    
    private static ClassLoader getContextClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

}
