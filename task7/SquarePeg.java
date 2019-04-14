public class SquarePeg {
    private double width;

    SquarePeg(){}

    SquarePeg(double width){
        this.width = width;
    }

    double getWidth(){
        return width;
    }

    double getArea(){
        return width*width;
    }

}
