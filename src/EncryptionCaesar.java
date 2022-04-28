import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class EncryptionCaesar {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filePath =scanner.nextLine();
        try(FileReader encryptionFile= new FileReader(filePath)) {//считываем путь к файлу
            char[] buffer = new char[Short.MAX_VALUE];//размер буфера
//            int i;
//            while ((i = encryptionFile.read(buffer)) > 0) {
//                if (i < buffer.length) {
//                    buffer = Arrays.copyOf(buffer, i);
//                    System.out.println(buffer);
//
//                }
//            }
        }
        catch (IOException exception){
        }

    }
}
