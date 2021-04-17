public class Firearm {
    private int Magazine;
    private double Range;
    private int Ammo;
    private double BulletDamage;

    public Firearm(int magazine, double range, int ammo, double bulletDamage) {
        Magazine = magazine;
        Range = range;
        Ammo = ammo;
        BulletDamage = bulletDamage;
    }

    public int getMagazine() {
        return Magazine;
    }

    public void setMagazine(int magazine) {
        Magazine = magazine;
    }

    public double getRange() {
        return Range;
    }

    public void setRange(double range) {
        Range = range;
    }

    public int getAmmo() {
        return Ammo;
    }

    public void setAmmo(int ammo) {
        Ammo = ammo;
    }

    public double getBulletDamage() {
        return BulletDamage;
    }

    public void setBulletDamage(double bulletDamage) {
        BulletDamage = bulletDamage;
    }

    public float ShootOnce() {

    }

    public float ShootSeries
}
