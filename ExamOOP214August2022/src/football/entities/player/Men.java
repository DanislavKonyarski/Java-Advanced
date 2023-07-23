package football.entities.player;

public class Men extends BasePlayer{

    private static double KG = 85.00;

//   ToDo I can only play on NaturalGrass!

    public Men(String name, String nationality, int strength) {
        super(name, nationality, KG, strength);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength()+145);
    }
}
