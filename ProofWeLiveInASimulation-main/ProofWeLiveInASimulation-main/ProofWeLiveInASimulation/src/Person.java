import java.util.Random;

/**
 * Person Class that represents a person in on the earth.
 * Holds all the methods that a person will need throughout their lifetime.
 * @author George Cook
 */
public class Person {

    private String name;
    private char sex;
    private int age;
    private int yearBorn;
    private boolean pregnant;
    private int deathYear = -1;
    private int money;
    private int numberOfChildren;
    private int lastChild;

    /**
     * Constructor for Person class that sudo randomly assigns Sex.
     * @param yearBorn
     */
    Person(int yearBorn) {
        chooseSex();
        chooseName();
        this.age = 0;
        this.yearBorn = yearBorn;
        if (this.sex == 'M') {
            pregnant = true;
        }
        this.money = 26063;
        this.lastChild = 0;
        this.numberOfChildren = 0;
    }

    /**
     * Constructor for Person class that allows you to set the Sex.
     * @param yearBorn
     * @param sex
     */
    Person(int yearBorn, char sex) {
        this.sex = sex;
        chooseName();
        this.age = 0;
        this.yearBorn = yearBorn;
        if (this.sex == 'M') {
            pregnant = true;
        }
        this.money = 26063;
        this.lastChild = 0;
        this.numberOfChildren = 0;
    }

    /**
     * Getter that returns the Name of the Person.
     * @return name variable that represents the person's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter that allows the changing of the name of the person.
     * @param name The new String value that will be assigned to the name variable.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter that allows the changing of the sex of the person.
     * @param sex The new Char value that will be assigned to the sex variable.
     */
    public void setSex(char sex) {
        this.sex = sex;
    }

    /**
     * Setter that allows the changing of the age of the person.
     * @param age The new int value that will be assigned to the age variable.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter that returns the Year that the person has been born.
     * @return yearBorn variable that represents the year the person was born.
     */
    public int getYearBorn() {
        return yearBorn;
    }

    /**
     * Setter that allows the changing of the year the person was born.
     * @param yearBorn The new int value that will be assigned to the yearBorn variable.
     */
    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }

    /**
     * Getter that return the boolean value of if the person is pregnant or not.
     * @return pregnant variable that represents in the person is pregnant.
     */
    public boolean isPregnant() {
        return pregnant;
    }

    /**
     * Setter that allows the changing of if the person is pregnant or not.
     * @param pregnant The new boolean value that will be assigned to the pregnant variable.
     */
    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    /**
     * Getter that returns the Year that the person has is going to die.
     * @return deathYear variable that represents the year the person will die.
     */
    public int getDeathYear() {
        return deathYear;
    }

    /**
     * Setter that allows the changing of the year the person will die.
     * @param deathYear The new int value that will be assigned to the deathYear variable.
     */
    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    /**
     * Setter that allows the changing of the amount of money the person has.
     * @param money The new int value that will be assigned to the money variable.
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Getter that returns the number of children the person has.
     * @return numberOfChildren variable that represents the number of children that the person has.
     */
    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    /**
     * Setter that allows the changing of the number of children a person has had.
     * @param numberOfChildren The new int value that will be assigned to the numberOfChildren variable.
     */
    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    /**
     * Getter that returns the year that the person last had a child.
     * @return lastChild variable that represents the year that the person last had a child.
     */
    public int getLastChild() {
        return lastChild;
    }

    /**
     * Setter that allows the changing of the year that the person last had a child.
     * @param lastChild The new int value that will be assigned to the lastChild variable.
     */
    public void setLastChild(int lastChild) {
        this.lastChild = lastChild;
    }

    /**
     * Getter that returns the age of the person.
     * @return age variable that represents the age of the person.
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Getter that returns the sex of the person.
     * @return sex variable that represents the sex of the person.
     */
    public char getSex() {
        return this.sex;
    }

    /**
     * Getter that returns the amount of money that the person has.
     * @return money variable that represents the amount of money that the person has.
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Method that pays the person their yearly salary.
     * @param salary The int value that represents the persons yearly salary that is added to their total money.
     */
    public void getPaid(int salary) {
        this.money += salary;
    }

    /**
     * Method that takes money off of the persons total money.
     * Represents them paying their total out goings for the year.
     */
    public void payBills() {
        this.money -= 26062 / 2;
    }

    /**
     * Method that increases the persons age by one year.
     */
    public void haveABirthday() {
        age += 1;
    }

    /**
     * Method that chooses the name of the person based on their sex.
     */
    private void chooseName() {
        int choice;

        Random rand = new Random();
        choice = rand.nextInt(3);
        if (this.sex == 'M') {
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
        } else if (this.sex == 'F') {
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

    /**
     * Method that sudo randomly sets the person's sex.
     */
    private void chooseSex() {
        int choice;

        Random rand = new Random();
        choice = rand.nextInt(2);
        switch (choice) {
            case 0:
                this.sex = 'M';
                break;
            case 1:
                this.sex = 'F';
                break;
        }
    }

    /**
     * Method that calculates if the person is going to die based on current age.
     * Based on real world data.
     * @param currentYear The int value that represents the current year.
     * @return boolean value that says whether a person is going to die this year.
     */
    public boolean chanceOfDeath(int currentYear) {
        double death = 0, deathPercentage, percentage;

        if (this.sex == 'M') {
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
        } else if (this.sex == 'F') {
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
        if (percentage <= deathPercentage || deathYear == currentYear) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Method that calculates if the person is going to have a child.
     * Based on real world data
     * @param partnerAge The int value that represents the age of the current partner
     * @param partnerSex The char value that represents the sex of the current partner
     * @param isPregnant The boolean value that represents the pregnancy state of the current partner
     * @param partnerNumberOfChildren The int value that represents the number of children of the current partner
     * @param year The int value that represents the current year.
     * @param partnerLastChild The int value that represents the year of the last child of the current partner
     * @return boolean value that says whether a person is going to have a child this year.
     */
    public boolean haveAChild(int partnerAge, char partnerSex, boolean isPregnant, int partnerNumberOfChildren, int year, int partnerLastChild) {
        int chanceOfConservation;

        if (this.sex != partnerSex) {
            if ((this.pregnant == false || isPregnant == false) && /*(this.numberOfChildren <=3 && partnerNumberOfChildren <=3) &&*/ (this.lastChild != year && partnerLastChild != year)) {//Multiple children check
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

    /**
     * Method that changes the state of pregnant to True.
     * And then sets the year that the person last had a child to the current year.
     * @param year The int value that represents the current year.
     */
    public void becomePregnant(int year) {
        //lastChild = year;
        if (this.sex == 'F') {
            this.pregnant = true;
            lastChild = year;
        }
    }

    /**
     * Method that changes the state of pregnant to false.
     * And then increases the number of children that the person has had by one.
     */
    public void giveBirth() {
        this.pregnant = false;
        numberOfChildren = numberOfChildren + 1;
    }

    /**
     * Method that calculates whether a person is going to die of terminal cancer next year.
     * And sets the deathYear to one plus the currentYear.
     * @param currentYear The int value that represents the current year.
     */
    public void chanceOfFatalCancer(int currentYear) {
        double death, deathPercentage, percentage;

        Random rand = new Random();

        if (this.sex == 'M') {
            death = 1.81;
        } else {
            death = 1.52;
        }

        percentage = rand.nextDouble();
        deathPercentage = (death / 100);
        if ((percentage <= deathPercentage) && (this.age >= 18)) {
            this.deathYear = currentYear + 1;
        } else if ((percentage <= (deathPercentage / 2)) && (this.age < 18)) {
            this.deathYear = currentYear + 1;
        }


    }

}