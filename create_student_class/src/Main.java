public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(" Alice ", 101, 3.8, "Computer Science");
        Student student2 = new Student("alice", 101, 4.5, " ");
        Student student3 = new Student(null, 103, -1.0, null);

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        System.out.println("Student1 equals Student2? " + student1.equals(student2));
        System.out.println("Student2 equals Student3? " + student2.equals(student3));
    }
}
