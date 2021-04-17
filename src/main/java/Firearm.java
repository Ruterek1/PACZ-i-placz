public class Firearm implements Weapon {

    private final int Magazine;
    private final double Range;
    private int Ammo;
    private final double BulletDamage;

    public Firearm(int magazine, double range, int ammo, double bulletDamage) {
        Magazine = magazine;
        Range = range;
        Ammo = ammo;
        BulletDamage = bulletDamage;
    }

    @Override
    public double DealDamage() {
        return 0;
    }

    public int getMagazine() {
        return Magazine;
    }

    public double getRange() {
        return Range;
    }

    public int getAmmo() {
        return Ammo;
    }

    public void addAmmo(int ammo) {
        Ammo = ammo;
    }

    public double getBulletDamage() {
        return BulletDamage;
    }

}
