package football.entities.player;

public class Women extends BasePlayer{

    private static double KG = 60.00;

//   ToDo I can only play on ArtificialTurf!

    public Women(String name, String nationality, int strength) {
        super(name, nationality, KG, strength);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength()+115);
    }
}
