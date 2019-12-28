

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsCoverTest {
    /*@Test
    void testland() {
        Aera aera = new Aera(10, 10);
        Rover rover = new Rover(aera);
        try {
            rover.land(5, 5, "E");
        } catch (Exception e) {
            assertEquals("out of area", e.getMessage());
        }
        String position = rover.getPosition();
        assertEquals(position, "55E");
    }

    @Test
    void testmove() {
        Aera aera = new Aera(10, 10);
        Rover rover = new Rover(aera);
        try {
            rover.land(5, 5, "S");
            rover.move();
        } catch (Exception e) {
            assertEquals("out of area", e.getMessage());
        }
        String position = rover.getPosition();
        assertEquals(position, "54S");
    }*/

    @ParameterizedTest
    @CsvSource(
            {
                    "10;10;5;5;E, 55E",
                    "10;10;5;5;E;M, 65E",
                    "10;10;5;5;E;M;L;M;R, 66E",
                    "10;10;11;5;E;M;L;M;R, out of area",
                    "10;10;5, invalid input",
                    "10;10;5;5;E;M;M;M;M;M, 105E",
                    "10;10;5;5;E;M;M;M;M;M;M, out of area",
            }
    )
    void test3(String mission, String expected) {
        Rover rover = new Rover();
        RoverController roverController = new RoverController(rover);
        try {
            String position = roverController.excute(mission);
            assertEquals(position, expected);
        } catch (Exception e) {
            assertEquals(expected, e.getMessage());
            e.printStackTrace();
        }

    }
}
