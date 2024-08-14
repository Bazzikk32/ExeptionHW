import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;
    private Service service;
    private Checker checker;
    private boolean work = true;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        service = new Service();
        checker = new Checker();
        work = true;
    }

    public void Start(){
        while (work){
            System.out.println("\n");
            System.out.println("Добрый день, приложение запущено...\n");
            System.out.println("Введите следующие данные разделяя их пробелом: \n" + "фамилия, имя, отчество\n" +
                    "дата _ рождения формата dd.mm.yyyy\n" +
                    "номер _ телефона - целое беззнаковое число\n" +
                    "пол - символ латиницей f или m\n");
            String inputStr = scanner.nextLine();
            service.setPerson(inputStr);
            service.SplitDataFromPerson(inputStr);
            checker.checkerFormats();

            service.saveToFile();
            finish();
        }
    }

    public void finish() {
        System.out.println("See you again...");
        work = false;
    }
}
