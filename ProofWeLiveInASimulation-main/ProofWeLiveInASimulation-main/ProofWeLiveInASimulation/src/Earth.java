import java.util.Random;

public class Earth {
    
    public static void main(String[] args){

        int thisPerson, thisPerson2;
        
        Person[] population = new Person[100000000];
        int totalPopulation = 0;
        int year = 0;
        int peopleBorn = 0;
        int peopleDead = 0;

        for(int s = 0; s <= 1; s++){
            Person person = new Person(year);
            population[s] = person;
            totalPopulation ++;

        }

        System.out.println("Starting State:");
        for(int x = 0; x <= totalPopulation - 1; x++){
            System.out.println(population[x].name + " age: " + population[x].age + " sex: " + population[x].sex + " year born: " + population[x].yearBorn);
        }


        do{

            System.out.println();
            System.out.println("Year: " + year);


            for(int i = 0; i < totalPopulation; i++) { //Multiple Children a year
                Random rand = new Random();
                thisPerson = rand.nextInt(totalPopulation);
                //System.out.println(thisPerson);

                thisPerson2 = rand.nextInt(totalPopulation);
                //System.out.println(thisPerson2);
                if (population[thisPerson].haveAChild(population[thisPerson2].age, population[thisPerson2].sex, population[thisPerson2].pregnant)) {
                    population[thisPerson].becomePregnant();
                    population[thisPerson2].becomePregnant();
                    Person person = new Person(year);
                    population[totalPopulation] = person;
                    peopleBorn ++;
                    totalPopulation += 1;
                }
            }

            for(int i = 0; i < totalPopulation; i++){
                if(population[i].chanceOfDeath() == true){
                    peopleDead ++;
                    if(i == totalPopulation-1){
                        population[i] = null;
                        totalPopulation -= 1;
                    }
                    else{
                        for(int j = i; j < totalPopulation - 1; j++){
                            population[j] = population[j+1];

                        }
                        totalPopulation -= 1;
                    }
                }
                if(i <= totalPopulation -1) {
                    //System.out.println(population[i].name + " age: " + population[i].age + " sex: " + population[i].sex + " year born: " + population[i].yearBorn);
                    population[i].haveABirthday();

                    if(population[i].sex == 'F'){
                        population[i].giveBirth();
                    }
                }
            }
            System.out.println("People Born: " + peopleBorn);
            System.out.println("People Dead: " + peopleDead);
            System.out.println("Total Population: " + totalPopulation);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            year++;
            peopleBorn = 0;
            peopleDead = 0;
        } while (totalPopulation != 0);


        
    }
    
}
