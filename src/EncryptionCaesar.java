import java.io.*;
import java.util.*;

public class EncryptionCaesar {
    public static final List<Character> PUNCTUATION_MARKS = Arrays.asList('.', ',', '"', ':', '-', '!', '?', ' ');

    public void encryption() throws IOException {

        Scanner scanner = new Scanner(System.in);
        //  while(scanner.)
        System.out.println("Укажите путь к файлу:");
        String filePath = scanner.nextLine();
        System.out.println("Укажите путь для записи зашифрованного файла:");
        String fileEncrypted = scanner.nextLine();
        System.out.println("Укажите ключ к шифру:");
        int key = scanner.nextInt();
        String fileReader = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader((filePath)));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileEncrypted))) {
            while ((fileReader = (bufferedReader.readLine())) != null) {
                char[] fileCode = new char[fileReader.length()];
                for (int i = 0; i < fileReader.length(); i++) {
                    if (fileReader.charAt(i) >= 'А' && fileReader.charAt(i) <= 'Я') {
                        fileCode[i] = (char) (((((int) (fileReader.charAt(i))) - 'А' + key) % 32) + 'А');
                        if (fileReader.charAt(i) < 'А' && fileReader.charAt(i) > 'Я') {
                            fileCode[i] = fileReader.charAt(i);
                        }
                    } else if (fileReader.charAt(i) >= 'а' && fileReader.charAt(i) <= 'я') {
                        fileCode[i] = (char) (((((int) (fileReader.charAt(i))) - 'а' + key) % 32) + 'а');
                        if (fileReader.charAt(i) < 'а' && fileReader.charAt(i) > 'я') {
                            fileCode[i] = fileReader.charAt(i);
                        }
                    } else
                        fileCode[i] = (char) (((((int) (fileReader.charAt(i))) - 32 + key) % 63) + 32);
                }
                    fileWriter.write(fileCode);
                    fileWriter.newLine();
                    fileWriter.flush();

            }
        } catch (FileNotFoundException exception) {
            System.out.println("По данному пути, файл отсутствует.");
            System.out.println("Укажите путь к файлу!");
            System.out.println("Что вы хотите сделать дальше?");
            return;
        } catch (IOException exception) {
            exception.printStackTrace();
            return;
        }

        System.out.println("Файл зашифрован!");
        System.out.println("Что вы хотите сделать дальше?");
    }
}