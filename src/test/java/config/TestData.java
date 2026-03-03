package config;

import drivers.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;

import java.util.Random;

import static helpers.Generators.*;
import static helpers.Generators.getStartDate;

public class TestData {
    public Data data;
    public static final int
            MAX_WAIT_DURATION = 10;
    private static final WebDriverConfig config =
            ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    String startOfTheSeason = config.getStartOfTheSeason();
    String endOfTheSeason = config.getEndOfTheSeason();

    Random random = new Random();
    int paymentType = random.nextInt(2);
    String firstName = "Тест";
    String lastName = "Тест";
    String orderNumber = "1-11111";
    String phoneNumber = "+7-925-111-11-11";
    String email = "test@test.tt";
    Boolean phoneOrEmail = random.nextBoolean();

    String hotel = ""; //disabled currently

    String startDate = getStartDate(startOfTheSeason, endOfTheSeason);
    String endDate = getEndDate(startOfTheSeason, endOfTheSeason);
    int adults =  randomNumberBetween(1, 2);
    int children =  randomNumberBetween(1, 2);
    int[] ages = randomNumberBetweenArray(children, 0, 18);
    int showSpecs = 1; //if 1 closest dates are included into search results
    String submit = "Узнать цены";


    public class Data {
        public int paymentType =  TestData.this.paymentType;
        public String firstName = TestData.this.firstName;
        public String lastName = TestData.this.lastName;
        public String orderNumber = TestData.this.orderNumber;
        public String phoneNumber = TestData.this.phoneNumber;
        public String email = TestData.this.email;
        public Boolean phoneOrEmail = TestData.this.phoneOrEmail;
        //data for search
        public String hotel = TestData.this.hotel;
        public String startDate = TestData.this.startDate;
        public String endDate = TestData.this.endDate;
        public int adults =  TestData.this.adults;
        public int children =  TestData.this.children;
        public int[] ages =  TestData.this.ages;
        public int showSpecs =  TestData.this.showSpecs;
        public String submit = TestData.this.submit;
    }

    public void setRandomData() {
        data = new Data();
    }
}