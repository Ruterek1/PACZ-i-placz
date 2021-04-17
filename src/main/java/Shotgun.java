public class Shotgun extends Firearm {

    private final int Barrels;

    public Shotgun(int magazine, double range, int ammo, double bulletDamage, int barrels) {
        super(magazine, range, ammo, bulletDamage);
        Barrels = barrels;
    }

    public int getBarrels() {
        return Barrels;
    }

}
