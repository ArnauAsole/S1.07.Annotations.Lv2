public class MainClass {
    public static void main(String[] args) {
        Person person = new Person("Marc", 99);
        try {
            JsonSerializer.serialize(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}