package de.turnertech.tz.swing;

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.net.URL;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import javax.swing.ImageIcon;

import de.turnertech.tz.symbol.TacticalSymbolTag;

/**
 * A Swing version of the Tactical Symbol class. This class uses lazy
 * instantiation for its ImageIcon, only creating it the first time it is
 * requested. The class is backed by a cache system, so allways use this
 * class for creating scaled copies of your symbols!
 */
public class TacticalSymbol implements Transferable {
    
    /** A {@link DataFlavor} representing the TacticalSymbol class, allowing the entire class to be part of Drag and Drop actions. */
    public static final DataFlavor DATA_FLAVOR = new DataFlavor(TacticalSymbol.class, "Tactical Symbol");

    private static final DataFlavor[] possibleDataFlavors = new DataFlavor[]{DATA_FLAVOR, DataFlavor.stringFlavor, DataFlavor.imageFlavor};

    private final de.turnertech.tz.symbol.TacticalSymbolResource symbol;

    private ImageIcon imageIcon;

    /** The default java.awt.Image scaling to use for rescaling images */
    public static final int DEFAULT_SCALING_METHOD = Image.SCALE_SMOOTH;
    
    private ArrayList<AbstractMap.SimpleEntry<Integer, ImageIcon>> cache = new ArrayList<>(2);

    TacticalSymbol(final de.turnertech.tz.symbol.TacticalSymbolResource symbol) {
        Objects.requireNonNull(symbol, "Cannot create a swing.TacticalSymbol without a symbol.TacticalSymbol");
        this.symbol = symbol;
    }

    /**
     * Returns the collection of tags associated with this symbol
     * 
     * @return an unmodifiable collection.
     * @since 1.2
     */
    public Collection<TacticalSymbolTag> getTags() {
        return symbol.getTags();
    }

    /**
     * Simple getter for the ImageIcon. This method will instantiate the ImageIcon if it was not
     * already created.
     * 
     * @return The ImageIcon at the origional file resolution.
     */
    public ImageIcon getImageIcon() {
        if(imageIcon == null) {
            imageIcon = new ImageIcon(symbol.getResourceURL());
            imageIcon.setDescription(symbol.toString());
            int cacheKey = getCacheKey(imageIcon.getIconWidth(), imageIcon.getIconHeight(), DEFAULT_SCALING_METHOD);
            this.cache.add(new SimpleEntry<>(cacheKey, imageIcon));
        }
        return imageIcon;
    }

    /**
     * Gets an {@link ImageIcon} scaled to the desired height and width. This method is backed
     * with a cache so that subsequent calls with the same three parameters will return already 
     * instantiated copies.
     * 
     * @param width The desired width of the returned image.
     * @param height The desired height of the returned image.
     * @return A scaled instance. This instance will also hold a copy of the reference.
     * @see #getImageIcon(int, int, int)
     */
    public ImageIcon getImageIcon(final int width, final int height) {
        return this.getImageIcon(width, height, DEFAULT_SCALING_METHOD);
    }

    /**
     * Gets an {@link ImageIcon} scaled to the desired height and width. This method is backed
     * with a cache so that subsequent calls with the same three parameters will return already 
     * instantiated copies.
     * 
     * @param width The desired width of the returned image.
     * @param height The desired height of the returned image.
     * @param method The scaling method as per java.awt.Image constants.
     * @return A scaled instance. This instance will also hold a copy of the reference.
     * @see #getImageIcon(int, int)
     */
    public ImageIcon getImageIcon(final int width, final int height, final int method) {
        // Check the cache before creating new.
        final int cacheKey = getCacheKey(width, height, method);
        Optional<ImageIcon> cacheItem = getCacheItem(cacheKey);
        if(cacheItem.isPresent()) {
            return cacheItem.get();
        }

        ImageIcon origional = getImageIcon();
        ImageIcon scaled = new ImageIcon(origional.getImage().getScaledInstance(height, width, method));
        scaled.setDescription(symbol.toString());
        this.cache.add(new SimpleEntry<>(cacheKey, scaled));
        return scaled;
    }

    /**
     * Gets the symbols underlying class path resource URL. This should be avoided where possible, as we have
     * already loaded the image once. It can however be usefull for certain applications where direct access
     * to the resource is needed.
     *
     * @return The URL to the image resource (as provided by the class loader)
     */
    public URL getImageURL() {
        return symbol.getResourceURL();
    }

    /**
     * Fast method to approximate a unique key. This returns an integer with the
     * individual parameters shifted, allowinf space for all reasonable values.
     * 
     * e.g. (128, 128, 32) will return 1280128032 
     * 
     * @param w 
     * @param h
     * @param method
     * @return
     */
    private int getCacheKey(final int w, final int h, final int method) {
        return w * 1000000 + h * 100 + method;
    }

    private Optional<ImageIcon> getCacheItem(final int key) {
        for(SimpleEntry<Integer, ImageIcon> cacheItem : this.cache) {
            if(cacheItem.getKey().equals(key)) {
                return Optional.of(cacheItem.getValue());
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return symbol.toString();
    }

    @Override
    public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException {
        if(dataFlavor.equals(DATA_FLAVOR)) {
            return this;
        } else if(dataFlavor.equals(DataFlavor.stringFlavor)) {
            return this.toString();
        } else if(dataFlavor.equals(DataFlavor.imageFlavor)) {
            return this.getImageIcon().getImage();
        } else {
            throw new UnsupportedFlavorException(dataFlavor);
        }
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return possibleDataFlavors;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        for(DataFlavor possibleDataFlavor : possibleDataFlavors) {
            if(possibleDataFlavor.equals(dataFlavor)) {
                return true;
            }
        }
        return false;
    }

}
