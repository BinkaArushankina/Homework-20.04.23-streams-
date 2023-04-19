package Homework;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Person jack= new Person("Jack",15,"street1");
        Person john= new Person("John",16,"street2");
        Person jill= new Person("Jill",17,"street3");
        Person johny= new Person("Johny",18,"street4");
        Person jacky= new Person("Jacky",19,"street5");
        Person jilly= new Person("Jilly",19,"street6");
        List<Person> list = List.of(jack,john,jill,johny,jacky,jilly);
//Задача1
//Используя стримы, написать метод, принимающий список персонов и возвращающий мапу, где возраст является ключом,
// а список персонов этого возраста значением
        System.out.println(main.keyIntValueList(list)); //16=[John], 17=[Jill], 18=[Johny], 19=[Jacky, Jilly], 15=[Jack]

//Задача2
//Используя тот же класс Person,написать метод,принимающий список персонов и возвращающий общий возраст тех,кто старше 17 лет.
        System.out.println(main.summingInt(list)); //56

//Задача 3
//Написать метод, принимающий список персонов и возвращающий имена тех, кто является совершеннолетним в Германии старше 18 лет.
        System.out.println(main.returnNames(list)); //In Germany Jacky and Jilly are of legal age
    }
    //1)
    public Map<Integer,List<Person>> keyIntValueList (List<Person> people){
        return people.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.toList()));
    }

    //2)
    public int summingInt(List<Person> people){
        return people.stream().filter(p->p.getAge()>17).collect(Collectors.summingInt(Person::getAge));
    }

    //3)
    public String returnNames(List<Person> people){
        return people.stream().filter(p -> p.getAge() > 18).collect(Collectors.joining(" and ","In Germany "," are of legal age.")).toString();
    }



}
