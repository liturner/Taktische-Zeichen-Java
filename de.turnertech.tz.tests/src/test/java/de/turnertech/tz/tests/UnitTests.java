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

import de.turnertech.tz.symbol.TacticalSymbolResource;
import de.turnertech.tz.symbol.TacticalSymbolResourceFactory;
import de.turnertech.tz.symbol.TacticalSymbolTag;

public class UnitTests {

    @AfterEach
    public void cleanup() {
        TacticalSymbolResourceFactory.reset();
    }

    @Test
    public void tacticalSymbolFactoryInitialise() {
        assertFalse(TacticalSymbolResourceFactory.isInitialised());
        assertTrue(TacticalSymbolResourceFactory.initialise());
        assertTrue(TacticalSymbolResourceFactory.isInitialised());
    }

    @Test
    public void tacticalSymbolFactoryDefaultInitialise() {
        assertFalse(TacticalSymbolResourceFactory.isInitialised());
        assertNotNull(TacticalSymbolResourceFactory.getTacticalSymbols());
        assertTrue(TacticalSymbolResourceFactory.getTacticalSymbols().size() > 100);
        assertTrue(TacticalSymbolResourceFactory.isInitialised());
    }

    @Test
    public void loggerNameUnchanged() {
        assertEquals("de.turnertech.tz", TacticalSymbolResourceFactory.LOGGER_NAME, "Do not change the logger name! Other people depend on it and it will fail annoyingly and silently in other peoples apps");
    }

    @Test
    public void noNullResources() {
        Collection<TacticalSymbolResource> symbols = TacticalSymbolResourceFactory.getTacticalSymbols();
        for(TacticalSymbolResource symbol : symbols) {
            assertNotNull(symbol.getResourceURL());
            assertNotNull(symbol.getTags());
        }
    }

    @Test
    public void immutableTest() {
        Collection<TacticalSymbolResource> symbols = TacticalSymbolResourceFactory.getTacticalSymbols();
        for(TacticalSymbolResource symbol : symbols) {
            Collection<TacticalSymbolTag> tags = symbol.getTags();
            assertThrows(UnsupportedOperationException.class,() -> tags.add(TacticalSymbolTag.CUSTOMS));
        }
    }

    @Test
    public void tacticalSymbolString() {
        Collection<TacticalSymbolResource> symbols = TacticalSymbolResourceFactory.getTacticalSymbols();
        for(TacticalSymbolResource symbol : symbols) {
            assertNotNull(symbol.toString());
            assertNotEquals("", symbol.toString());
        }
    }

}
