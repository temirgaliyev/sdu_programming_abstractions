public abstract class GearBox {
    Car car;

    GearBox(Car car){
        this.car = car;
    }

    abstract void gas();
    abstract void breakMoving();
}