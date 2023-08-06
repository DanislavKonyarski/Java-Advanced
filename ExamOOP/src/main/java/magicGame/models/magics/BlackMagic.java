package magicGame.models.magics;

public class BlackMagic extends MagicImpl {
    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (getBulletsCount() > 0) {
            setBulletsCount(getBulletsCount() - 10);
            if (getBulletsCount() < 0) {
                setBulletsCount(0);
                return 0;
            }
            return 10;
        } else {
            return 0;
        }
    }
}
