public class Main {

    public static void main(String[] args) {

        Monster troll = new Troll();
        Monster witch = new Witch();
        Monster goblin = new Goblin();

        Monster[] monsters = new Monster[]{troll, new ClubDecorator(troll), witch, new WeaknessPotionDecorator(witch), goblin, new MagicPillDecorator(goblin)};

        troll = new ClubDecorator(troll);
        troll = new StrengthPotionDecorator(troll);
//        for (Monster monster : monsters) {
        System.out.println(troll.getAttackPower());
        System.out.println(troll.attack());
        System.out.println(troll.fleeBattle());
        System.out.println();
//        }
    }
}
