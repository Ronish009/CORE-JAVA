void main(){
    System.out.println("Hi");
    ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,                     // core pool size
            2,                     // max pool size
            10, TimeUnit.SECONDS,  // keep-alive time
            new ArrayBlockingQueue<>(2), // queue capacity
            new ThreadPoolExecutor.CallerRunsPolicy() // <— handle overflow
    );
    for (int i = 1; i <= 6; i++) {
        final int taskNum = i;
        try {
            executor.execute(() -> {
                System.out.println("Running task " + taskNum + " on " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000); // simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        } catch (RejectedExecutionException e) {
            System.err.println("Oops !!! Task " + taskNum + " rejected!");
        }
    }

    executor.shutdown();
}
