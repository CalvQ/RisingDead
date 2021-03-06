package game.sprites;

public class Location {

    private double x;
    private double y;

    public Location(double dx, double dy) {
        x = dx;
        y = dy;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double dx) {
        this.x = dx;
    }

    public void setY(double dy) {
        this.y = dy;
    }

    public double diffX(Location loc) {
        return this.x - loc.getX();
    }

    public double diffY(Location loc) {
        return this.y - loc.getY();
    }

    @Override
    public String toString() {
        return x + " , " + y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Location) {
            return ((Location) obj).getX() == this.x && ((Location) obj).getY() == this.y;
        }
        return false;
    }

}
