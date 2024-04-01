package studentsFaculties;

public class StudentGryffindor extends Student{
    private String nameStudent;
    private int nobility;
    private int honor;
    private int courage;
    private String[] nameQualityStudentGryffindor = new String[]{"Nobility", "Honor", "Courage"};


    public StudentGryffindor(String nameStudent, int powerMagic, int trajectory, int nobility, int honor, int courage) {
        super(powerMagic, trajectory);
        this.nameStudent = nameStudent;
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

    public String[] getNameQualityStudentGryffindor() {
        return nameQualityStudentGryffindor;
    }

    @Override
    public String getNameStudent() {
        return nameStudent;
    }

    @Override
    public String toString() {
        return "StudentGryffindor: " + nameStudent +
                ", magic power => " + getPowerMagic() +
                ", trajectory => " + getTrajectory() +
                ", nobility => " + nobility +
                ", honor => " + honor +
                ", courage => "  + courage;
    }
}

