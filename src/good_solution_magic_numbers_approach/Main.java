package good_solution_magic_numbers_approach;

public class Main {
    public static void main(String[] args) {

        String filename = "./files/file2.pde";

        MagicNumbers mn = new MagicNumbers(filename);
        mn.identifyTypeByMagicNumbers();

    }
}
