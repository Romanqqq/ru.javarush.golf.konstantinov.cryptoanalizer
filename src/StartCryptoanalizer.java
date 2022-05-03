import java.io.IOException;
import java.util.Scanner;

public class StartCryptoanalizer {
    public static void main(String[] args) throws IOException {
        boolean cryptoanalizerWorks = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте, это криптоанализатор!");
        System.out.println("Выберите действие:");
        while (cryptoanalizerWorks) {
            System.out.println("1. Шифрование методом Цезаря");
            System.out.println("2. Расшифровка методом Цезаря");
            System.out.println("3. Криптоанализ методом \"Brute Force\"");
            System.out.println("4. Выход");
            int step = scanner.nextInt();
            switch (step) {
                case 1:
                    EncryptionCaesar encryptionCaesar = new EncryptionCaesar();
                    encryptionCaesar.encryption();
                    break;
                case 2:
                    DecodingCaesar decodingCaesar= new DecodingCaesar();
                    decodingCaesar.decoding();
                    break;
                case 3:
                    BruteForce bruteForce=new BruteForce();
                    bruteForce.analyzator();
                    break;
                case 4:
                    cryptoanalizerWorks = false;
                    break;
                default:
                    System.out.println("Выберите действие из указанных:");
            }
        }
        scanner.close();
    }
}
