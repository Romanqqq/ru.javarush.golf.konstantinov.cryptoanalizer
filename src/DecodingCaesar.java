import java.io.*;
import java.util.Scanner;

public class DecodingCaesar {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите путь к зашифрованному файлу:");
        String filePath = scanner.nextLine();//путь к файлу
        System.out.println("Укажите путь для записи расшифрованного файла:");
        String fileDecrypted = scanner.nextLine();
        System.out.println("Укажите ключ к шифру:");
        int key = scanner.nextInt();//ключ к шифру Цезаря
        String fileReader = null;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileDecrypted))) {
            while ((fileReader = (br.readLine())) != null) {
                char[] fileCode = new char[fileReader.length()];
                for (int i = 0; i < fileReader.length(); i++) {
                    if (fileReader.charAt(i) >= 'А' && fileReader.charAt(i) <= 'Я') {
                        fileCode[i] = (char) (((((int) (fileReader.charAt(i))) - 'А' - key) % 32) + 'А');
                        if (fileReader.charAt(i) < 'А' && fileReader.charAt(i) > 'Я') {
                            fileCode[i] = fileReader.charAt(i);
                        }
                    } else if (fileReader.charAt(i) >= 'а' && fileReader.charAt(i) <= 'я') {
                        fileCode[i] = (char) (((((int) (fileReader.charAt(i))) - 'а' - key) % 32) + 'а');
                        if (fileReader.charAt(i) < 'а' && fileReader.charAt(i) > 'я') {
                            fileCode[i] = fileReader.charAt(i);
                        }
                    } else
                        fileCode[i] = (char) (((((int) (fileReader.charAt(i))) - ' ' - key) % 32) + ' ');
                }
                fileWriter.write(fileCode);
                fileWriter.newLine();
                fileWriter.flush();
                //  System.out.println(fileCode);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
