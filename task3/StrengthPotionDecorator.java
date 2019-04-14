public class StrengthPotionDecorator extends  MonsterDecorator{
    private Monster monster;

    StrengthPotionDecorator(Monster monster){
        this.monster = monster;
    }

    @Override
    public Integer getAttackPower() {
        return this.monster.getAttackPower() * 2;
    }

    @Override
    public String attack() {
        return this.monster.attack() + "\nStrength potion made him twice as strong";
    }

    @Override
    public String fleeBattle() {
        return this.monster.fleeBattle() + "\nAnd loses... his purse!";
    }

}
