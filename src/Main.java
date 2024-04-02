import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String dirGame = "C:\\Games";

        List<String> directory = Arrays.asList("src", "res", "savegames", "temp", "src\\main", "src\\test", "res\\drawables", "res\\vectors", "res\\icons");
        List<String> filePath = Arrays.asList("src\\main\\Main.java", "src\\main\\Utils.java", "temp\\temp.txt");

        StringBuilder logStrings = new StringBuilder();
        // определяем объект для каталога

        for (String dir : directory) {
            String absPath = dirGame + File.separator + dir;
            logStrings.append(CreateDirectory(absPath)).append(absPath).append("\n");
        }

        for (String name : filePath) {
            String absPath = dirGame + File.separator + name;
            logStrings.append(CreateFile(absPath)).append(absPath).append("\n");
        }

        byte[] buffer = logStrings.toString().getBytes();

        try (FileOutputStream out = new FileOutputStream("C:\\Games\\temp\\temp.txt");
             BufferedOutputStream bos = new BufferedOutputStream(out)) {
            // производим запись от 0 до последнего байта из массива
            bos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String CreateDirectory(String DirPath) {
        File dirSrc = new File(DirPath);
        if (dirSrc.exists()) {
            return "Существует каталог: ";
        }
        return dirSrc.mkdir() ? "Cоздан каталог: " : "Не создан каталог: ";
    }

    private static String CreateFile(String dirPath) {
        File fileSrc = new File(dirPath);
        String res = null;
        if (fileSrc.exists() || fileSrc.isFile()) {
            return "Существует файл: ";
        }
        try {
            if (fileSrc.createNewFile()) {
                res = "Создан файл: ";
            }
        } catch (IOException e) {
            return ("Ошибка " + e + " при создании файла: ");
        }
    return res;
    }
}
