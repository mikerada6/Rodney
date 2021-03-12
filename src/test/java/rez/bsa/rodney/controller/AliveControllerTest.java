package rez.bsa.rodney.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AliveControllerTest {

    AliveController controller;


    @BeforeEach
    public
    void setUp() throws Exception {
        controller = new AliveController();
    }

    @Test
    void setupMap() {

        boolean isAlive = controller.isAlive();
        assertTrue(isAlive);
    }
}
