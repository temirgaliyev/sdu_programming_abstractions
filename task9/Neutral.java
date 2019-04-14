public class Neutral extends GearBox {

    Neutral(Car car){
        super(car);
    }

    @Override
    public void gas() {
        if (car.getMoving()){
            breakMoving();
        } else{
            car.setMoving(false);
            System.out.println("Gas Neutral");
        }
    }

    @Override
    public void breakMoving() {
        car.setMoving(false);
        System.out.println("Break Moving Neutral");
    }

}
