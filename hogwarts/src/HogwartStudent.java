public abstract class HogwartStudent {
    private String name;
    private int powerOfMagic;
    private int transgressionDistance;

    public HogwartStudent(String name, int powerOfMagic, int transgressionDistance) {
        this.name = name;
        this.powerOfMagic = powerOfMagic;
        this.transgressionDistance = transgressionDistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPowerOfMagic() {
        return powerOfMagic;
    }

    public void setPowerOfMagic(int powerOfMagic) {
        this.powerOfMagic = powerOfMagic;
    }

    public int getTransgressionDistance() {
        return transgressionDistance;
    }

    public void setTransgressionDistance(int transgressionDistance) {
        this.transgressionDistance = transgressionDistance;
    }

    private int sumBaseCharacteristics() {
        return powerOfMagic + transgressionDistance;
    }

    protected abstract int sumCharacteristics();

    protected void compareWithAnotherStudent(HogwartStudent hogwartStudent) {
        int sumCharacteristics = this.sumBaseCharacteristics();
        int sumCharacteristics1 = hogwartStudent.sumBaseCharacteristics();
        if (sumCharacteristics > sumCharacteristics1) {
            System.out.printf("Студент %s лучше студента %s (%d,%d)\n",
                    this.getName(), hogwartStudent.getName(), sumCharacteristics, sumCharacteristics1);
        } else if (sumCharacteristics < sumCharacteristics1) {
            System.out.printf("Студент %s хуже студента %s (%d,%d)\n",
                    hogwartStudent.getName(), this.getName(), sumCharacteristics, sumCharacteristics1);
        } else {
            System.out.printf("Студент %s обладает одинаковыми магическими свойствами студента %s (%d,%d)\n",
                    hogwartStudent.getName(), this.getName(), sumCharacteristics, sumCharacteristics1);
        }
    }

    protected void compareWithAnotherHogwartsStudent(HogwartStudent hogwartStudent) {
        int sumCharacteristics = this.sumBaseCharacteristics();
        int sumCharacteristics1 = hogwartStudent.sumBaseCharacteristics();
        if (sumCharacteristics > sumCharacteristics1) {
            System.out.printf("Студент %s лучше студента %s (%d,%d)\n",
                    this.getName(), hogwartStudent.getName(), sumCharacteristics, sumCharacteristics1);
        } else if (sumCharacteristics < sumCharacteristics1) {
            System.out.printf("Студент %s хуже студента %s (%d,%d)\n",
                    hogwartStudent.getName(), this.getName(), sumCharacteristics, sumCharacteristics1);
        } else {
            System.out.printf("Студент %s обладает одинаковыми магическими свойствами студента %s (%d,%d)\n",
                    hogwartStudent.getName(), this.getName(), sumCharacteristics, sumCharacteristics1);
        }
    }

    @Override
    public String toString() {
        return  "name => '" + name + '\'' +
                ", powerOfMagic => " + powerOfMagic +
                ", transgressionDistance => " + transgressionDistance;
    }

    public void print() {
        System.out.println(this);
    }
}
