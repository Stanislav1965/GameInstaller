import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> dirPath = Arrays.asList("C:\\Games\\src"
                , "C:\\Games\\res"
                , "C:\\Games\\savegames"
                , "C:\\Games\\temp"
                , "C:\\Games\\src\\main"
                , "C:\\Games\\src\\test"
                , "C:\\Games\\res\\drawables"
                , "C:\\Games\\res\\vectors"
                , "C:\\Games\\res\\icons");
        List<String> filePath = Arrays.asList("C:\\Games\\src\\main\\Main.java"
                , "C:\\Games\\src\\main\\Utils.java"
                , "C:\\Games\\temp\\temp.txt");

        StringBuilder logStrings = new StringBuilder();

        for (String dir : dirPath) {
            logStrings.append(createDirectory(dir));
        }

        for (String name : filePath) {
            logStrings.append(createFile(name));
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

    private static String createDirectory(String dirPath) {
        File dirSrc = new File(dirPath);
        return dirSrc.mkdir() ? "Директория  " + dirPath + "  создана успешно.\n"
                : "Директория  " + dirPath + "  не создана.\n";
    }

    private static String createFile(String name) {
        File fileSrc = new File(name);
        String res = null;
        if (fileSrc.exists() || fileSrc.isFile()) {
            return "Файл  " + name + "  существует.\n";
        }
        try {
            if (fileSrc.createNewFile()) {
                res = "Файл  " + name + "  создан успешно.\n";
            }
        } catch (IOException e) {
            return ("Файл  " + name + "  не создан. Ошибка - " + e + "\n");
        }
        return res;
    }
}
