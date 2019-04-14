public class WeaknessPotionDecorator extends  MonsterDecorator{
    private Monster monster;

    WeaknessPotionDecorator(Monster monster){
        this.monster = monster;
    }

    @Override
    public Integer getAttackPower() {
        return this.monster.getAttackPower() / 2;
    }

    @Override
    public String attack() {
        return this.monster.attack() + "\nOoops.... Something went wrong...";
    }

    @Override
    public String fleeBattle() {
        return this.monster.fleeBattle() + "\n...!";
    }

}
