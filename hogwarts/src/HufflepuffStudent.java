public class HufflepuffStudent extends HogwartStudent{
    private int hardworking;
    private int loyal;
    private int honest;

    public HufflepuffStudent(String name, int powerMagic, int trajectory,int hardworking, int loyal, int honest) {
        super(name, powerMagic, trajectory);
        this.hardworking = hardworking;
        this.loyal = loyal;
        this.honest = honest;
    }

    public int getHardworking() {
        return hardworking;
    }

    public void setHardworking(int hardworking) {
        this.hardworking = hardworking;
    }

    public int getLoyal() {
        return loyal;
    }

    public void setLoyal(int loyal) {
        this.loyal = loyal;
    }

    public int getHonest() {
        return honest;
    }

    public void setHonest(int honest) {
        this.honest = honest;
    }

    @Override
    protected int sumCharacteristics() {
        return hardworking + loyal + honest;
    }

    public void compareTo(HogwartStudent hogwartStudent) {
        compareWithAnotherStudent(hogwartStudent);
    }

    @Override
    public String toString() {
        return "HufflepuffStudent: " + super.toString() +
                "hardworking => " + hardworking +
                ", loyal => " + loyal +
                ", honest => " + honest;
    }
}
