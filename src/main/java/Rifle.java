public class Rifle extends Firearm {

    private final double Scope;

    public Rifle(int magazine, double range, int ammo, double bulletDamage, double scope) {
        super(magazine, range, ammo, bulletDamage);
        Scope = scope;
    }

    public double getScope() {
        return Scope;
    }

}
