public class RectanglePeg {
    private double width, height;

    RectanglePeg(double w, double h){
        this.width = w;
        this.height = h;
    }

    double getWidth() {
        return width;
    }

    double getHeight() {
        return height;
    }

    double getArea(){
        return width*height;
    }

}
