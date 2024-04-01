public class MainMagicSchool {
    public static void main(String[] args) {
        GlyffindorStudent garryPotter = new GlyffindorStudent("Garry Potter", 87, 92, 99, 88, 96);
        GlyffindorStudent hermioneGranger = new GlyffindorStudent("Hermione Granger", 90, 87, 82, 55, 78);
        GlyffindorStudent ronWeasley  = new GlyffindorStudent("Ron Weasley", 88, 79, 77, 67,89);

        SlytherinStudent dracoMalfoy = new SlytherinStudent("Draco Malfoy", 88, 67, 77, 89, 94, 67, 92);
        SlytherinStudent grahamMontague = new SlytherinStudent("Graham Montague", 65, 73, 82, 54, 84, 78, 89);
        SlytherinStudent gregoryGoyle = new SlytherinStudent("Gregory Goyle", 72, 87, 97, 69, 78, 83, 91);

        HufflepuffStudent zachariahSmith = new HufflepuffStudent("Zachariah Smith", 88, 79,92, 84, 93);
        HufflepuffStudent cedricDiggory = new HufflepuffStudent("Cedric Diggory", 92, 88,95, 76, 89);
        HufflepuffStudent justinFinchFletchley = new HufflepuffStudent("Justin Finch-Fletchley", 84, 75,98, 79, 95);

        RavenclawStudent zhouChang = new RavenclawStudent("Zhou Chang", 67, 71, 87,92, 95, 85);
        RavenclawStudent padmaPatil = new RavenclawStudent("Padma Patil", 77, 81, 85,83, 75, 94);
        RavenclawStudent marcusBelby = new RavenclawStudent("Marcus Belby", 85, 91, 87,92, 88, 86);
        System.out.println("Задание №2");
        garryPotter.print();
        marcusBelby.print();
        System.out.println(" ");
        System.out.println("Задание №3");
        garryPotter.compareWithAnotherStudent(hermioneGranger);
        grahamMontague.compareWithAnotherStudent(padmaPatil);
        cedricDiggory.compareWithAnotherStudent(gregoryGoyle);
        justinFinchFletchley.compareWithAnotherStudent(zhouChang);
        System.out.println(" ");
        System.out.println("Задание №4");
        zachariahSmith.compareTo(dracoMalfoy);
        grahamMontague.compareTo(dracoMalfoy);
        garryPotter.compareTo(ronWeasley);
        marcusBelby.compareTo(zhouChang);
    }
}
