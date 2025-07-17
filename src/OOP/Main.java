package OOP;


//import java.util.Vector;
//
//public class Main {
//    public static void main(String[] args) {
//        Parent obj1 = new Child();     // ✅ Valid (upcasting)
//        System.out.println(obj1);      // Outputs: This is Child // WHICH ONE TO EXECUTE DEPENDS ON-------->new Child();
//
//        //System.out.println(obj1.a);   //ERROR BECAUSE THE ACCESS DEPENDS ON THIS PART--------->Parent obj1
//        System.out.println(obj1.b);   // ✅ Valid BECAUSE b belongs to parent while a belongs to child
//
//        // Child obj2 = new Parent();  // ❌ Invalid
//    }
//}
public class Main {
    public static void main(String[] args) {
        Main obj=new Main();
        String msg="Spam";
        try{
            obj.check(msg);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public boolean check(String msg) throws MyException {
        if (msg.equals("Spam")) {
            throw new MyException("THIS IS SPAM MAIL");
        }
        System.out.println("UNREAD MESSAGE");
        return true;
    }
}