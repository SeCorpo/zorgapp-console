import java.time.LocalDate;

class ZorgApp
{
   public static void main( String[] args )
   {
      User           user           = new User("mt","Sem", "Koldewijn", LocalDate.of(1999,6,1));
      Administration administration = new Administration( user );

      administration.menu();
   }
}