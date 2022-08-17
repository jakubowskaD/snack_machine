package snackMachine;

public class Text {

    public void hello(){
        System.out.println(
                "Hello"
        );
    }
    public void menu(){
        System.out.println(
                "1. hungry now!\n" +
                        "2.add snack\n" +
                        "3. exit\n"
        );
    }
    public void menuAdding(){
        System.out.println(
                "1. random snack\n" +
                        "2. custom snack\n"
        );
    }
    public void mniam(){
        System.out.println(
                "bone apetit"
        );
    }
    public void empty(){
        System.out.println(
                "this box is empty. Chose another one"
        );
    }
    public void wrong(){
        System.out.println(
                "wrong"
        );
    }
}
