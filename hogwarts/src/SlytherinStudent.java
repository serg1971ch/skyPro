public class SlytherinStudent extends HogwartStudent{
    private int cunning;
    private int decision;
    private int ambition;
    private int resourcefulness;
    private int powerHungry;

    public SlytherinStudent(String name, int powerMagic, int trajectory, int cunning, int decision, int ambition, int resourcefulness, int powerHungry) {
        super(name, powerMagic, trajectory);
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

    @Override
    protected int sumCharacteristics() {
        return cunning + decision + ambition + resourcefulness + powerHungry;
    }

    public void compareTo(SlytherinStudent slytherinStudent) {
        compareWithAnotherStudent(slytherinStudent);
    }

    @Override
    public String toString() {
        return "SlytherinStudent: " + super.toString() +
                "cunning => " + cunning +
                ", decision => " + decision +
                ", ambition => " + ambition +
                ", resourcefulness => " + resourcefulness +
                ", powerHungry => " + powerHungry;
    }
}
