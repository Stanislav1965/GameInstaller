import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        final String dirCreate = "Создан каталог: ";
        final String fileCreate = "Создан файл: ";

        StringBuilder logStrings = new StringBuilder();
        // определяем объект для каталога
        File dirSrc = new File("C:\\Games\\src");
        if (dirSrc.mkdir())
            logStrings.append(dirCreate).append(dirSrc).append("\n");
        File dirMain = new File("C:\\Games\\src\\main");
        if (dirMain.mkdir()) {
            logStrings.append(dirCreate).append(dirMain).append("\n");

            File fileMain = new File("C:\\Games\\src\\main", "Main.java");
            try {
                if (fileMain.createNewFile()) {
                    logStrings.append(fileCreate).append(fileMain).append("\n");
                }
            } catch (IOException e) {
                logStrings.append("Ошибка: ").append(e)
                        .append(" при создании файла: ").append(fileMain).append("\n");
            }

            File fileUtils = new File("C:\\Games\\src\\main", "Utils.java");
            try {
                if (fileUtils.createNewFile()) {
                    logStrings.append(fileCreate).append(fileUtils).append("\n");
                }
            } catch (IOException e) {
                logStrings.append("Ошибка: ").append(e)
                        .append(" при создании файла: ").append(fileUtils).append("\n");
            }

            File dirTest = new File("C:\\Games\\src\\test");
            if (dirTest.mkdir()) {
                logStrings.append(dirCreate).append(dirTest).append("\n");
            }
        }
        File dirRes = new File("C:\\Games\\res");
        if (dirRes.mkdir()) {
            logStrings.append(dirCreate).append(dirRes).append("\n");

            File dirDrawables = new File("C:\\Games\\res\\drawables");
            if (dirDrawables.mkdir()) {
                logStrings.append(dirCreate).append(dirDrawables).append("\n");
            }

            File dirVectors = new File("C:\\Games\\res\\vectors");
            if (dirVectors.mkdir()) {
                logStrings.append(dirCreate).append(dirVectors).append("\n");
            }

            File dirIcons = new File("C:\\Games\\res\\icons");
            if (dirIcons.mkdir()) {
                logStrings.append(dirCreate).append(dirIcons).append("\n");
            }
        }


        File dirSaveGames = new File("C:\\Games\\savegames");
        if (dirSaveGames.mkdir()) {
            logStrings.append(dirCreate).append(dirSaveGames).append("\n");
        }

        File dirTemp = new File("C:\\Games\\temp");
        if (dirTemp.mkdir()) {
            logStrings.append(dirCreate).append(dirTemp).append("\n");

            byte[] buffer = logStrings.toString().getBytes();

            try (FileOutputStream out = new FileOutputStream("C:\\Games\\temp\\temp.txt");
                 BufferedOutputStream bos = new BufferedOutputStream(out)) {
                // производим запись от 0 до последнего байта из массива
                bos.write(buffer, 0, buffer.length);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}