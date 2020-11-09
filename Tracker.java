import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;



public class Tracker 
{
    private static ArrayList<String> allTasks = new ArrayList<String>();
    static Task x;
    
    


    /**
     * 
     * Main method - uses switch methods to access all the classes
     * 
     * @param args
     *            main method parameter
     */
    public static void main( String args[] )
    {
        Scanner kbd = new Scanner( System.in );
        String userName;
        
        System.out.println(
                        "Hello and welcome to my APCS Final Project. My name is Fulk. What is yours?" );
                    userName = kbd.nextLine();
                    System.out.println( "It's nice to meet you " + userName
                        + "! ");
        boolean done = false;
        do
        {

            System.out.println( " Here are all of our activities, please choose the one you are interested in:" );
            System.out.println();
            System.out.println( "   (1) Food" );
            System.out.println( "   (2) Task" );
            System.out.println( "   (3) Hangman Game" );
            System.out.println( "   (4) Number Guessing Game" );
            System.out.println( "   (5) Memory Game" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                    {
                        FoodTracker track = new FoodTracker();

                        Scanner sc = new Scanner( System.in );
                        System.out.print( "What would you like to do?" );

                        boolean ftDone = false;

                        do
                        {
                            System.out.println();
                            System.out.println();
                            System.out.println( "   (1) Display all foods" );
                            System.out.println(
                                "   (2) Add a food item or increase food quantity" );
                            System.out
                                .println( "   (3) Decrease food quantity" );
                            System.out.println( "   (4) Remove a food item" );
                            System.out.println( "   (5) Exit" );
                            System.out.println();
                            System.out.print( "Enter a number:  " );
                            String ft = sc.nextLine();

                            if ( ft.length() > 0 )
                            {
                                System.out.println();
                                switch ( ft.charAt( 0 ) )
                                {
                                    case '1':
                                        track.displayFood();
                                        break;
                                    case '2':
                                        System.out.print(
                                            "Enter the name of the food: " );
                                        String food1 = sc.nextLine().trim();
                                        System.out.println();
                                        System.out.print(
                                            "Enter the amount you want to add: " );
                                        int num1 = sc.nextInt();
                                        track.addFood( food1, num1 );
                                        break;
                                    case '3':
                                        System.out.print(
                                            "Enter the name of the food: " );
                                        String food2 = sc.nextLine().trim();
                                        System.out.println();
                                        System.out.print(
                                            "Enter the amount you want to subtract: " );
                                        int num2 = sc.nextInt();
                                        track.subtractAmount( food2, num2 );
                                        break;
                                    case '4':
                                        System.out.print(
                                            "Enter the name of the food: " );
                                        String food3 = sc.nextLine().trim();
                                        track.removeFood( food3 );
                                        break;
                                    default:
                                        if ( ft.charAt( 0 ) == '5' )
                                        {
                                            ftDone = true;
                                        }
                                        else
                                        {
                                            System.out
                                                .print( "Invalid Choice" );
                                        }
                                        break;
                                }

                            }

                        } while ( !done );

                        System.out.print( "Bye" );
                    }
                        break;

                    
                   
                    case '3':

                        System.out.println(
                            "Hi " + userName + "! Welcome to Hangman." );

                        Scanner mg = new Scanner( System.in );
        Scanner numGuessGame = new Scanner( System.in );
        ;

        
        String current = "";

        System.out.println(
            "To win you must guess a 5 letter word before the box disappears" );
        System.out.println( "         ___________________ " );
        System.out.println( "        |                   |" );
        System.out.println( "        |                   |" );
        System.out.println( "        |                   |" );
        System.out.println( "        |                   |" );
        System.out.println( "        |                   |" );
        System.out.println( "        |                   |" );
        System.out.println( "         ___________________ " );

        // ask user to quit to continue the game
        Scanner input = new Scanner( System.in );
        char user = ' ';

        String[] arrayString;

        String misc[] = { "hello", "cloud", "sleep", "stars",
            "names", "trees" };
        String colors[] = { "brown", "green", "hazel", "lilac",
            "peach", "white" };
        String food[] = { "apple", "mango", "grape", "donut",
            "pizza" };

        System.out.println(
            "Choose a category: colors, food or miscellaneous" );

        String category = input.nextLine();

        if ( category.equalsIgnoreCase( "colors" ) )
        {
            arrayString = colors;
        }
        else if ( category.equalsIgnoreCase( "food" ) )
        {
            arrayString = food;
        }
        else if ( category
            .equalsIgnoreCase( "miscellaneous" ) )
        {
            arrayString = misc;
        }
        else
        {
            System.out.println(
                "Sorry that is an invalid category. You have been exited from the game, please try again later." );
            return;
        }

        char guessed = ' ';
        // game start
        // select one word at random and display
        // create random object
        Random r = new Random();

        // Returns number between 0-5
        int idx = r.nextInt( 5 );
        String gameWord = arrayString[idx];

        System.out.println( "The word is: " + gameWord );

        // prompt user to guess first letter
        // max number of incorrect answers is 7, set current
        // number to 0
        int wrong = 0;
        int i = 0;
        char guessChar;

        while ( i < 5 || wrong < 8 )
        {
            if ( current.length() > 0 )
            {
                System.out.println(
                    "Your current guess: " + current );
            }
            System.out
                .print( "Guess the letter: (Q for quit) " );

            guessChar = input.next().charAt( 0 );

            // System.out.println("input char " + guessChar);
            // System.out.println("char from word " +
            // gameWord.charAt(i));
            if ( guessChar == 'Q' )
                break;
            if ( gameWord.charAt( i ) == guessChar )
            {
                // guessed += guessChar;
                current = current + guessChar;
                System.out.println( "Next letter" );
                i++;

            }
            else
            {
                wrong++;
                System.out.println( "wrong guess " + wrong );
                // guessed += guessChar;
            }

            if ( i == 5 )
            {
                System.out.println( "Congrats! You won!" );
                break;
            }

            if ( wrong == 8 )
            {
                System.out.println(
                    "Sorry you are out of guesses! The word was: "
                        + gameWord );
                break;

            }
            if ( wrong == 1 )
            {
                System.out.println(
                    "         ___________________ " );
                System.out.println(
                    "        |                   |" );
                System.out.println(
                    "        |                   |" );
                System.out.println(
                    "        |                   |" );
                System.out.println(
                    "        |                   |" );
                System.out.println(
                    "        |                   |" );
                System.out.println(
                    "        |                   |" );

            }
            if ( wrong == 2 )
            {
                System.out.println(
                    "         ___________________ " );
                System.out.println(
                    "        |                   |" );
                System.out.println(
                    "        |                   |" );
                System.out.println(
                    "        |                   |" );
                System.out.println(
                    "        |                   |" );
                System.out.println(
                    "        |                   |" );

            }
            if ( wrong == 3 )
            {
                System.out.println(
                    "         ___________________ " );
                System.out.println(
                    "        |                   |" );
                System.out.println(
                    "        |                   |" );
                System.out.println(
                    "        |                   |" );
                System.out.println(
                    "        |                   |" );

            }
            if ( wrong == 4 )
            {
                System.out.println(
                    "         ___________________ " );
                System.out.println(
                    "        |                   |" );
                System.out.println(
                    "        |                   |" );
                System.out.println(
                    "        |                   |" );

            }
            if ( wrong == 5 )
            {
                System.out.println(
                    "         ___________________ " );
                System.out.println(
                    "        |                   |" );
                System.out.println(
                    "        |                   |" );

            }
            if ( wrong == 6 )
            {
                System.out.println(
                    "         ___________________ " );
                System.out.println(
                    "        |                   |" );

            }
            if ( wrong == 7 )
            {
                System.out.println(
                    "         ___________________ " );
            }

        }

                        break;

                    case '4':
                        NumberGuessingGame s = new NumberGuessingGame();
                        System.out.println( "Hi " + userName
                            + "! Welcome to the Number Guessing Game. I am thinking of a number between 1 and 10." );

                        s.play();

                        break;

                    case '5':
                        Scanner mg = new Scanner( System.in );
                        Scanner numGuessGame = new Scanner( System.in );

                        System.out.println( "Hi " + userName
                            + "! Welcome to the Memory Game. In a few seconds, some words will appear on"
                            + " your screen. \n Memorize these words in the order they are shown, you"
                            + " will be asked to type them soon. \n How many words would you like to see? " );
                        String next = mg.nextLine();
                        int num = Integer.parseInt( next );
                        MemoryGame mGame = new MemoryGame( num );

                        mGame.play();

                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Sorry " + userName
                                + ", that is an invalid choice" );
                        }
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye " + userName + "!" );
    }
}
