import java.util.Random;

public class Person {

    String name;
    char sex;
    int age;
    int yearBorn;
    boolean pregnant;

    Person(int yearBorn){
        chooseSex();
        chooseName();
        this.age = 0;
        this.yearBorn = yearBorn;
        if(this.sex == 'M'){
            pregnant = true;
        }
    }

    public void haveABirthday(){
        age += 1;
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

    public boolean chanceOfDeath(){
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

        if(percentage <= deathPercentage){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean haveAChild(int partnerAge, char partnerSex, boolean isPregnant){
        int chanceOfConservation;

        if(this.sex != partnerSex) {
            if(this.pregnant == false || isPregnant == false) {//Multiple children check
                if (this.age >= 18 && partnerAge >= 18) {
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

    public void becomePregnant(){
        if(this.sex == 'F'){
            this.pregnant = true;
        }
    }

    public void giveBirth(){
        this.pregnant = false;
    }

}
