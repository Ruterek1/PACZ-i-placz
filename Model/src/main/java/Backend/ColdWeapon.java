package Backend;

public class ColdWeapon implements Weapon {

    private double damage;

    public ColdWeapon(double damage) {
        this.damage = damage;
    }

    @Override
    public double dealDamage(Dummy dummy) {
        if(dummy.getDistance()>40) {
            return 0;
        }
        return getDamage();
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

}
