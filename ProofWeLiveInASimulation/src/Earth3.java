import java.util.ArrayList;
import java.util.Random;

public class Earth3 {
    
    public static void main(String[] args){

        int thisPerson, thisPerson2;

        ArrayList<Person> population = new ArrayList<>();
        int year = 0;
        int peopleBorn = 0;
        int peopleDead = 0;

        for(int s = 0; s <= 1; s++){
            Person person = new Person(year);
            population.add(person);

        }

        System.out.println("Starting State:");
        for(int x = 0; x < population.size(); x++){
            System.out.println(population.get(x).name + " age: " + population.get(x).age + " sex: " + population.get(x).sex + " year born: " + population.get(x).yearBorn);
        }


        do{

            System.out.println();
            System.out.println("Year: " + year);


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

                if(population.get(i).chanceOfDeath() == true){
                    peopleDead ++;

                    population.remove(i);

                }


            }

            for(int i = 0; i < population.size(); i++){
                if(i < population.size()) {
                    //System.out.println(population.get(i).name + " age: " + population.get(i).age + " sex: " + population.get(i).sex + " year born: " + population.get(i).yearBorn);
                    population.get(i).haveABirthday();

                    if(population.get(i).sex == 'F'){
                        population.get(i).giveBirth();
                    }
                }
            }
            System.out.println("People Born: " + peopleBorn);
            System.out.println("People Dead: " + peopleDead);
            System.out.println("Total Population: " + population.size());
//            try{
//                Thread.sleep(1000);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
            year++;
            peopleBorn = 0;
            peopleDead = 0;
        } while (population.size() != 0);


        
    }
    
}
