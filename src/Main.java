// Импортируем необходимые библиотеки
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

// Основной класс программы
public class Main
{
    // Главный метод программы
    public static void main(String[] args) throws IOException
    {
        // Загружаем группу людей из файла group.txt
        load("group.txt");
    }

    // Метод для сохранения группы людей в файл
    public static void save(Human[] group, String filename)throws IOException
    {
        // Создаем файл с указанным именем
        File file = new File(filename);
        // Удаляем старый файл, если он существует
        file.delete();
        // Создаем новый файл
        file.createNewFile();

        // Создаем объект FileWriter для записи в файл
        FileWriter writer = new FileWriter(file);
        // Проходим по каждому человеку в группе
        for(int i = 0 ; i < group.length; i++)
        {
            // Записываем информацию о человеке в файл
            writer.write(((Object)group[i]).getClass().getSimpleName() + ":\t" + group[i].toString() + ";");
            // Переходим на новую строку
            writer.write('\n');
        }
        // Закрываем поток записи
        writer.close();

        // Открываем файл в Notepad++
        String command = "C:\\Program Files\\Notepad++\\notepad++ " + filename;
        Process process;
        process = Runtime.getRuntime().exec(command);
    }

    // Метод для загрузки группы людей из файла
    public static Human[] load(String filename) throws FileNotFoundException {
        // Создаем список для хранения людей
        ArrayList<Human> al_group = new ArrayList<>();
        // Открываем файл для чтения
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        // Читаем каждую строку файла
        while(scanner.hasNextLine())
        {
            // Получаем строку
            String buffer = scanner.nextLine();
            // Если строка пустая, пропускаем ее
            if(buffer.isEmpty())continue;
            // Разбиваем строку на части
            String[] values = buffer.trim().split("[:,;]\\s*");

            // Создаем нового человека и инициализируем его
            Human member = HumanFactory.Create(values[0]);
            if (member == null) {
                System.out.println("Invalid type: " + values[0]);
                continue;
            }
            member.init(values);
            // Добавляем человека в список
            al_group.add(member);
        }
        // Закрываем поток чтения
        scanner.close();

        // Преобразуем список в массив
        Human[] group = al_group.toArray(new Human[0]);
        // Выводим информацию о каждом человеке
        for (Human human : group) {
            System.out.println(human);
        }
        // Возвращаем массив людей
        return group;
    }
}

/*
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Human> groups = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("DZ28.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                String type = parts[0];
                String lastName = parts[1];
                String firstName = parts[2];
                int age = Integer.parseInt(parts[3]);
                String speciality;
                String group;
                int rating;
                int attendance;
                String subject;
                switch (type) {
                    case "Student":
                        speciality = parts[4];
                        group = parts[5];
                        rating = Integer.parseInt(parts[6]);
                        attendance = Integer.parseInt(parts[7]);
                        groups.add(new Student(lastName, firstName, age, speciality, group, rating, attendance));
                        break;
                    case "Teacher":
                        speciality = parts[4];
                        int experience = Integer.parseInt(parts[5]);
                        groups.add(new Teacher(lastName, firstName, age, speciality, experience));
                        break;
                    case "Graduate":
                        speciality = parts[4];
                        group = parts[5];
                        rating = Integer.parseInt(parts[6]);
                        attendance = Integer.parseInt(parts[7]);
                        subject = parts[8];
                        groups.add(new Graduate(lastName, firstName, age, speciality, group, rating, attendance, subject));
                        break;
                    case "Specialist":
                        speciality = parts[4];
                        group = parts[5];
                        rating = Integer.parseInt(parts[6]);
                        attendance = Integer.parseInt(parts[7]);
                        subject = parts[8];
                        int grade = Integer.parseInt(parts[9]);
                        groups.add(new Specialist(lastName, firstName, age, speciality, group, rating, attendance, subject, grade));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < groups.size(); i++) {
            System.out.println(groups.get(i));
        }
    }
}
*/
