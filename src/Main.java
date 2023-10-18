// Чтение данных из файла с помощью FileReader
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
   /* Human human = new Human ("Montana", "Antonio", 30); //Работа в классе 12.10.2023
    System.out.println(human);
            //Объект клкааса Student
        Student student = new Student("Pinlman", "Jessie", 25, "Chemistry", "WW_22", 90, 95);
        System.out.println(student);

        Teacher teacher = new Teacher( "Pinl", "Jes", 25, "Chemistry", 50);
        System.out.println(teacher);

        Graduate graduate = new Graduate( "Shreder", "Hank", 40,
                "Criminalistik", "OBN" ,
                50,   70 ,"How");
        System.out.println(graduate);

        Specialist hank = new Specialist(graduate, 3);
        System.out.println(hank);*/
   /*    Specialist leo = new Specialist("Rosenberg", "Ken", 35, "Lower", "Vice", 35, 22, "Get money", 3);  //Работа в классе 17.10.2023
        Human[] group = new Human[]
                {
                        new Student("Pinlman", "Jessie", 25, "Chemistry", "WW_22", 90, 95),
                        new Teacher("Pinl", "Jes", 25, "Chemistry", 50),
                        new Graduate("Shreder", "Hank", 40, "Criminalistik", "OBN", 50, 70, "How"),
                        new Specialist("Versetti", "Tommy", 30, "Theft", "Vice", 98, 99, "Get money back", 5),
                        new Teacher("Diaz", "Ricardo", 50, "Weapons disrtibution", 250),
                        leo
                };
        //Override методы выполняют Specialization
        for (int i = 0; i < group.length; i++) {
            System.out.println(group[i]);
        }

        File file = new File("group.txt"); //создание файла с именем group
        System.out.println(file.getAbsolutePath());
        file.delete();
        file.createNewFile();

       // if (file.createNewFile()) //тут уже создается физический файл
       // {
      //      System.out.println("File created");
     //   }
     //   else
     //   {
     //       System.out.println("File exists");
    //    }
        //записать что-то в файл
        FileWriter writer = new FileWriter(file);

        for(int i =0; i < group.length; i++)
        {
            writer.write(group[i].toString() + "\n");
          //  writer.write(group[i].toString());
          //  writer.write ("\n");
        }
        writer.close(); //потоки обязательно нужно закрывать */
        //https://www.geeksforgeeks.org/file-handling-java-using-filewriter-filereader/
        // объявление переменной
        int ch;
        // проверка, существует файл или нет
        FileReader fr=null;
        try
        {
            fr = new FileReader("DZ28.txt");
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("Файл не найден");
        }
        // читать из FileReader до конца файла
        while ((ch=fr.read())!=-1)
            System.out.print((char)ch);
        // закрыть файл
        fr.close();
    }
}