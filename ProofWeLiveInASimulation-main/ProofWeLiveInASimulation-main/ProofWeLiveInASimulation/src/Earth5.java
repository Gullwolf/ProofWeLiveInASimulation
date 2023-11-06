import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class Earth5 {
    
    public static void main(String[] args){

        ArrayList<Person> population = new ArrayList<>();
        ArrayList<Person> itemsToRemove = new ArrayList<>();
        ArrayList<Person> itemsToAdd = new ArrayList<>();
        Random rand = new Random();
        int year = 0;
        int peopleBorn = 0;
        int peopleDead = 0;
        int startingPopulationSize;
        BigInteger worldMoney =  BigInteger.valueOf(0);

        for(int s = 0; s <= 1; s++){
            Person person = new Person(year);
            population.add(person);

        }

        System.out.println("Starting State:");
        for (Person value : population) {
            System.out.println(value.name + " age: " + value.age + " sex: " + value.sex + " year born: " + value.yearBorn);
        }

        startingPopulationSize = population.size();

        do{

            for (Person person : population) {

                Person person2 = population.get(rand.nextInt(startingPopulationSize));

                if (person.haveAChild(person2.age, person2.sex, person2.pregnant, person2.numberOfChildren, year, person2.lastChild)) {
                    person.becomePregnant(year);
                    person2.becomePregnant(year);
                    Person child = new Person(year);
                    itemsToAdd.add(child);
                    peopleBorn ++;
                }

                person.chanceOfFatalCancer(year);

                if(person.chanceOfDeath(year) || (person.getMoney() < 0 && person.getAge() >= 18)){
                    peopleDead ++;
                    itemsToRemove.add(person);

                }
                person.haveABirthday();
                if (person.getAge() < 18) {
                    int range = (10000);
                    person.getPaid(rand.nextInt(range));
                } else {
                    int range = 50001 - 12570 + 1;
                    person.getPaid(rand.nextInt(range));
                    person.payBills();
                }

                worldMoney = worldMoney.add(BigInteger.valueOf(person.getMoney()));

                if (person.sex == 'F') {
                    person.giveBirth();
                }
            }

            population.removeAll(itemsToRemove);
            population.addAll(itemsToAdd);

            if(year % 50 == 0){
                BigInteger mph = worldMoney.divide(BigInteger.valueOf(population.size()));
                System.out.println();
                System.out.println("Year: " + year);
                System.out.println("People Born: " + peopleBorn);
                System.out.println("People Dead: " + peopleDead);
                System.out.println("Total Population: " + population.size());
                System.out.println("World Money: " + worldMoney);
                System.out.println("Average money per head: " + mph);
            }

            year++;
            peopleBorn = 0;
            peopleDead = 0;
            itemsToRemove.clear();
            itemsToAdd.clear();
            startingPopulationSize = population.size();
            worldMoney = BigInteger.valueOf(0);

        } while (population.size() != 0);

        System.out.println();
        System.out.println("Year: " + year);
        System.out.println("People Born: " + peopleBorn);
        System.out.println("People Dead: " + peopleDead);
        System.out.println("Total Population: " + population.size());

        
    }
    
}
