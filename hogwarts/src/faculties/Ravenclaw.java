package faculties;

import studentsFaculties.Student;
import studentsFaculties.StudentHufflepuff;
import studentsFaculties.StudentRavenclaw;

public class Ravenclaw extends Hogwarts {
    public Ravenclaw(StudentRavenclaw[] students) {
        super(students);
    }

    public void getStudentRavenclaw(StudentRavenclaw ravenclawStudent) {
        super.getStudent(ravenclawStudent);
        for (String value : ravenclawStudent.getNameQualityRavenclaw()) {
            System.out.println(value);
        }
    }

    public void compareTwoStudentsByQuality(StudentRavenclaw bestStudentRavenclaw, StudentRavenclaw bestStudentRavenclaw1) {
        int result = bestStudentRavenclaw.getSmart() + bestStudentRavenclaw.getWise() + bestStudentRavenclaw.getVitty() + bestStudentRavenclaw.getCreativity();
        int result1 = bestStudentRavenclaw1.getSmart() + bestStudentRavenclaw1.getWise() + bestStudentRavenclaw1.getVitty() + bestStudentRavenclaw1.getCreativity();
        if (result > result1) {
            System.out.println(bestStudentRavenclaw.getNameStudent() + " лучший Когтевранoвец, чем " + bestStudentRavenclaw1.getNameStudent());
        } else {
            System.out.println(bestStudentRavenclaw1.getNameStudent() + " лучший Когтевранoвец, чем " + bestStudentRavenclaw.getNameStudent());
        }
    }

    public void compareTwoStudentsByMagic(StudentRavenclaw bestStudentRavenclaw, StudentRavenclaw bestStudentRavenclaw1) {
        int result = bestStudentRavenclaw.getPowerMagic() + bestStudentRavenclaw.getTrajectory();
        int result1 = bestStudentRavenclaw1.getPowerMagic() + bestStudentRavenclaw1.getTrajectory();
        if (result > result1) {
            System.out.println(bestStudentRavenclaw.getNameStudent() + " обладает большей мощностью магии, чем " + bestStudentRavenclaw1.getNameStudent());
        } else {
            System.out.println(bestStudentRavenclaw1.getNameStudent() + " обладает большей мощностью магии, чем " + bestStudentRavenclaw.getNameStudent());
        }
    }
}
