import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class Calculate {
    public static void main(String[] args) {



        Faker faker =new Faker();
        String zipCode= faker.address().zipCode().substring(0,5);
        String visa1 ="VISA";

        String creditCardNumber=faker.finance().creditCard(CreditCardType.AMERICAN_EXPRESS);
        System.out.println("creditCardNumber = " + creditCardNumber);
        String creditCardNumber1=faker.finance().creditCard(CreditCardType.VISA);
        System.out.println("creditCardNumber1 = " + creditCardNumber1);
        String creditCardNumber2=faker.finance().creditCard(CreditCardType.MASTERCARD);
        System.out.println("creditCardNumber2 = " + creditCardNumber2);

        long masterCard = 5200000000000000L + (long) (Math.random() *  100000000000000L );
        long visa= 4200000000000000L + (long) (Math.random() *  100000000000000L );
        long amex= 320000000000000L + (long) (Math.random() *  100000000000000L );


        System.out.println(masterCard);
        System.out.println(visa);
        System.out.println(amex);


       // long number = 5200000000000000L + first14;

       // System.out.println(number);



    }
}
