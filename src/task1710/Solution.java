package task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    private static CheckData checkData;
    public static void main(String[] args) throws ParseException {
        System.out.println("Start type your command:");
        ReaderThread t1 = new ReaderThread();
        t1.start();


    }


    public static void createHuman(String name,String sex, Date date){
        Person person = null;
        if (sex.equals("м")){
            person = Person.createMale(name,date);
            allPeople.add(person);
        }
        else if (sex.equals("ж")){
            person = Person.createFemale(name,date);
            allPeople.add(person);
        }
        System.out.println(allPeople.indexOf(person));

    }
    public static void updateHuman(int id,String name,String sex, Date date){
        Person person = allPeople.get(id);
        person.setBirthDay(date);
        if (sex.equals("м"))
            person.setSex(Sex.MALE);
        else if (sex.equals("ж"))
            person.setSex(Sex.FEMALE);
        person.setName(name);
        allPeople.set(id,person);
    }
    public static void deleteHuman(int id){
        Person person = allPeople.get(id);
        person.setSex(null);
        person.setName(null);
        person.setBirthDay(null);

    }
    public static void indicateHuman(int id){
        Person person = allPeople.get(id);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY",Locale.ENGLISH);
        String _date = sdf.format(person.getBirthDay());

        String sex = null;
        if (person.getSex().equals(Sex.MALE))
            sex = "м";
        else if (person.getSex().equals(Sex.FEMALE))
            sex = "ж";

        System.out.println(String.format("%s %s %s",person.getName(),sex,_date));


    }
}
