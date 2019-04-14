public class SquareHole {
    private double width;

    SquareHole(double width){
        this.width = width;
    }

    double getWidth(){
        return width;
    }

    double getArea(){
        return width*width;
    }

    boolean fits(SquarePeg peg){
        if (peg.getWidth() <= this.getWidth())
            return this.getArea() >= peg.getArea();
        return false;
    }

    double freeSpace(SquarePeg peg){
        double diff = this.getArea()-peg.getArea();
        if (peg.getWidth() <= this.getWidth() && diff >= 0)
            return diff;
        return -1;
    }

}
