public class RoverController {
    private final Rover rover;

    public RoverController(Rover rover) {
        this.rover = rover;
    }

    public String excute(String mission) throws Exception {
        String[] missions = mission.split(";");
        int size = missions.length;
        if (size < 5) {
            throw new Exception("invalid input");
        }

        Aera aera = new Aera(Integer.valueOf(missions[0]), Integer.valueOf(missions[1]));
        Rover rover = new Rover(aera);
        rover.land(Integer.valueOf(missions[2]), Integer.valueOf(missions[3]), missions[4]);

        if (size > 5) {
            for (int i = 5; i < size; i++) {
                if ("M".equals(missions[i])) {
                    rover.move();
                }
                else {
                    rover.turn(missions[i]);
                }
            }
        }
        return rover.getPosition();
    }
}
