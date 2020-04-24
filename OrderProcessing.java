
public class Demo {
    public static void main(String[] args) {
        BlockingQueue<Order> queue = new ArrayBlockingQueue<Order>(5);
        Thread producer = new Thread(new Producer(queue), "Thread-Producer");
        Thread worker = new Thread(new Worker(queue), "Thread-worker");
        producer.start();
        worker.start();
        try {
            producer.join();
            worker.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted");
        }
    }

}


class Order {
    int orderNum;
    String state;
    public Order(int orderNum, String state) {
        this.orderNum = orderNum;
        state = state;
    }
}


class Producer implements Runnable {
    transient int i;
    private final BlockingQueue<Order> queue;
    Producer(BlockingQueue<Order> queue) {
        this.i = 1;
        this.queue = queue;
    }

    @Override
    public void run() {
        while (i <= 100) {
                if(queue.size() <= 5) {
                    queue.add(new Order(i, "NEW"));
                    i++;
                    System.out.println(queue.size());
                } else {
                    continue;
                }
            }
        }    
}


class Worker implements Runnable {
    transient int count = 0;
    private final BlockingQueue<Order> queue;
    Worker(BlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            if(count == 100) {
                break;
            }
            if(queue.size() > 0) {

                Order order = queue.poll();
                order.state = "FULLFILLED";
                count++;
            }         

        }
    }
}



