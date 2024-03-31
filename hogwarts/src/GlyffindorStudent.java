public class GlyffindorStudent extends HogwartStudent {
    private int nobility;
    private int honor;
    private int courage;

    public GlyffindorStudent(String name, int powerOfMagic, int transgressionDistance, int nobility, int honor, int courage) {
        super(name, powerOfMagic, transgressionDistance);
        this.nobility = nobility;
        this.honor = honor;
        this.courage = courage;
    }

    public int getNobility() {
        return nobility;
    }

    public void setNobility(int nobility) {
        this.nobility = nobility;
    }

    public int getHonor() {
        return honor;
    }

    public void setHonor(int honor) {
        this.honor = honor;
    }

    public int getCourage() {
        return courage;
    }

    public void setCourage(int courage) {
        this.courage = courage;
    }

    @Override
    protected int sumCharacteristics() {
        return nobility + honor + courage;
    }

    public void compareTo(GlyffindorStudent glyffindorStudent) {
        compareWithAnotherStudent(glyffindorStudent);
    }

    @Override
    public String toString() {
        return "GlyffindorStudent: " + super.toString() +
                "nobility => " + nobility +
                ", honor => " + honor +
                ", courage => " + courage;
    }
}
