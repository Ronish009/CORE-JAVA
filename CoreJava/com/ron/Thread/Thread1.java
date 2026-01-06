void main() {

    System.out.println("Welcome Java 25 and  Ronish");
   /* System.out.println("========Executor runs tasks immediately in the same thread that calls execute(), rather than submitting them to another thread========");
    Executor executor = new DirectExecuter();
    Runnable task = () -> {
        System.out.println("Running the Thread : " + Thread.currentThread().getName());
    };
    System.out.println("Submitting the Task : " + Thread.currentThread().getName());
    executor.execute(task);*/
    System.out.println("=============================================");
    Executor direct = new DirectExecuter();      // runs tasks in current thread
    Executor serial = new SerialExecutor(direct); // ensures tasks run one at a time

    for (int i = 1; i <= 3; i++) {
        int taskNum = i;
        serial.execute(() -> {
            System.out.println("Task " + taskNum + " running on " + Thread.currentThread().getName());
            try {
                Thread.sleep(500); // simulate some work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Task " + taskNum + " finished");
        });

    }
}
    class DirectExecuter implements Executor {
        @Override
        public void execute(Runnable command) {
            command.run();
        }
    }

    class SerialExecutor implements Executor {
        final Queue<Runnable> tasks = new ArrayDeque<>();
        final Executor executor;
        Runnable active;

        SerialExecutor(Executor executor) {
            this.executor = executor;
        }

        public synchronized void execute(Runnable r) {
            tasks.add(() -> {
                try {
                    r.run();
                    System.out.println("TASK IN THE MIDDLE");
                } finally {
                    System.out.println("FINALLY");
                    scheduleNext();
                }
            });
            System.out.println(active);
            if (active == null) {
                scheduleNext();
            }
            System.out.println("Active:"+active);
        }

        protected synchronized void scheduleNext() {
            if ((active = tasks.poll()) != null) {
                System.out.println("Active Inside"+active);
                executor.execute(active);
            }
        }
    }
