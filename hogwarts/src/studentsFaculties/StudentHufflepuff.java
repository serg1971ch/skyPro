package studentsFaculties;

public class StudentHufflepuff extends Student{
    private String nameStudent;
    private int hardworking;
    private int loyal;
    private int honest;
    private String[] nameQualityStudentHufflepuff = new String[]{"Hardworking", "Loyal", "Honest"};

    public StudentHufflepuff(String nameStudent, int powerMagic, int trajectory,int hardworking, int loyal, int honest) {
        super(powerMagic, trajectory);
        this.nameStudent = nameStudent;
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

    public String getNameStudent() {
        return nameStudent;
    }

    public String[] getNameQualityHufflepuff() {
        return nameQualityStudentHufflepuff;
    }

    @Override
    public String toString() {
        return "StudentHufflepuff: " +
                "nameStudent => '" + nameStudent + '\'' +
                ", magic power => " + getPowerMagic() +
                ", trajectory => " + getTrajectory() +
                ", hardworking => " + hardworking +
                ", loyal => " + loyal +
                ", honest => " + honest;
    }
}
