package learn.Thread;

///
public class testContainer {

}

class productor extends Thread {
    Container container;

    public productor(Container container) {
        this.container = container;
    }
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            container.push(new chicken(i));
        }
    }

}

class consumer extends Thread {
    Container container;

    public consumer(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(container.pop().id);
        }
    }
}

class chicken {
    int id;

    public chicken(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class Container {
    chicken[] chickens = new chicken[10];
    int count = 0;

    public synchronized void push(chicken c) {
        if (count == chickens.length)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        chickens[count] = c;
        count++;
        notifyAll();
    }

    public synchronized chicken pop() {
        if (count == 0)
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        count--;
        notifyAll();
        return chickens[count];
    }
}