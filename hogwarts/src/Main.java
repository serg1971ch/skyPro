import faculties.*;
import studentsFaculties.*;

public class Main {
    public static void main(String[] args) {
        StudentGryffindor garryPotter = new StudentGryffindor("Garry Potter", 87, 92, 99, 88, 96);
        StudentGryffindor hermioneGranger = new StudentGryffindor("Hermione Granger", 90, 87, 82, 55, 78);
        StudentGryffindor ronWeasley  = new StudentGryffindor("Ron Weasley", 88, 79, 77, 67,89);

        StudentSlytherin dracoMalfoy = new StudentSlytherin("Draco Malfoy", 88, 67, 77, 89, 94, 67, 92);
        StudentSlytherin grahamMontague = new StudentSlytherin("Graham Montague", 65, 73, 82, 54, 84, 78, 89);
        StudentSlytherin gregoryGoyle = new StudentSlytherin("Gregory Goyle", 72, 87, 97, 69, 78, 83, 91);

        StudentHufflepuff zachariahSmith = new StudentHufflepuff("Zachariah Smith", 88, 79,92, 84, 93);
        StudentHufflepuff cedricDiggory = new StudentHufflepuff("Cedric Diggory", 92, 88,95, 76, 89);
        StudentHufflepuff justinFinchFletchley = new StudentHufflepuff("Justin Finch-Fletchley", 84, 75,98, 79, 95);

        StudentRavenclaw zhouChang = new StudentRavenclaw("Zhou Chang", 67, 71, 87,92, 95, 85);
        StudentRavenclaw padmaPatil = new StudentRavenclaw("Padma Patil", 77, 81, 85,83, 75, 94);
        StudentRavenclaw marcusBelby = new StudentRavenclaw("Marcus Belby", 85, 91, 87,92, 88, 86);

        System.out.println("Создаем факультеты");
        Gryffindor gryffindor = new Gryffindor(new StudentGryffindor[]{garryPotter, hermioneGranger, ronWeasley});
        Slytherin slytherin = new Slytherin(new StudentSlytherin[]{dracoMalfoy,grahamMontague,gregoryGoyle});
        Hufflepuff hufflepuff = new Hufflepuff(new StudentHufflepuff[]{zachariahSmith,cedricDiggory,justinFinchFletchley});
        Ravenclaw ravenclaw = new Ravenclaw(new StudentRavenclaw[]{zhouChang,padmaPatil,marcusBelby});
        System.out.println("Реализуем методы");
        System.out.println("Задание №2");
        gryffindor.getStudentGryffindor(garryPotter);
        System.out.println("*************************");
        slytherin.getStudentSlytherin(grahamMontague);
        System.out.println(" ");
        System.out.println("Задание №3");
        gryffindor.compareTwoStudentsByQuality(ronWeasley, hermioneGranger);
        hufflepuff.compareTwoStudentsByQuality(zachariahSmith, cedricDiggory);
        ravenclaw.compareTwoStudentsByQuality(padmaPatil, marcusBelby);
        slytherin.compareTwoStudentsByQuality(dracoMalfoy, gregoryGoyle);
        System.out.println(" ");
        System.out.println("Задание №4");
        gryffindor.compareTwoStudentsByMagic(ronWeasley, garryPotter);
        hufflepuff.compareTwoStudentsByMagic(zachariahSmith, justinFinchFletchley );
        ravenclaw.compareTwoStudentsByMagic(zhouChang, marcusBelby);
        slytherin.compareTwoStudentsByMagic(grahamMontague, gregoryGoyle);
    }
}