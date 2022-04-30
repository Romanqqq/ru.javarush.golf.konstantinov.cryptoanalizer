import java.io.*;
import java.util.Scanner;

public class DecodingCaesar {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите путь к зашифрованному файлу:");
        String filePath = scanner.nextLine();//путь к файлу
        System.out.println("Укажите путь для записи расшифрованного файла");
        String fileEncrypted= scanner.nextLine();
        System.out.println("Укажите ключ к шифру:");
        int key = scanner.nextInt();//ключ к шифру Цезаря
        String fileReader = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileEncrypted))) {
            while ((fileReader = (br.readLine())) != null) {
                char[] fileCode = new char[fileReader.length()];
                for (int i = 0; i < fileReader.length(); i++) {
                    if (Character.isLetter(fileReader.charAt(i)) && Character.isUpperCase(fileReader.charAt(i))) {
                        fileCode[i] = (char) (((int) (fileReader.charAt(i) - 'А' - key) % 32) + 'А');
                    } else if (Character.isLetter(fileReader.charAt(i)) && Character.isLowerCase(fileReader.charAt(i))) {
                        fileCode[i] = (char) (((int) (fileReader.charAt(i) - 'а' - key) % 32) + 'а');
                    } else
                        fileCode[i] = (char) (((int) (fileReader.charAt(i) - ' ' - key) % 33) + ' ');
                }
                fileWriter.write(fileCode);
                fileWriter.newLine();
                fileWriter.flush();
                System.out.println(fileCode);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
