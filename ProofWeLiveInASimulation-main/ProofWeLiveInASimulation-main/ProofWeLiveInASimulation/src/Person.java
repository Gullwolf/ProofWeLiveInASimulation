import java.util.Random;

public class Person {

    String name;
    char sex;
    int age;
    int yearBorn;
    boolean pregnant;

    int deathYear = -1;

    int money;

    int numberOfChildren;

    int lastChild;

    Person(int yearBorn){
        chooseSex();
        chooseName();
        this.age = 0;
        this.yearBorn = yearBorn;
        if(this.sex == 'M'){
            pregnant = true;
        }
        this.money = 26063;
        this.lastChild = 0;
        this.numberOfChildren = 0;
    }

    public void haveABirthday(){
        age += 1;
    }

    public int getAge(){
        return age;
    }
    public int getMoney(){
        return money;
    }

    public void getPaid(int salary){
        this.money += salary;
    }

    public void payBills(){
        this.money -= 26062/2;
    }



    private void chooseName(){
        int choice;

        Random rand = new Random();
        choice = rand.nextInt(3);
        //System.out.println(choice);

        if(this.sex == 'M') {
            switch (choice) {
                case 0:
                    this.name = "Paul";
                    break;
                case 1:
                    this.name = "Tom";
                    break;
                case 2:
                    this.name = "Pardeep";
                    break;

            }
        }
        else if(this.sex == 'F'){
            switch (choice) {
                case 0:
                    this.name = "Lucy";
                    break;
                case 1:
                    this.name = "Monika";
                    break;
                case 2:
                    this.name = "Emily";
                    break;

            }
        }
    }

    private void chooseSex(){
        int choice;

        Random rand = new Random();
        choice = rand.nextInt(2);

        switch (choice){
            case 0:
                this.sex = 'M';
                break;
            case 1:
                this.sex = 'F';
                break;
        }
    }

    public boolean chanceOfDeath(int currentYear){
        double death = 0, deathPercentage, percentage;

        if(this.sex == 'M') {
            if (age < 1) {
                death = 0.56;
            } else if (age >= 1 && age <= 4) {
                death = 0.023;
            } else if (age >= 5 && age <= 14) {
                death = 0.012;
            } else if (age >= 15 && age <= 24) {
                death = 0.052;
            } else if (age >= 25 && age <= 34) {
                death = 0.082;
            } else if (age >= 35 && age <= 44) {
                death = 0.15;
            } else if (age >= 45 && age <= 54) {
                death = 0.36;
            } else if (age >= 55 && age <= 64) {
                death = 0.89;
            } else if (age >= 65 && age <= 74) {
                death = 2.4;
            } else if (age >= 75 && age <= 84) {
                death = 6.7;
            } else if (age >= 85) {
                death = 17;
            }
        }
        else if(this.sex == 'F'){
            if (age < 1) {
                death = 0.44;
            } else if (age >= 1 && age <= 4) {
                death = 0.017;
            } else if (age >= 5 && age <= 14) {
                death = 0.0096;
            } else if (age >= 15 && age <= 24) {
                death = 0.024;
            } else if (age >= 25 && age <= 34) {
                death = 0.040;
            } else if (age >= 35 && age <= 44) {
                death = 0.090;
            } else if (age >= 45 && age <= 54) {
                death = 0.24;
            } else if (age >= 55 && age <= 64) {
                death = 0.56;
            } else if (age >= 65 && age <= 74) {
                death = 1.5;
            } else if (age >= 75 && age <= 84) {
                death = 4.8;
            } else if (age >= 85) {
                death = 14;
            }
        }

        Random rand = new Random();
        percentage = rand.nextDouble();
        deathPercentage = (death / 100);

        if(percentage <= deathPercentage || deathYear == currentYear){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean haveAChild(int partnerAge, char partnerSex, boolean isPregnant, int partnerNumberOfChildren, int year, int partnerLastChild){
        int chanceOfConservation;

        if(this.sex != partnerSex) {
            if((this.pregnant == false || isPregnant == false) && /*(this.numberOfChildren <=3 && partnerNumberOfChildren <=3) &&*/ (this.lastChild != year && partnerLastChild != year)) {//Multiple children check
                if (this.age >= 18 && this.age <= 50 && partnerAge >= 18 && partnerAge <= 50) {
                    Random rand = new Random();
                    chanceOfConservation = rand.nextInt(100);
                    if (chanceOfConservation <= 41) {
                        return true;
                    } else {
                        return false;
                    }

                }
            }
        }
        return false;
    }

    public void becomePregnant(int year){
        //lastChild = year;
        if(this.sex == 'F'){
            this.pregnant = true;
            lastChild = year;
        }
    }

    public void giveBirth(){
        this.pregnant = false;
        numberOfChildren = numberOfChildren + 1;
    }

    public void chanceOfFatalCancer(int currentYear){
        double death, deathPercentage, percentage;

        Random rand = new Random();

        if(this.sex == 'M'){
            death = 1.81;
        }else{
            death = 1.52;
        }

        percentage = rand.nextDouble();
        deathPercentage = (death / 100);

        if((percentage <= deathPercentage) && (this.age >= 18)){
            this.deathYear = currentYear + 1;
        }else if ((percentage <= (deathPercentage/2)) && (this.age < 18)){
            this.deathYear = currentYear + 1;
        }


    }

}
