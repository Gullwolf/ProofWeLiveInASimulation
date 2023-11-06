//import java.math.BigInteger;

import java.util.ArrayList;
import java.util.Random;

public class Earth5 {

    public static void main(String[] args) {

        ArrayList<Person> population = new ArrayList<>();
        ArrayList<Person> itemsToRemove = new ArrayList<>();
        ArrayList<Person> itemsToAdd = new ArrayList<>();
        Random rand = new Random();
        int year = 0;
        int peopleBorn = 0;
        int peopleDead = 0;
        int startingPopulationSize;
//        BigInteger worldMoney =  BigInteger.valueOf(0);

        for (int s = 0; s <= 1; s++) {
            Person person;
            if (s == 0) {
                person = new Person(year, 'M');
            } else {
                person = new Person(year, 'F');
            }
            population.add(person);


        }

        System.out.println("Starting State:");
        for (Person value : population) {
            System.out.println(value.getName() + " age: " + value.getAge() + " sex: " + value.getSex() + " year born: " + value.getYearBorn());
        }

        startingPopulationSize = population.size();

        do {

            for (Person person : population) {

                Person person2 = population.get(rand.nextInt(startingPopulationSize));

                if (person.haveAChild(person2.getAge(), person2.getSex(), person2.isPregnant(), person2.getNumberOfChildren(), year, person2.getLastChild())) {
                    person.becomePregnant(year);
                    person2.becomePregnant(year);
                    Person child = new Person(year);
                    itemsToAdd.add(child);
                    peopleBorn++;
                }

                person.chanceOfFatalCancer(year);

                if (person.chanceOfDeath(year) || (person.getMoney() < 0 && person.getAge() >= 18)) {
                    peopleDead++;
                    itemsToRemove.add(person);

                }

                if (person.getAge() < 18) {
                    int range = (10000);
                    person.getPaid(rand.nextInt(range));
                } else {
                    int range = 50001 - 12570 + 1;
                    person.getPaid(rand.nextInt(range));
                    person.payBills();
                }
                person.haveABirthday();

                if (person.sex == 'F') {
                    person.giveBirth();
                }
/*
                if(year % 50 == 0){
                    worldMoney = worldMoney.add(BigInteger.valueOf(person.getMoney()));
                }
*/
            }

            population.removeAll(itemsToRemove);
            population.addAll(itemsToAdd);

            if (year % 50 == 0) {
//                BigInteger mph = worldMoney.divide(BigInteger.valueOf(population.size()));
                System.out.printf("\nYear: %d\nPeople Born: %d\nPeople Dead: %d\nTotal Population: %d%n", year, peopleBorn, peopleDead, population.size());
/*
                System.out.println("World Money: " + worldMoney);
                System.out.println("Average money per head: " + mph);
*/
            }

            year++;
            peopleBorn = 0;
            peopleDead = 0;
            itemsToRemove.clear();
            itemsToAdd.clear();
            startingPopulationSize = population.size();
//            worldMoney = BigInteger.valueOf(0);

        } while (population.size() != 0);

        System.out.printf("\nYear: %d\nPeople Born: %d\nPeople Dead: %d\nTotal Population: %d%n", year, peopleBorn, peopleDead, population.size());


    }

}
