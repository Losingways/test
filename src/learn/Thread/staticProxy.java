package learn.Thread;

public class staticProxy {
    public static void main(String[] args) {
        money m = new money();

        new Thread(() -> System.out.println("love you")).start();
        // they are the same
        new marryCompany(m).Marry();
    }
}

interface testMarry {
    void Marry();
}

class money implements testMarry {
    @Override
    public void Marry() {
        System.out.println("结婚");
    }
}

class marryCompany implements testMarry {

    private testMarry target;

    public marryCompany(testMarry target) {
        this.target = target;
    }

    @Override
    public void Marry() {
        beforeMarry();
        this.target.Marry();
        afterMarry();
    }

    private void afterMarry() {
        System.out.println("收钱");
    }

    private void beforeMarry() {
        System.out.println("布置现场");
    }

}