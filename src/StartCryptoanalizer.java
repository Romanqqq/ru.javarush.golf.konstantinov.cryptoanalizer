import java.util.Scanner;

public class StartCryptoanalizer {
    public static void main(String[] args) {

       // EncryptionCaesar encryptionCaesar=new EncryptionCaesar();
      //  DecodingCaesar decodingCaesar= new DecodingCaesar();
        menu();
        Scanner scanner = new Scanner(System.in);
        int step = scanner.nextInt();
        switch (step){
            case 1:
              //  encryptionCaesar.;

        }


    }
    private static void menu(){

        System.out.println("Выберите действие:");
        System.out.println("1. Шифрование методом Цезаря");
        System.out.println("2. Расшифровка методом Цезаря");
        System.out.println("3. Криптоанализ методом \"Brute Force\"");
        System.out.println("4. Криптоанализ методом статистического анализа");
        System.out.println("5. Выход");
    }

}
