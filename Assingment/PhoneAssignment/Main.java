public class Main {
    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone("Samsung", 85, "Android");
        BasicPhone basicPhone = new BasicPhone("Nokia", 60, true);

        Phone[] phones = { smartPhone, basicPhone };

        for (Phone phone : phones) {
            phone.displayInfo();
        }

        System.out.println(smartPhone.getBrand() + " runs " + smartPhone.getOperatingSystem());
        System.out.println(basicPhone.getBrand() + " has flashlight: " + basicPhone.getHasFlashlight());
    }
}
