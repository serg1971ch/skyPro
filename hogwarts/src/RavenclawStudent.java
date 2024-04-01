public class RavenclawStudent extends HogwartStudent{
    private int smart;
    private int wise;
    private int witty;
    private int creativity;

    public RavenclawStudent(String name, int powerMagic, int trajectory, int smart, int wise, int witty, int creativity) {
        super(name, powerMagic, trajectory);
        this.smart = smart;
        this.wise = wise;
        this.witty = witty;
        this.creativity = creativity;
    }

    public int getSmart() {
        return smart;
    }

    public void setSmart(int smart) {
        this.smart = smart;
    }

    public int getWise() {
        return wise;
    }

    public void setWise(int wise) {
        this.wise = wise;
    }

    public int getWitty() {
        return witty;
    }

    public void setWitty(int witty) {
        this.witty = witty;
    }

    public int getCreativity() {
        return creativity;
    }

    public void setCreativity(int creativity) {
        this.creativity = creativity;
    }

    @Override
    protected int sumCharacteristics() {
        return wise + smart + witty + creativity;
    }

    public void compareTo(RavenclawStudent ravenclawStudent) {
        compareWithAnotherStudent(ravenclawStudent);
    }

    @Override
    public String toString() {
        return "RavenclawStudent: " + super.toString() +
                "smart => " + smart +
                ", wise => " + wise +
                ", witty => " + witty +
                ", creativity => " + creativity;
    }
}
