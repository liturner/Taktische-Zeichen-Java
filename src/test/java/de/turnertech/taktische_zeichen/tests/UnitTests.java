package de.turnertech.taktische_zeichen.tests;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import de.turnertech.taktische_zeichen.Helper;

public class UnitTests {

    @Test
    @DisplayName("Check logger exists ")
	public void imagesExist() {
        assertNotNull(Helper.getResources());
    }

}
