public class ColdWeapon implements Weapon {

    private double Damage;

    public ColdWeapon(double damage) {
        Damage = damage;
    }

    @Override
    public double DealDamage() {
        return 0;
    }

    public double getDamage() {
        return Damage;
    }

    public void setDamage(double damage) {
        Damage = damage;
    }

}
