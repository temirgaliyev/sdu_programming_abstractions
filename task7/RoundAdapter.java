public class RoundAdapter extends SquarePeg{
    private RoundPeg peg;

    RoundAdapter(RoundPeg peg){
        this.peg = peg;
    }

    @Override
    double getArea() {
        return peg.getArea();
    }

    @Override
    double getWidth() {
        return peg.getRadius()*2;
    }
}
