public abstract class Monster {
    private Integer power = 0;
    private String attack = "";
    private String flee = "";

    Monster(Integer power, String attack, String flee){
        this.power = power;
        this.attack = attack;
        this.flee = flee;
    }

    Monster(){}

    public void setAttackPower(Integer power){
        this.power = power;
    }

    public Integer getAttackPower() {
        return power;
    }

    public void setAttack(String battelcry){
        this.attack = battelcry;
    }

    public String attack(){
        return attack;
    }

    public String fleeBattle(){
        return flee;
    }

    public void setFlee(String flee){
        this.flee = flee;
    }
}
