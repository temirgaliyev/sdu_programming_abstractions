public class Drive extends GearBox {

    Drive(Car car){
        super(car);
    }

    @Override
    public void gas() {
        car.setMoving(true);
        System.out.println("Moving Forward");
    }

    @Override
    public void breakMoving() {
        car.setMoving(false);
        car.setGearBox(new Neutral(car));
        System.out.println("Car does not moving");
    }

}
