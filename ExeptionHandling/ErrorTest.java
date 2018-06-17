public class ErrorTest
{

    static void printing() throws ArithmeticException
    {
        System.out.println("oh hey");
        int sum;
        sum = 10/0;
        System.out.println(sum);
        throw new ArithmeticException();


    }
    public static void main (String args[])
    {
        int a = 50;
        int b = 0;
        System.out.println("Watch out, an Error incoming");
        try 
        {
            int sum;
            sum = a/b;
            throw new ArithmeticException();
            //System.out.println("This possibly wont be printed");

        }
        catch (ArithmeticException e)
        {
            
            System.out.println("Okay, so we are inside the catch block !\n" );
            System.out.println("This possibly means that there was a divide by 0 error. Sorry M8, try again!");
            System.out.println("This is the Error Object :- " + e);


        }

        System.out.println("Next Error");


        try
        {
            printing();
        }
        catch(ArithmeticException e)
        {
            System.out.println("The Error was caught and the program shall continue !");
            System.out.println( e );
        }

        System.out.println("So done with errors, i'm out !");
        
    }
}