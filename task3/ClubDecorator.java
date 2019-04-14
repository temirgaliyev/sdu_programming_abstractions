public class ClubDecorator extends MonsterDecorator{
    private Monster monster;

    ClubDecorator(Monster monster){
        this.monster = monster;
    }

    @Override
    public Integer getAttackPower() {
        return this.monster.getAttackPower() + 12;
    }

    @Override
    public String attack() {
        return this.monster.attack() + "\nThe troll swings at you with a club!";
    }

    @Override
    public String fleeBattle() {
        return this.monster.fleeBattle() + "\nAnd loses his club while running!";
    }
}
