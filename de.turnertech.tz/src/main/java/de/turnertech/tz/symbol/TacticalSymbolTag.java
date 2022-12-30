package de.turnertech.tz.symbol;

import java.util.Objects;
import java.util.Optional;

/**
 * A tag which may be related to a tactical symbol. These are usefull for 
 * searching, grouping and sorting.
 */
public enum TacticalSymbolTag {
    /** Federal Agency for Technical Relief, or Technisches Hilfswerk. */
    THW("thw"),

    /** Feuerwehr, Fire Brigade */
    FIRE_BRIGADE("fw"),

    /** Bundeswehr, Military */
    MILITARY("bw"),

    /** Polizei */
    POLICE("polizei"),

    /** Zoll, Customs */
    CUSTOMS("zoll"),

    /** Einheit, Unit */
    UNIT("einheiten"),

    /** Gebäude, Building */
    BUILDING("gebäude"),

    /** Einrichtungen */
    FACILITIES("einrichtungen"),

    /** Maßnahmen */
    MEASURES("maßnahmen"),

    /** Schäden */
    DAMAGE("schäden"),

    /** Schadenskonten */
    DAMAGE_ACCOUNTS("schadenskonten"),
    
    /** Person */
    PERSON("personen"),

    /** Sonstiges */
    OTHER("sonstiges"),

    /** gefahren */
    HAZARDS("gefahren"),

    /** Fahrzeuge */
    VEHICLE("fahrzeuge"),

    /** Wasserrettung */
    WATER_RESCUE("wasserrettung"),

    /** Katastrophenschutz */
    CIVIL_PROTECTION("katastrophenschutz"),
    
    /** Rettungswesen */
    RESCUE_SERVICES("rettungswesen"),

    /** Führungsstellen */
    LEADERSHIP("führungsstellen"),
 
    /** Fernmeldewesen */
    TELECOMMUNICATIONS("fernmeldewesen");
    

    private final String label;

    private TacticalSymbolTag(final String label) {
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
    public static Optional<TacticalSymbolTag> from(final String label) {
        for(TacticalSymbolTag tag : TacticalSymbolTag.values()) {
            if(tag.label.equals(label)) {
                return Optional.of(tag);
            }
        }
        return Optional.empty();
    }
}
