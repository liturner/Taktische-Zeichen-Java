package de.turnertech.taktische_zeichen.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.turnertech.taktische_zeichen.Helper;

public class UnitTests {

    @Test
    @DisplayName("Sanity check the Helper class")
	public void imagesExist() {
        assertNotNull(Helper.getResources());
        assertTrue(Helper.getResources().size() > 0);
    }

}
