public class Main {

    public static void main(String[] args) {
        SquareHole hole = new SquareHole(15);

        SquarePeg squarePeg = new SquarePeg(15);
        RoundPeg roundPeg = new RoundPeg(7.6);
        RectanglePeg rectanglePeg = new RectanglePeg(15, 15);

        System.out.println(hole.fits(squarePeg));
        System.out.println(hole.fits(new RoundAdapter(roundPeg)));
        System.out.println(hole.fits(new RectangleAdapter(rectanglePeg)));

        System.out.println(hole.freeSpace(squarePeg));
        System.out.println(hole.freeSpace(new RoundAdapter(roundPeg)));
        System.out.println(hole.freeSpace(new RectangleAdapter(rectanglePeg)));

    }

}
