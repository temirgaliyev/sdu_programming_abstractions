public class Reverse extends GearBox {

    Reverse(Car car){
        super(car);
    }

    @Override
    public void gas() {
        car.setMoving(true);
        System.out.println("Moving Backward");
    }

    @Override
    public void breakMoving() {
        car.setMoving(false);
        System.out.println("Stopped moving");
    }

}
