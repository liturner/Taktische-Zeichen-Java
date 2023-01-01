package de.turnertech.tz.symbol;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

/**
 * <p>A representation of the Tactical Symbol. It is intended to be a lightweight
 * class which can be cheaply, and diversly used to programatically access the
 * image library.</p>
 * 
 * <p>It is recomended to grab one of the other modules (like taktische-zeichen-swing)
 * instead. This class is inteded as a basic backbone for the raw ersource</p>
 */
public class TacticalSymbolResource {
    
    private final int id;

    private final URL resource;

    private final Collection<TacticalSymbolTag> tags;

    TacticalSymbolResource(final int id, final URL resource, final Collection<TacticalSymbolTag> tags) {
        Objects.requireNonNull(resource, "TacticalSymbol cannot be created with a null resource!");
        this.id = id;
        this.tags = tags == null ? Collections.emptyList() : Collections.unmodifiableCollection(tags);
        this.resource = resource;                
    }

    /**
     * <p>Returns the resource {@link URL} which points to the image this instance
     * represents. The is trustworthy and has already been verified as existing.</p>
     * 
     * <p>This can be used (for example) directly in swing ImageIcon</p>
     *
     * @return The URL pointing to the resource.
     */
    public URL getResourceURL() {
        return resource;
    }

    /**
     * The Id of a resource is an arbitrary number representing the symbol. The Id of a symbol
     * is guarenteed to be the same across runs, as long as the version of the library is not changed
     * 
     * @return A unique ID for this resource.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the collection of tags associated with this symbol
     * 
     * @return an unmodifiable collection.
     */
    public Collection<TacticalSymbolTag> getTags() {
        return tags;
    }

    /**
     * Simple check to see if a tag is present.
     * 
     * @param tag Tag to check is present.
     * @return If the tag was present.
     */
    public boolean hasTag(final TacticalSymbolTag tag) {
        return tags.contains(tag);
    }

    @Override
    public String toString() {
        String filename = resource.toString();
        try {
            filename = URLDecoder.decode(filename, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            TacticalSymbolResourceFactory.logger.severe("Could not decode the filepath to a UTF-8 String! Tell this to a Dev");
        }
        return filename.substring(filename.lastIndexOf('/') + 1 , filename.length() - 4);
    }

}
