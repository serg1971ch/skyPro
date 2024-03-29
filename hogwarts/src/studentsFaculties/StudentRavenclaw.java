package studentsFaculties;

public class StudentRavenclaw extends Student{
    private String nameStudent;
    private int smart;
    private int wise;
    private int witty;
    private int creativity;
    private String[] nameQualityStudentRavenclaw = new String[]{"Smart", "Wise", "Witty", "Creativity"};


    public StudentRavenclaw(String nameStudent, int powerMagic, int trajectory,int smart, int wise, int witty, int creativity) {
        super(powerMagic, trajectory);
        this.nameStudent = nameStudent;
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

    public int getVitty() {
        return witty;
    }

    public void setVitty(int vitty) {
        this.witty = vitty;
    }

    public int getCreativity() {
        return creativity;
    }

    public void setCreativity(int creativity) {
        this.creativity = creativity;
    }

    public String[] getNameQualityRavenclaw() {
        return nameQualityStudentRavenclaw;
    }

    @Override
    public String getNameStudent() {
        return nameStudent;
    }

    @Override
    public String toString() {
        return "StudentRavenclaw: " +
                "nameStudent => '" + nameStudent + '\'' +
                ", magic power => " + getPowerMagic() +
                ", trajectory => " + getTrajectory() +
                ", smart => " + smart +
                ", wise => " + wise +
                ", witty => " + witty +
                ", creativity => " + creativity;
    }
}
