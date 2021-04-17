public class Dummy {

    private double Distance;
    private double HP;
    private double DamageTaken;

    public Dummy(double distance, double HP, double damageTaken) {
        Distance = distance;
        this.HP = HP;
        DamageTaken = damageTaken;
    }

    public double getDistance() {
        return Distance;
    }

    public void setDistance(double distance) {
        Distance = distance;
    }

    public double getHP() {
        return HP;
    }

    public void setHP(double HP) {
        this.HP = HP;
    }

    public double getDamageTaken() {
        return DamageTaken;
    }

    public void setDamageTaken(double damageTaken) {
        DamageTaken = damageTaken;
    }
}
