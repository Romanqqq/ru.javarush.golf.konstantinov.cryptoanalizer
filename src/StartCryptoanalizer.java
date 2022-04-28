import java.util.Scanner;

public class StartCryptoanalizer {
    public static void main(String[] args) {
        menu();
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();


    }
    public static void menu(){

        System.out.println("Выберите действие:");
        System.out.println("1. Шифрование методом Цезаря");
        System.out.println("2. Расшифровка методом Цезаря");
        System.out.println("3. Криптоанализ методом \"Brute Force\"");
        System.out.println("4. Криптоанализ методом статистического анализа");
        System.out.println("5. Выход");

    }
}
