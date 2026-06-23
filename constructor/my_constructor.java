public class my_constructor {
    
    String user_name;
    int user_age;
    String location;
            
    public my_constructor(String user_name, int user_age, String location){
        this.user_name = user_name;
        this.user_age = user_age;
        this.location = location;
    }

    public void introduction(){
        System.out.println("Habari, I am " + user_name + ", age " + user_age + " and I live in " + location);
        //System.out.println("Hello, I am " + user_name + ", age " + user_age + " and I live in " + location);
    }

    public static void main(String[] args){
        
        my_constructor user1 = new my_constructor("Emmanuel", 20, "Nairobi");
        my_constructor user2 = new my_constructor("Amina", 22, "Mombasa");
        
        user1.introduction();
        user2.introduction();

        System.out.println(user1.user_name + " is " + user1.user_age + " years old and lives in " + user1.location);
        System.out.println(user2.user_name + " is " + user2.user_age +  " years old and lives in " + user2.location);
    }

}
