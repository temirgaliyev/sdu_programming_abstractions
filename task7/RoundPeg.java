
public class RoundPeg {
    private double radius;

    RoundPeg(double r){
        this.radius = r;
    }

    double getRadius() {
        return radius;
    }

    double getArea(){
        return Math.PI*radius*radius;
    }

}
