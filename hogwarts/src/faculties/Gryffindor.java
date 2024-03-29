package faculties;

import studentsFaculties.Student;
import studentsFaculties.StudentGryffindor;

public class Gryffindor extends Hogwarts {
    private StudentGryffindor studentGryffindor;

    public Gryffindor(StudentGryffindor[] studentsGryffindor) {
        super(studentsGryffindor);
    }

    public void getStudentGryffindor(StudentGryffindor gryffindorStudent) {
        super.getStudent(gryffindorStudent);
        for (String value : gryffindorStudent.getNameQualityStudentGryffindor()) {
            System.out.println(value);
        }
    }

    /*
   Реализуйте 4 метода, по одному для каждого факультета, которые сравнивают между собой двух учеников одного факультета по свойствам.
   Чтобы сравнить учеников, нужно сложить баллы по каждому свойству, которое присуще ученику данного факультета.
   Тот ученик, у которого сумма свойств больше, считается лучшим учеником. Метод должен выводить в консоль результат сравнения учеников.
    */
    public void compareTwoStudentsByQuality(StudentGryffindor bestStudentGryffindor, StudentGryffindor bestStudentGryffindor1) {
        int result = 0;
        int result1 = 0;
        result =  bestStudentGryffindor.getHonor() + bestStudentGryffindor.getNobility() + bestStudentGryffindor.getCourage();
        result1 = bestStudentGryffindor1.getHonor() + bestStudentGryffindor1.getNobility() + bestStudentGryffindor1.getCourage();
        if(result>result1) {
            System.out.println(bestStudentGryffindor.getNameStudent() + " лучший Гриффиндорец, чем " + bestStudentGryffindor1.getNameStudent());
        } else {
            System.out.println(bestStudentGryffindor1.getNameStudent() + " лучший Гриффиндорец, чем " + bestStudentGryffindor.getNameStudent());
        }
    }

    /*
    Реализуйте метод, который сравнивает двух любых учеников Хогвартса по силе магии и расстоянию трансгрессии,
     и выводит в консоль сравнительную оценку между двумя учениками.
     */
    public void compareTwoStudentsByMagic(StudentGryffindor bestStudentGryffindor, StudentGryffindor bestStudentGryffindor1) {
        int result = bestStudentGryffindor.getPowerMagic() + bestStudentGryffindor.getTrajectory();
        int result1 = bestStudentGryffindor1.getPowerMagic() + bestStudentGryffindor1.getTrajectory();
        if(result > result1) {
            System.out.println(bestStudentGryffindor.getNameStudent() + " обладает большей мощностью магии, чем " + bestStudentGryffindor1.getNameStudent());
        } else {
            System.out.println(bestStudentGryffindor1.getNameStudent() + " обладает большей мощностью магии, чем " + bestStudentGryffindor.getNameStudent());
        }
    }
}
