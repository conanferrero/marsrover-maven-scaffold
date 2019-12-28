public class Rover {

    private int xMax;
    private int yMax;
    private int x;
    private int y;
    private String forward;
    private String dirList = "ESWN";

    public Rover(Aera aera) {
        this.xMax = aera.getX();
        this.yMax = aera.getY();
    }

    public Rover() {

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

    public void move() throws Exception {
        switch (this.forward) {
            case "E": {
                moveE();
                break;
            }
            case "W": {
                moveW();
                break;
            }
            case "N": {
                moveN();
                break;
            }
            case "S": {
                moveS();
                break;
            }
            default:break;
        }
    }

    private void moveE() throws Exception {
        if (this.x + 1 > this.xMax) {
            throw new Exception("out of area");
        }
        this.x++;
    }

    private void moveW() throws Exception {
        if (this.x - 1 < 0) {
            throw new Exception("out of area");
        }
        this.x--;
    }

    private void moveN() throws Exception {
        if (this.y + 1 > this.yMax) {
            throw new Exception("out of area");
        }
        this.y++;
    }

    private void moveS() throws Exception {
        if (this.y - 1 < 0) {
            throw new Exception("out of area");
        }
        this.y--;
    }

    public void turn(String dir) {
        int index = dirList.indexOf(this.forward);
        if ("R".equals(dir)) {
            if (3 == index) {
                index = 0;
            }
            else index++;
        }
        else if ("L".equals(dir)) {
            if (0 == index) {
                index = 3;
            }
            else {
                index--;
            }
        }
        this.forward = dirList.substring(index, index + 1);
    }
}
