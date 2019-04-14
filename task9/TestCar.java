public class TestCar {
    public static void main(String[] args) {
        Car car = new Car();

        car.setGearBox(new Drive(car));
        car.gas();

        car.setGearBox(new Reverse(car));
        car.gas();

        car.setGearBox(new Neutral(car));
        car.gas();

        car.setGearBox(new Park(car));
        car.breakMoving();

    }
}
