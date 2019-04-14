public class Car {

    private GearBox gearBox;
    private boolean moving = false;

    Car() {
        gearBox = new Neutral(this);
    }

    public boolean getMoving() {
        return moving;
    }

    public void setMoving(boolean moving){
        this.moving = moving;
    }

    public void setGearBox(GearBox gearBox){
        this.gearBox = gearBox;
    }

    public void gas(){
        gearBox.gas();
    }

    public void breakMoving() {
        gearBox.breakMoving();
    }

}
