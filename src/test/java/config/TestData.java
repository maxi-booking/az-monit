package config;

import java.util.Random;

public class TestData {
    public Data data;
    public static final int
            MAX_WAIT_DURATION = 10;

    Random random = new Random();
    int paymentType = random.nextInt(2);
    String firstName = "Тест";
    String lastName = "Тест";
    String orderNumber = "1-11111";
    String phoneNumber = "+7-925-111-11-11";
    String email = "test@test.tt";
    Boolean phoneOrEmail = random.nextBoolean();


    public class Data {
        public int paymentType =  TestData.this.paymentType;
        public String firstName = TestData.this.firstName;
        public String lastName = TestData.this.lastName;
        public String orderNumber = TestData.this.orderNumber;
        public String phoneNumber = TestData.this.phoneNumber;
        public String email = TestData.this.email;
        public Boolean phoneOrEmail = TestData.this.phoneOrEmail;
    }

    public void setRandomData() {
        data = new Data();
    }
}