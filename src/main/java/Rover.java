public class Rover {

    private int xMax;
    private int yMax;
    private int x;
    private int y;
    private String forward;

    public Rover(Aera aera) {
        this.xMax = aera.getX();
        this.yMax = aera.getY();
    }

    public void land(int i, int j, String e) {
        this.x = i;
        this.y = j;
        this.forward = e;
    }

    public String getPosition() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.x);
        sb.append(this.y);
        sb.append(this.forward);
        return sb.toString();
    }

    public void move() {
    }
}
