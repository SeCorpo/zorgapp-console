import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;



///////////////////////////////////////////////////////////////////////////////////
// BScanner is a scanner class, wrapping the java.util.Scanner, providing a bit more
// robustness in cases where the given input does not match the required one.
///////////////////////////////////////////////////////////////////////////////////
class BScanner
{
   private Scanner scanner = new Scanner(System.in);

   ////////////////////////////////////////////////////////////////////////////////
   ////////////////////////////////////////////////////////////////////////////////
   public BScanner()
   {
      Scanner scanner = new Scanner(System.in);
      scanner.useLocale( Locale.UK );
   }


   ////////////////////////////////////////////////////////////////////////////////
   ////////////////////////////////////////////////////////////////////////////////
   DateTimeFormatter y_MMM_d = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
   DateTimeFormatter d_mm_y = DateTimeFormatter.ofPattern("dd-MM-yyyy");

   public int nextInt()
   {
      int r;

      while (true)
      {
         try
         {
            r = scanner.nextInt();
            break;
         }
         catch (Exception e)
         {
            System.out.println("==================================================");
            System.out.println( "Invalid input. Please enter an integer: " );

         }
         scanner.nextLine();
      }

      return r;
   }

   ////////////////////////////////////////////////////////////////////////////////
   ////////////////////////////////////////////////////////////////////////////////
   public double nextDouble()
   {
      double r;

      while (true)
      {
         try
         {
            r = scanner.nextDouble();
            break;
         }
         catch (Exception e)
         {
            System.out.println( "please enter a floating point number" );
         }
         scanner.nextLine();
      }

      return r;
   }

   ////////////////////////////////////////////////////////////////////////////////
   ////////////////////////////////////////////////////////////////////////////////
   public String nextLine()
   {
      Scanner scanPapi = new Scanner(System.in);
      String r;

      while (true)
      {
         try
         {
            r = scanPapi.nextLine();
            break;
         }
         catch (Exception e)
         {
            System.out.print("Invalid input. Please enter a valid input: ");
         }
      }

      return r;
   }

//!!! LocalDate birthday zodat als nextDate() niets returned birthday niet null wordt,
   //waardoor het programma zou crashen.
   //Als nextDate goed gaat, wordt oude birthday vervangen.
   public LocalDate nextDate(LocalDate birthday)
   {
      Scanner scanigga = new Scanner(System.in);
      LocalDate r;
      String fmt = "dd-MM-yyyy";
      String dateString = "";

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(fmt);

      while (true)
      {
         try
         {
            dateString = scanigga.nextLine();
            if (dateString.equals("0")) {
               System.out.println("Birthday has not been changed");
               return birthday;
            }
            r     = LocalDate.parse( dateString, formatter );
            break;
         }
         catch (Exception e) {
            System.out.format( "%s : this date format is not recognized", dateString );
            System.out.format( ", please enter a valid date %s:\n", fmt );
         }
      }
      return r;
   }
   public boolean yayNay() {
      System.out.println("Are you sure?");
      System.out.print("Choose 'y' or 'n': ");
      char yayNay = scanner.next().trim().toLowerCase().charAt(0);

      if(yayNay == 'y') {
         return true;
      }
      return false;
   }
}
