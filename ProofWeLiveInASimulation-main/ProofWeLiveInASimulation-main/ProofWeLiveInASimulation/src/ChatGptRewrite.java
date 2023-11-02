import java.util.ArrayList;
import java.util.Random;

public class ChatGptRewrite {

    public static void main(String[] args) {
        ArrayList<Person> population = new ArrayList<>();
        Random rand = new Random();
        int year = 0;
        int peopleBorn = 0;
        int peopleDead = 0;
        long worldMoney = 0;

        for (int s = 0; s <= 1; s++) {
            Person person = new Person(year);
            population.add(person);
        }

        System.out.println("Starting State:");
        for (Person value : population) {
            System.out.println(value.name + " age: " + value.age + " sex: " + value.sex + " year born: " + value.yearBorn);
        }

        do {
            worldMoney = 0;
            int populationSize = population.size();
            for (int i = 0; i < populationSize; i++) {
                int thisPerson = rand.nextInt(populationSize);
                int thisPerson2 = rand.nextInt(populationSize);

                Person person1 = population.get(thisPerson);
                Person person2 = population.get(thisPerson2);

                if (person1.haveAChild(person2.age, person2.sex, person2.pregnant)) {
                    person1.becomePregnant();
                    person2.becomePregnant();
                    Person newPerson = new Person(year);
                    population.add(newPerson);
                    peopleBorn++;
                }

                if (person1.chanceOfDeath(year) || (person1.getMoney() < 0 && person1.getAge() >= 18)) {
                    peopleDead++;
                    population.remove(i);
                    i--;
                    populationSize--;
                }
            }

            for (Person person : population) {
                person.haveABirthday();

                if (person.getAge() < 18) {
                    int range = 10000;
                    person.getPaid(rand.nextInt(range));
                } else {
                    int range = 50001 - 12570 + 1;
                    person.getPaid(rand.nextInt(range));
                    person.payBills();
                }

                worldMoney += person.getMoney();

                if (person.sex == 'F') {
                    person.giveBirth();
                }
            }

            if (year % 50 == 0) {
                System.out.println();
                System.out.println("Year: " + year);
                System.out.println("People Born: " + peopleBorn);
                System.out.println("People Dead: " + peopleDead);
                System.out.println("Total Population: " + population.size());
                System.out.println("World Money: " + worldMoney);
            }

            year++;
            peopleBorn = 0;
            peopleDead = 0;
        } while (population.size() != 0);

        System.out.println();
        System.out.println("Year: " + year);
        System.out.println("People Born: " + peopleBorn);
        System.out.println("People Dead: " + peopleDead);
        System.out.println("Total Population: " + population.size());
    }
}
