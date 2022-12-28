package de.turnertech.tz.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.turnertech.tz.TacticalSymbolFactory;

public class UnitTests {

    @Test
    public void tacticalSymbolFactoryInitialise() {
        assertFalse(TacticalSymbolFactory.isInitialised());
        assertTrue(TacticalSymbolFactory.initialise());
        assertTrue(TacticalSymbolFactory.isInitialised());
    }

}
