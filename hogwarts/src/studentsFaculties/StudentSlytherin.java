package studentsFaculties;

public class StudentSlytherin extends Student{
    private String nameStudent;
    private int cunning;
    private int decision;
    private int ambition;
    private int resourcefulness;
    private int powerHungry;
    private String[] nameQualityStudentSlytherin = new String[]{"Cunning", "Decision", "Ambition", "Resourcefulness", "Power hungry"};

    public StudentSlytherin(String nameStudent, int powerMagic, int trajectory,int cunning, int decision, int ambition, int resourcefulness, int powerHungry) {
        super(powerMagic, trajectory);
        this.nameStudent = nameStudent;
        this.cunning = cunning;
        this.decision = decision;
        this.ambition = ambition;
        this.resourcefulness = resourcefulness;
        this.powerHungry = powerHungry;
    }

    public int getCunning() {
        return cunning;
    }

    public void setCunning(int cunning) {
        this.cunning = cunning;
    }

    public int getDecision() {
        return decision;
    }

    public void setDecision(int decision) {
        this.decision = decision;
    }

    public int getAmbition() {
        return ambition;
    }

    public void setAmbition(int ambition) {
        this.ambition = ambition;
    }

    public int getResourcefulness() {
        return resourcefulness;
    }

    public void setResourcefulness(int resourcefulness) {
        this.resourcefulness = resourcefulness;
    }

    public int getPowerHungry() {
        return powerHungry;
    }

    public void setPowerHungry(int powerHungry) {
        this.powerHungry = powerHungry;
    }

    public String[] getNameQualitySlytherin() {
        return nameQualityStudentSlytherin;
    }

    @Override
    public String getNameStudent() {
        return nameStudent;
    }

    @Override
    public String toString() {
        return "StudentSlytherin: " +
                "nameStudent => '" + nameStudent + '\'' +
                ", magic power => " + getPowerMagic() +
                ", trajectory => " + getTrajectory() +
                ", cunning => " + cunning +
                ", decision => " + decision +
                ", ambition => " + ambition +
                ", resourcefulness => " + resourcefulness +
                ", powerHungry => " + powerHungry;
    }
}
