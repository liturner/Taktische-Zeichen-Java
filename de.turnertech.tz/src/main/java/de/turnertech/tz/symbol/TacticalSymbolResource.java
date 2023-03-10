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
    
    private final int hashCode;

    private final URL resource;

    private final Collection<TacticalSymbolTag> tags;

    TacticalSymbolResource(final int hashCode, final URL resource, final Collection<TacticalSymbolTag> tags) {
        Objects.requireNonNull(resource, "TacticalSymbol cannot be created with a null resource!");
        this.hashCode = hashCode;
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

    /** As the hashCode is the hash of the image file, and the tags are immutable, equals only needs to check the hash code. */
    @Override
    public boolean equals(Object other) {
        return Integer.valueOf(hashCode).equals(Objects.hashCode(other));
    }

    /**
     * We are hard coding the hashcode in the constructor. It is ecpected to be the hash of the origional file path
     */
    @Override
    public int hashCode() {
        return hashCode;
    }

}
