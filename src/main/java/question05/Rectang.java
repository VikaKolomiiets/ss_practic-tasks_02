package question05;

public class Rectang {
    private double x;
    private double y;
    public Rectang(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        checkSideInput(x);
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        checkSideInput(y);
        this.y = y;
    }

    public double getPerimeter(){
        return (this.getX() + this.getY()) * 2;
    }
    private static void checkSideInput(double side){
        if(side <= 0){
            throw new IllegalArgumentException("Side should be more than zero");
        }
    }
}
