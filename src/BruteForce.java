
import java.io.*;

import java.util.Scanner;

public class BruteForce {
     public void bruteForce()throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите путь к зашифрованному файлу:");
        String filePath = scanner.nextLine();
        System.out.println("Укажите путь для записи расшифрованного файла:");
        String fileDecrypted = scanner.nextLine();
        String fileReader;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while ((fileReader = (bufferedReader.readLine())) != null) {
                char[] fileCode = fileReader.toCharArray();
                int key;
                for (key = 1; key < 33; key++) {
                    for (int i = 0; i < fileCode.length; i++) {
                        if (fileCode[i] == ' ') {
                        } else {
                            if (fileCode[i] >= 'А' && fileCode[i] <= 'Я') {
                                fileCode[i] = (char) (fileCode[i] - key);
                                if (fileCode[i] < 'А') {
                                    fileCode[i] = (char) (fileCode[i] + 32);
                                }
                            } else {
                                fileCode[i] = (char) (fileCode[i] - key);
                                if (fileCode[i] < 'а') {
                                    fileCode[i] = (char) (fileCode[i] + 32);
                                }
                            }
                        }
                    }
                    System.out.println("Ключ: " + key + "; Расшифрованная строка: " + String.valueOf(fileCode));
                    fileCode = fileReader.toCharArray();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Выберите ключ из предложенного:");
        int selectKey = scanner.nextInt();
        try (BufferedReader bufferedReaders = new BufferedReader(new FileReader(filePath));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileDecrypted))) {
            while ((fileReader = (bufferedReaders.readLine())) != null) {
                char[] fileCodes = new char[fileReader.length()];
                for (int i = 0; i < fileReader.length(); i++) {
                    if (fileReader.charAt(i) >= 'А' && fileReader.charAt(i) <= 'Я') {
                        fileCodes[i] = (char) ((((fileReader.charAt(i)) - 'А' - selectKey) % 32) + 'А');
                        if (fileReader.charAt(i) < 'А' && fileReader.charAt(i) > 'Я') {
                            fileCodes[i] = fileReader.charAt(i);
                        }
                    } else if (fileReader.charAt(i) >= 'а' && fileReader.charAt(i) <= 'я') {
                        fileCodes[i] = (char) ((((fileReader.charAt(i)) - 'а' - selectKey) % 32) + 'а');
                        if (fileReader.charAt(i) < 'а' && fileReader.charAt(i) > 'я') {
                            fileCodes[i] = fileReader.charAt(i);
                        }
                    } else
                        fileCodes[i] = (char) ((((fileReader.charAt(i)) - 32 - selectKey) % 63) + 32);
                }
                fileWriter.write(fileCodes);
                fileWriter.newLine();
                fileWriter.flush();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         System.out.println("Файл расшифрован!");
         System.out.println("Что вы хотите сделать дальше?");
    }
}
