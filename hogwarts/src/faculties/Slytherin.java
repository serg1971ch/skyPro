package faculties;

import studentsFaculties.Student;
import studentsFaculties.StudentGryffindor;
import studentsFaculties.StudentHufflepuff;
import studentsFaculties.StudentSlytherin;

public class Slytherin extends Hogwarts{

    public Slytherin(Student[] students) {
        super(students);
    }

    public void getStudentSlytherin(StudentSlytherin slytherinStudent) {
        super.getStudent(slytherinStudent);
        for (String value : slytherinStudent.getNameQualitySlytherin()) {
            System.out.println(value);
        }
    }

    public void compareTwoStudentsByQuality(StudentSlytherin bestStudentSlytherin, StudentSlytherin bestStudentSlytherin1) {
        int result = 0;
        int result1 = 0;
        result =  bestStudentSlytherin.getCunning() + bestStudentSlytherin.getDecision() + bestStudentSlytherin.getResourcefulness()
                + bestStudentSlytherin.getAmbition() + bestStudentSlytherin.getPowerHungry();
        result1 = bestStudentSlytherin1.getCunning() + bestStudentSlytherin1.getDecision() + bestStudentSlytherin1.getResourcefulness()
                + bestStudentSlytherin1.getAmbition() + bestStudentSlytherin1.getPowerHungry();
        if(result>result1) {
            System.out.println(bestStudentSlytherin.getNameStudent() + " лучший Слизеринец, чем " + bestStudentSlytherin1.getNameStudent());
        } else {
            System.out.println(bestStudentSlytherin1.getNameStudent() + " лучший Слизеринец, чем " + bestStudentSlytherin.getNameStudent());
        }
    }

    public void compareTwoStudentsByMagic(StudentSlytherin bestStudentSlytherin, StudentSlytherin bestStudentSlytherin1) {
        int result = 0;
        int result1 = 0;
        result = bestStudentSlytherin.getPowerMagic() + bestStudentSlytherin.getTrajectory();
        result1 = bestStudentSlytherin1.getPowerMagic() + bestStudentSlytherin1.getTrajectory();
        if(result>result1) {
            System.out.println(bestStudentSlytherin.getNameStudent() + " обладает большей мощностью магии, чем " + bestStudentSlytherin1.getNameStudent());
        } else {
            System.out.println(bestStudentSlytherin1.getNameStudent() + " обладает большей мощностью магии, чем " + bestStudentSlytherin.getNameStudent());
        }
    }
}
