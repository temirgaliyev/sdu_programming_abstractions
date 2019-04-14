public class RectangleAdapter extends SquarePeg{
    private RectanglePeg peg;

    RectangleAdapter(RectanglePeg peg){
        this.peg = peg;
    }

    @Override
    double getArea() {
        return peg.getArea();
    }

    @Override
    double getWidth() {
        return Math.max(peg.getWidth(), peg.getHeight());
    }
}
