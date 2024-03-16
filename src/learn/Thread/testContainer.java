package learn.Thread;

//利用container作为中间生产者和消费者中间的缓冲区域并使用wait和notifyall来保证生产者和消费者之间的联系

public class testContainer {
    public static void main(String[] args) {
        Container container = new Container();
        productor p = new productor(container);
        consumer c = new consumer(container);
        p.start();
        c.start();
    }
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
            System.out.println("生产了" + i + "只鸡");
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
        for (int i = 0; i < 100; i++) {
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