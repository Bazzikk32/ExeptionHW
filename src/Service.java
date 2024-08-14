import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Service {

    Person person = new Person();
    String name;
    String fatherName;
    String family;
    String birtDay;
    String phoneNumberStr;
    String gender;

    public void SplitDataFromPerson (String inputStr){
       String [] data = person.getInputDataFromUser().split(" ");
       if(data.length!=6) {
           throw new RuntimeException("Вы ввели некорректное количество данных!");
       }
           name = data[1];
           fatherName = data[2];
           family = data[0];
           birtDay = data[3];
           phoneNumberStr = data[4];
           gender = data[5];
    }

    public void checkerFormat(){
        checkIfString(name);
        checkIfString(family);
        checkIfString(fatherName);
        checkIfNumber(phoneNumberStr);
        checkGender(gender);
        try {
            isValidDate(birtDay);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void setPerson(String inputData) {
        person.setInputDataFromUser(inputData);
    }

     public void saveToFile(){
        String fileName = family + ".txt";
        try(FileWriter fw = new FileWriter(fileName, true)){
            fw.write(buildTheLine());
            fw.flush();
            System.out.println("\n");
            System.out.println("Данные записаны в файл успешно!");
        } catch (IOException e) {
            e.printStackTrace();
        }

     }

     public Boolean checkIfString(String checkIfString) {
         if (checkIfString.matches("[a-zA-Zа-яА-Я]*")) {
             return true;
         } else {
             throw new RuntimeException("Вы ввели некорректные данные ФИО!");
         }

     }

    public Boolean checkIfNumber(String checkIfNumber) {
        if (checkIfNumber.matches("[0-9]*")) {
            return true;
        } else {
            throw new RuntimeException("Вы ввели некорректный номер телефона!");
        }

    }

    public Boolean checkGender(String checkGender) {
        if (checkGender.matches("[fm]*")) {
            return true;
        } else {
            throw new RuntimeException("Вы ввели некорректный пол!");
        }

    }

    public static boolean isValidDate(String birtDay)
    {
        //String regex = "^(1[0-2]|0[1-9]).(3[01]" + "|[12][0-9]|0[1-9]).[0-9]{4}$";
        String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)birtDay);
        if (matcher.matches()){
            return  true;
        } else {
            throw new RuntimeException("Вы ввели дату в некорректном формате");
        }

    }


    public String buildTheLine() {
        StringBuilder sb = new StringBuilder();
        sb.append("Фамилия: <");
        sb.append(name);
        sb.append("> Имя: <");
        sb.append(fatherName);
        sb.append("> Отчество: <");
        sb.append(family);
        sb.append("> Дата рождения: <");
        sb.append(birtDay);
        sb.append("> Номер телефона: <");
        sb.append(phoneNumberStr);
        sb.append("> Пол: <");
        sb.append(gender);
        sb.append("> \n");
        return sb.toString();
    }

}
