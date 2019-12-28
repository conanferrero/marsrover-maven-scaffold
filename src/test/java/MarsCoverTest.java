

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsCoverTest {
    @Test
    void testland() {
        Aera aera = new Aera(10,10);
        Rover rover = new Rover(aera);
        try {
            rover.land(5,5,"E");
        } catch (Exception e) {
            assertEquals("out of area",e.getMessage());
        }
        String position = rover.getPosition();
        assertEquals(position, "55E");
    }

    @Test
    void testmove() {
        Aera aera = new Aera(10,10);
        Rover rover = new Rover(aera);
        try {
            rover.land(5,5,"S");
            rover.move();
        } catch (Exception e) {
            assertEquals("out of area",e.getMessage());
        }
        String position = rover.getPosition();
        assertEquals(position, "54S");
    }
}
