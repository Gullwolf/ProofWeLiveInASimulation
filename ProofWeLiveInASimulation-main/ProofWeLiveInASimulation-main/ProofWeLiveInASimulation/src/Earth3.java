import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class Earth3 {
    
    public static void main(String[] args){

        int thisPerson, thisPerson2;

        ArrayList<Person> population = new ArrayList<>();
        //LinkedList<Person> population = new LinkedList<Person>();
        int year = 0;
        int peopleBorn = 0;
        int peopleDead = 0;
        BigInteger worldMoney = BigInteger.valueOf(0);

        for(int s = 0; s <= 1; s++){
            Person person = new Person(year);
            population.add(person);

        }

        System.out.println("Starting State:");
        for (Person value : population) {
            System.out.println(value.name + " age: " + value.age + " sex: " + value.sex + " year born: " + value.yearBorn);
        }


        do{
            //worldMoney = BigInteger.valueOf(0);
            for(int i = 0; i < population.size(); i++) { //Multiple Children a year
                Random rand = new Random();
                thisPerson = rand.nextInt(population.size());
                //System.out.println(thisPerson);

                thisPerson2 = rand.nextInt(population.size());
                //System.out.println(thisPerson2);
                if (population.get(thisPerson).haveAChild(population.get(thisPerson2).age, population.get(thisPerson2).sex, population.get(thisPerson2).pregnant)) {
                    population.get(thisPerson).becomePregnant();
                    population.get(thisPerson2).becomePregnant();
                    Person person = new Person(year);
                    population.add(person);
                    peopleBorn ++;
                }

                if(population.get(i).chanceOfDeath() || (population.get(i).getMoney() < 0 && population.get(i).getAge() >= 18)){
                    peopleDead ++;

                    population.remove(i);

                }


            }

            for (Person person : population) {
                //System.out.println(population.get(i).name + " age: " + population.get(i).age + " sex: " + population.get(i).sex + " year born: " + population.get(i).yearBorn);
                person.haveABirthday();
                Random rand = new Random();
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
            if(year % 10 == 0){
                System.out.println();
                System.out.println("Year: " + year);
                System.out.println("People Born: " + peopleBorn);
                System.out.println("People Dead: " + peopleDead);
                System.out.println("Total Population: " + population.size());
                System.out.println("World Money: " + worldMoney);
            }
//            try{
//                Thread.sleep(1000);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
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
