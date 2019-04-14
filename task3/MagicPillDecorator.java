import java.util.Random;

public class MagicPillDecorator extends  MonsterDecorator{
    private Monster monster;
    private String[] effects = new String[]{" read books faster!", "to be colorful!", " fall sleep..."};

    MagicPillDecorator(Monster monster){
        this.monster = monster;
    }

    @Override
    public Integer getAttackPower() {
        return this.monster.getAttackPower();
    }

    @Override
    public String attack() {
        String randomEffect = effects[new Random().nextInt(effects.length)];
        return this.monster.attack() + "\n MagicPill helps him to" + randomEffect;
    }

    @Override
    public String fleeBattle() {
        return this.monster.fleeBattle() + "\nAnd finally shouted -In vain i spent all my money!";
    }

}
