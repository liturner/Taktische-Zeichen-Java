package de.turnertech.tz;

import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

/**
 * A representation of the Tactical Symbol. It is intended to be a lightweight
 * class which can be cheaply, and diversly used to programatically access the
 * image library.
 * 
 * @since 1.2
 */
public class TacticalSymbol {
    
    /**
     * A tag which may be related to a tactical symbol. These are usefull for 
     * searching, grouping and sorting.
     */
    public enum Tag {

        /** Federal Agency for Technical Relief, or Technisches Hilfswerk. */
        THW("thw"),

        /** Feuerwehr, Fire Brigade */
        FW("fw"),

        /** Bundeswehr, Military */
        BW("bw"),

        /** Zoll, Customs */
        CUSTOMS("zoll"),

        /** Einheit, Unit */
        UNIT("einheiten"),

        /** Gebäude, Building */
        BUILDING("gebäude"),

        /** Person */
        PERSON("personen");

        private final String label;

        private Tag(final String label) {
            Objects.requireNonNull(label);
            this.label = label;
        }

        /**
         * Gets the tag instance related to a string. This is used to instantiate
         * the tags from the text index stored in the classpath. It is also the method
         * used to convert the german tags, into english code.
         * 
         * @param label The label assigned in the text index.
         * @return The tag, or empty if not found.
         * @since 1.2
         */
        public static Optional<Tag> from(final String label) {
            for(Tag tag : Tag.values()) {
                if(tag.label.equals(label)) {
                    return Optional.of(tag);
                }
            }
            return Optional.empty();
        }
    };

    private final URL resource;

    private final Collection<Tag> tags;

    TacticalSymbol(final URL resource, final Collection<Tag> tags) {
        Objects.requireNonNull(resource);
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
    public Collection<Tag> getTags() {
        return tags;
    }

    /**
     * Simple check to see if a tag is present.
     * 
     * @param tag Tag to check is present.
     * @return If the tag was present.
     * @since 1.2
     */
    public boolean hasTag(final Tag tag) {
        return tags.contains(tag);
    }

}
