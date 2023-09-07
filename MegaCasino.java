/** MegaCasino
 *
 * Gives user four choices of casino games
 * that user can choose from. They bet money in each
 * game and if they win, they win money and if they lose the game,
 * they lose the money

 *@authorOliviaMurray
 *@date 30 03 2023
 */


//import scanner
import java.util.Scanner;

//main class
public class MegaCasino {
    //write methods


    /**
     * Craps Game method
     *
     * @param name Name of user
     * @param money Money total
     * @param bet2 Users money bet
     * */
    public static int playCraps(String name, int money, int bet2) {
            //initialize variables
            int playerBet = 0;
            int Dice1 = 0;
            int Dice2 = 0;
            int totalRoll=0;
            int point = 0;
            int diceRolls=0;




            //call diceRolls method to roll dice
            diceRolls = rollDice(Dice1, Dice2, totalRoll);

            //if the roll is 7 or 11, then add bet to money total
            if (diceRolls == 7 || diceRolls == 11) {
                money += bet2;

            //if the roll is 2 or 3 or 12, subtract bet from money total
            } else if (diceRolls == 2 || diceRolls == 3 || diceRolls == 12) {
                money -= bet2;



            }//else if


            //otherwise set the roll to point
            else {
                point=diceRolls;
                //tell user they need to keep rolling until they get point, or they lose by getting 7 or 11
                System.out.print("\n"+name+",you now need to keep rolling!\n");
                System.out.println("POINT= "+point);
                System.out.print("If you roll your point again, you win,");
                System.out.print(" BUT... if you roll 7 or 11, you LOSE\n");


                while (true) {
                    //call roll dice method
                    int roll = rollDice(Dice1, Dice2, totalRoll);
                    //if user rolls 7 or 11, they lose they money
                    if (roll == 7 || roll == 11) {
                        System.out.println("");
                        System.out.print("!LOSER!");
                        money -= bet2;
                        break;

                    //otherwise they win the money
                    }else if (roll == point) {
                        System.out.println("");
                        System.out.print("!WINNER!\n");
                        money += bet2;
                        break;
                    }//else if


                }//while true

            }//else

        //money is returned
        return money;
    }//playCraps(String name, int money, int bet2)


    /**
     * Dice rolling method
     *
     * @param Dice1 First dice roll
     * @param Dice2 Second dice roll
     * @param totalRoll sum of rolled dice
     * */
    public static int rollDice(int Dice1,int Dice2, int totalRoll){
        //ask user to roll two dice
        System.out.println("");
        System.out.print("Press ENTER to roll dice 1:\n");
        input.nextLine();
        //random number is generated between 1-6
        Dice1=(int)(Math.random()*6)+1;
        System.out.printf("ROLLED: %d %n", Dice1);

        System.out.println("");
        System.out.print("Press ENTER to roll dice 2:");
        input.nextLine();
        Dice2=(int)(Math.random()*6)+1;
        System.out.printf("ROLLED: %d %n", Dice2);
        System.out.println("");

        //dice total is returned
        totalRoll=(Dice1+Dice2);
        return totalRoll;

    }//rollDice (int Dice1, int Dice2, int totalRoll)


    /**
     * Heads or Tails method
     *
     *
     * @param money Money total
     * @param bet1 Users money bet
     * @param name name of user
     * */
    public static int HeadsOrTails( int money, int bet1, String name){
        //initialize variables
        int headsOrTails=0;
        String coinFlip;
        int HorT=0;

        //error trap so user can only enter 1 or 2
        do {
            System.out.println();
            System.out.print(name+", Heads(1) or tails(2)?: ");
            HorT = input.nextInt();
            if (HorT==1||HorT==2){
                break;
            }else{
                System.out.print("Invalid! Please enter heads(1) or tails(2)");
                System.out.println("");
            }

        }while(true); //end of do

        //ask user to flip coin
        System.out.print(name+", press ENTER to flip coin: \n");
        input.nextLine();
        //generate random number between 1 and 2
        headsOrTails=(int)(Math.random()*2)+1;
        //if users guess equals random coin flip they win
        if (headsOrTails==HorT){
            //if number is 1, displays heads
            if (headsOrTails==1) {
                coinFlip="heads";
             //if number is 2 display tails
            }else{
                coinFlip="tails";
            }

                //display which coin has been flipped and
                System.out.print("The coin has been flipped...." + coinFlip+"\n");
                System.out.print("!WINNER!");
                money += bet1;



        }//if closing
        //otherwise they lose
        else{
            if (headsOrTails==1) {
                coinFlip="heads";
            }else{
                coinFlip="tails";
            }
            System.out.print("The coin has been flipped...." + coinFlip+"\n");
            System.out.print("!LOSER!");
            money-=bet1;



        } //else closing







        //money is returned
        return money;
    }//HeadsOrTails(int money,int bet1)





    /**
     * Get bet method
     *
     *
     * @param money Money total
     * @param name Users name
     * */
    public static int getBet(int money, String name){
        //initialize variables
        int playerBet;
        System.out.println("");
        //state money total
        System.out.println("Alright " + name+", you have $"+ money+"\n");


        //error trap bet so that user can only enter the money they have
        do{
            System.out.println("---------------");
            System.out.print("Place your bet $:\n");
            System.out.println("---------------");
            playerBet=input.nextInt();
            if (playerBet>=0 && playerBet<=money){
                break;
            }
            else{
                System.out.print("!Invalid bet!\n");
                System.out.print(name+", please play within your limits!\n");
                System.out.println("");
            }//end of else
        }while(true);

        //player bet is returned
        return playerBet;
    }//getBet(int money, String name)


    /**
     * over under even method
     *
     * @param money Money total
     * @param bet3 Users money bet
     * @param name name of user
     * */
    public static int overUnderEven(int money, int bet3,String name){
        //initialize variables
        int Dice1=0;
        int Dice2=0;
        int totalRoll=0;
        int guess=0;

        //error trap so that user can only enter 1,2,3
        do {
            System.out.println(name+", will the roll be under 7 (1), over 7 (2) or equal to 7 (3)?");
            guess = input.nextInt();
            input.nextLine();
            if (guess==1||guess==2||guess==3){
                break;
            }else{
                System.out.print("Invalid input! Please enter under(1), over(2) or even(3)\n");
                System.out.println("");
            }//end of else

        }while(true); //end of do loop

        //roll 2 dice
        System.out.println("");
        System.out.print(name+", press ENTER to roll dice 1:");
        input.nextLine();
        //generate random between 1 and 6
        Dice1=(int)(Math.random()*6)+1;
        System.out.printf("ROLLED: %d %n", Dice1);

        System.out.println("");
        System.out.print(name+", press ENTER to roll dice 2:");
        input.nextLine();
        Dice2=(int)(Math.random()*6)+1;
        System.out.printf("ROLLED: %d %n", Dice2);
        System.out.println("");

        //total dice roll is dice 1 plus dice 2
        totalRoll=(Dice1+Dice2);

        // if user guess is 2(over) and the dice total is bigger to 7, they win
        if (guess==2 && totalRoll>7){
            System.out.print("!WINNER!\n");
            money+=bet3;
        }
        // if user guess is 1(under) and the dice total is smaller to 7, they win
        else if (guess==1 && totalRoll<7){
            System.out.print("!WINNER!");
            money+=bet3;
        }
        // if user guess is 3(equal) and the dice total is equal to 7, they win twice the money
        else if(guess==3 && totalRoll==7){
            System.out.print("!DOUBLE WINNER!");
            money+=(2*bet3);

        }
        // otherwise they lose
        else{
            System.out.print("!LOSER!");
            money-=bet3;

        }//else



        //money is returned
        return money;
    }//overUnderEven(int money, int bet3)



    /**
     * higher or lower method
     *
     * @param money Money total
     * @param bet4 Users money bet
     * @param name name of user
     * */
    public static int higherOrLower(int money, int bet4, String name){
        //initialize variables
        int randomNum;
        int randomNum2;
        int randomNumGuess=0;

        //generate random number between 1 and 10
        randomNum=(int)(Math.random()*10)+1;
        System.out.printf("Random Number 1 = %d\n", randomNum);

        //do loop to error trap values
        do {
            System.out.println(name+", will the random number be higher (1) or lower (2) than " + randomNum + "?\n");
            randomNumGuess = input.nextInt();
            if (randomNumGuess==1||randomNumGuess==2){
                break;
            }else{
                System.out.print("Invalid input! Please enter higher(1) or lower(2)\n");
                System.out.println("");
            }
        }while(true);//while(true)

        //generate second random num
        randomNum2=(int)(Math.random()*10)+1;

        //if user guess is higher(1) and the second num is < then the first num, or they guess lower (2) and second num is > then the first num
        //they win
        if (randomNumGuess==1 && randomNum<randomNum2 || randomNumGuess==2 && randomNum>randomNum2){
            System.out.print("Random Number 2 = " + randomNum2+"\n");
            System.out.print("!WINNER!");
            money+=bet4;


        }
        //otherwise they lose
        else{
            System.out.print("Random number 2 = " + randomNum2+"\n");
            System.out.print("!LOSER!");
            money-=bet4;

        }//else

        //money is returned
        return money;
    }//higherOrLower(int money, int bet4)


    /**
     * title display method
     *
     * */
    public static String programTitle(){
        //display casino title and dice art
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("---------------------------------------------------");
        System.out.println("              OLIVIA'S CASINO                       ");
        System.out.println("---------------------------------------------------");

        System.out.println("                _______.");
        System.out.println("   ______      | .   . |\\");
        System.out.println("  /     /\\     |   .   |.\\");
        System.out.println(" /  '  /  \\    | .   . |.'|");
        System.out.println("/_____/. . \\   |_______|.'|");
        System.out.println("\\ . . \\    /   \\ ' .   \\ '|");
        System.out.println(" \\ . . \\  /     \\____'__\\ |");
        System.out.println("  \\_____\\/");



        return null;
    }//programTitle()






    //scanner to get input
    static Scanner input = new Scanner(System.in);
    //main
    public static void main(String[] args) {
            //initialize variables
            int money=500;
            int playerBet=0;
            String name;
            String display1;
            int bet2=0;
            int bet1=0;
            int bet3=0;
            int bet4=0;
            int diceRolls=0;
            int gameChoice=0;

        //call program title method to display title
        display1=programTitle();
        // casino game intro
        System.out.print("Please enter your name: ");
        name = input.nextLine();
        System.out.print("Hello , "+name+ " and welcome to Olivia's Casino!\n");
        System.out.print("");
        System.out.println("");
        //instructions
        System.out.print("------------\n");
        System.out.print("Instructions: \n");
        System.out.print("------------\n");
        System.out.print("In Olivia's Casino you have the option of picking four different games to play\n");
        System.out.println("");
        System.out.print("You are starting with $" + money + "\n");
        System.out.printf("You can bet as much money as you want, within your limits of course.\n");
        System.out.print("If you win a game, you win the amount of money you bet\n");
        System.out.print("and you lose the amount of money you bet if you lose\n");
        System.out.print("Have fun!\n");
        System.out.println("");
    //main while true loop
    while (true) {
        //give user option of games
        System.out.printf("%-17s %n", "\nOlivia's Casino");
        System.out.printf("%-17s %n", "1 - Craps");
        System.out.printf("%-17s %n", "2 - Heads or Tails");
        System.out.printf("%-17s %n", "3 - Over/Under/Even");
        System.out.printf("%-17s %n", "4 - Higher or Lower");
        System.out.printf("%-17s %n", "5 - Exit");

       //error trap game choice from 1-5
        do {
            System.out.println(name + ", choose a game to play: ");
            gameChoice = input.nextInt();
            if (gameChoice==1||gameChoice==2||gameChoice==3||gameChoice==4||gameChoice==5){
                break;
            }else{
                System.out.print("Invalid input! Please enter game from from 1-5!\n");
                System.out.println("");
            }//else
        }while(true);//while true

        //if choice is 1, they play craps
        if (gameChoice == 1) {
            //call program title method
            String programDisplay=programTitle();
            System.out.print("\n");
            System.out.print("Welcome to CRAPS!\n");
            System.out.print("CRAPS INSTRUCTIONS: You will place a bet and then roll two dice.\n");
            System.out.print("If you roll 7 or 11, you win, but if you roll 2,3 or 12 you lose.\n");
            System.out.print("If you roll anything else, that roll becomes your point and you roll until \n");
            System.out.print("you get that point again, or you lose if you get 7 or 11.\n");
            System.out.print("GOOD LUCK!\n");
            while(true) {
                // getBet is called and user is asked to bet money
                bet2 = getBet(money,name);
                if (bet2 != 0) {
                    //play craps method is called
                    money = playCraps(name, money, bet2);
                }
                else{
                    break;
                }//else
            }//while true

        }//if (game choice)

        //if game choice is two user plays heads or tails
        if (gameChoice == 2) {

            //program title method is called
            String programDisplay=programTitle();
            System.out.print(" \n");
            System.out.print("Welcome to Heads or Tails!\n");
            System.out.print("HEADS OR TAILS INSTRUCTIONS: You place bet and choose either heads or tails. \n");
            System.out.print("A coin is flipped, and if your guess is the same as the coin, you win \n");
            System.out.print("and if it is different, well... you lose.\n");
            System.out.print("GOOD LUCK!\n");
            while(true) {
                // bet method is called
                bet1 = getBet(money,name);
                if (bet1 != 0) {
                    // heads or tails method is called
                    money = HeadsOrTails(money, bet1,name);
                }//if
                else{
                    break;
                }//else
            }//while true

        }//if game choice

        //if game choice is 3 user plays over under or even
        if (gameChoice == 3) {
            //call over/even/under method and title display method
            String programDisplay=programTitle();
            System.out.print("\n");
            //instructions
            System.out.print("Welcome to Over/Under/Even!\n");
            System.out.print("OVER/UNDER/EVEN INSTRUCTIONS: You place a bet and guess if the roll of two dice \n");
            System.out.print("will be over, equal to or under 7. If you guess even (7), you win double. \n");
            System.out.print("If you guess over or under, you win and every other case, you lose. \n");
            System.out.print("GOOD LUCK!\n");
            while(true){
                //call bet method
                bet3=getBet(money,name);
                if (bet3!=0){
                    //call over under even method
                    money = overUnderEven(money, bet3, name);
                }//if
                else{
                    break;
                }//else
            }//while true

        }//if (game choice)

        //if game choice is 4 user plays higher or lower
        if (gameChoice == 4) {
            //call HIGHER or LOWER method and title display method
            String programDisplay=programTitle();
            System.out.println("");
            //instructions
            System.out.print("Welcome to Higher or Lower!\n");
            System.out.print("HIGHER OR LOWER INSTRUCTIONS: You place a bet and the computer displays a \n");
            System.out.print("random number from 1-10. You need to guess if the next number will be higher or lower. \n");
            System.out.print("You can only guess higher or lower. If you guess correctly you win the bet\n");
            System.out.print("otherwise you lose the bet.\n");
            System.out.print("GOOD LUCK!\n");

            while(true) {
                //call bet method
                bet4=getBet(money,name);
                if (bet4!=0){
                    //call higher or lower method
                    money = higherOrLower(money,bet4,name);
                }//if
                else{
                    break;
                }//else

            }//while true
        }//if (game choice)

        // if game choice is 5, exit game and display money total
        if (gameChoice==5){
            System.out.print(name + " you are leaving with $"+money+". Thank you for playing!");
            break;
        }//if


    }//while(true)





    }//public static void main




}//public class MegaCasino
