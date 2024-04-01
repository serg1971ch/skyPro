package studentsFaculties;

public class Student {
    private String nameStudent;
    private int powerMagic;
    private int trajectory;
    private String[] nameQualityStudent = new String[]{"Power magic", "Trajectory"};

    public String[] getNameQualityStudent() {
        return nameQualityStudent;
    }

    public int getPowerMagic() {
        return powerMagic;
    }

    public void setPowerMagic(int powerMagic) {
        this.powerMagic = powerMagic;
    }

    public int getTrajectory() {
        return trajectory;
    }

    public void setTrajectory(int trajectory) {
        this.trajectory = trajectory;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public Student(int powerMagic, int trajectory) {
        this.powerMagic = powerMagic;
        this.trajectory = trajectory;
    }
}
