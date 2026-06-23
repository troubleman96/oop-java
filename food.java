public class food {

    String food_name;
    int price;

    public void order(){
        System.out.println("ordering...");
    }




public static void main(String[] args){
    food chipsi = new food();
    chipsi.food_name = "Chipsi";
    chipsi.price = 100;

    chipsi.order();

    System.out.println("Food name: " + chipsi.food_name + " — " + "Price: " + chipsi.price);


    food pilau = new food();
    pilau.food_name = "Pilau";
    pilau.price = 150;

    pilau.order();

    System.out.println("Food name: " + pilau.food_name + " — " + "Price: " + pilau.price);

    }
}