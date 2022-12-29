package de.turnertech.tz.symbol;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import de.turnertech.tz.api.TacticalSymbolTag;

/**
 * A representation of the Tactical Symbol. It is intended to be a lightweight
 * class which can be cheaply, and diversly used to programatically access the
 * image library.
 * 
 * @since 1.2
 */
public class TacticalSymbol {
    
    private final URL resource;

    private final Collection<TacticalSymbolTag> tags;

    TacticalSymbol(final URL resource, final Collection<TacticalSymbolTag> tags) {
        Objects.requireNonNull(resource, "TacticalSymbol cannot be created with a null resource!");
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
     * @since 1.2
     */
    public URL getResourceURL() {
        return resource;
    }

    /**
     * Returns the collection of tags associated with this symbol
     * 
     * @return an unmodifiable collection.
     * @since 1.2
     */
    public Collection<TacticalSymbolTag> getTags() {
        return tags;
    }

    /**
     * Simple check to see if a tag is present.
     * 
     * @param tag Tag to check is present.
     * @return If the tag was present.
     * @since 1.2
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
            TacticalSymbolFactory.logger.severe("Could not decode the filepath to a UTF-8 String! Tell this to a Dev");
        }
        return filename.substring(filename.lastIndexOf('/') + 1 , filename.length() - 4);
    }

}
