void main(){
    BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
    Runnable r = () ->{
        for (int i = 1; i <= 5; i++) {
            int val = i *2;
            try{
                queue.put(val);
                System.out.println("Produced: " + val + " Thread: " + Thread.currentThread().getName());
            }catch (InterruptedException e){ Thread.currentThread().interrupt();}
        }
    };
    Runnable r1 = () ->{
        try{
        for (int i = 1; i <= 5; i++) {
            int val = queue.take();  // take value from queue (waits if empty)
            int result = val + 3;
            System.out.println("Produced: " + result + " Thread: " + Thread.currentThread().getName());

        } }catch (InterruptedException e){ Thread.currentThread().interrupt();}
    };
    Thread t1 = new Thread(r, "Thread 1");
    Thread t2 = new Thread(r1, "Thread 2");
    t1.start();
    t2.start();
   /* try {
        t1.join();
        t2.join();
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }*/
}