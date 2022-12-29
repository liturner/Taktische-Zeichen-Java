package de.turnertech.tz.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import de.turnertech.tz.api.TacticalSymbolTag;
import de.turnertech.tz.symbol.TacticalSymbol;
import de.turnertech.tz.symbol.TacticalSymbolFactory;

public class UnitTests {

    @AfterEach
    public void cleanup() {
        TacticalSymbolFactory.reset();
    }

    @Test
    public void tacticalSymbolFactoryInitialise() {
        assertFalse(TacticalSymbolFactory.isInitialised());
        assertTrue(TacticalSymbolFactory.initialise());
        assertTrue(TacticalSymbolFactory.isInitialised());
    }

    @Test
    public void tacticalSymbolFactoryDefaultInitialise() {
        assertFalse(TacticalSymbolFactory.isInitialised());
        assertNotNull(TacticalSymbolFactory.getTacticalSymbols());
        assertTrue(TacticalSymbolFactory.getTacticalSymbols().size() > 100);
        assertTrue(TacticalSymbolFactory.isInitialised());
    }

    @Test
    public void loggerNameUnchanged() {
        assertEquals("de.turnertech.tz", TacticalSymbolFactory.LOGGER_NAME, "Do not change the logger name! Other people depend on it and it will fail annoyingly and silently in other peoples apps");
    }

    @Test
    public void noNullResources() {
        Collection<TacticalSymbol> symbols = TacticalSymbolFactory.getTacticalSymbols();
        for(TacticalSymbol symbol : symbols) {
            assertNotNull(symbol.getResourceURL());
            assertNotNull(symbol.getTags());
        }
    }

    @Test
    public void immutableTest() {
        Collection<TacticalSymbol> symbols = TacticalSymbolFactory.getTacticalSymbols();
        for(TacticalSymbol symbol : symbols) {
            Collection<TacticalSymbolTag> tags = symbol.getTags();
            assertThrows(UnsupportedOperationException.class,() -> tags.add(TacticalSymbolTag.CUSTOMS));
        }
    }

    @Test
    public void tacticalSymbolString() {
        Collection<TacticalSymbol> symbols = TacticalSymbolFactory.getTacticalSymbols();
        for(TacticalSymbol symbol : symbols) {
            assertNotNull(symbol.toString());
            assertNotEquals("", symbol.toString());
        }
    }

}
