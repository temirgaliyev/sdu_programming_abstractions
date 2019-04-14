public class Park extends GearBox {

    Park(Car car){
        super(car);
    }

    @Override
    public void gas() {
        car.setMoving(false);
        System.out.println("Cannot Gas, Parked");
    }

    @Override
    public void breakMoving() {
        car.setMoving(false);
        System.out.println("Parking...");
    }

}