

interface testInter {
    int method(int x);
}

public class App {
    static int arg(int x){
        if (x > 100)
            return 0;
        return 1;
    }
    public static void main(String[] args) throws Exception {
        try {
            testInter t = App::arg;
            System.out.println(t.method(141));


        } catch (Exception e) {
            System.out.println("Exception1");
        } catch (ExceptionInInitializerError e) {
            System.out.println("Exception2");
        }
        System.out.println("Done");
    }
}
