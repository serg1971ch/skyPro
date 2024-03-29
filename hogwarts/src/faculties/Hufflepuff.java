package faculties;

import studentsFaculties.Student;
import studentsFaculties.StudentGryffindor;
import studentsFaculties.StudentHufflepuff;
import studentsFaculties.StudentSlytherin;

public class Hufflepuff extends Hogwarts{
    public Hufflepuff(StudentHufflepuff[] students) {
        super(students);
    }

    public void getStudentHufflepuff(StudentHufflepuff hufflepuffStudent) {
        super.getStudent(hufflepuffStudent);
        for (String value : hufflepuffStudent.getNameQualityHufflepuff()) {
            System.out.println(value);
        }
    }

    public void compareTwoStudentsByQuality(StudentHufflepuff bestStudentHufflepuff, StudentHufflepuff bestStudentHufflepuff1) {
        int result =  bestStudentHufflepuff.getHardworking() + bestStudentHufflepuff.getLoyal() + bestStudentHufflepuff.getHonest();
        int result1 = bestStudentHufflepuff1.getHardworking() + bestStudentHufflepuff.getLoyal() + bestStudentHufflepuff.getHonest();
        if(result>result1) {
            System.out.println(bestStudentHufflepuff.getNameStudent() + " лучший Пуффендуйец, чем " + bestStudentHufflepuff1.getNameStudent());
        } else {
            System.out.println(bestStudentHufflepuff1.getNameStudent() + " лучший Пуффендуйец, чем " + bestStudentHufflepuff.getNameStudent());
        }
    }

    public void compareTwoStudentsByMagic(StudentHufflepuff bestStudentHufflepuff, StudentHufflepuff bestStudentHufflepuff1) {
        int result = bestStudentHufflepuff.getPowerMagic() + bestStudentHufflepuff.getTrajectory();
        int result1 = bestStudentHufflepuff1.getPowerMagic() + bestStudentHufflepuff1.getTrajectory();
        if(result>result1) {
            System.out.println(bestStudentHufflepuff.getNameStudent() + " обладает большей мощностью магии, чем " + bestStudentHufflepuff1.getNameStudent());
        } else {
            System.out.println(bestStudentHufflepuff1.getNameStudent() + " обладает большей мощностью магии, чем " + bestStudentHufflepuff.getNameStudent());
        }
    }
}
