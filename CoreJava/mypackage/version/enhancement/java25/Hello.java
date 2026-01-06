//ScopedValue
//StableValue

static final ScopedValue<String> REQUEST_ID = ScopedValue.newInstance();
static void process() {
    System.out.println("Processing data");
}
static void log(String msg) {
    System.out.println("[" + REQUEST_ID.get() + "] " + msg);
}
void main() {
    System.out.println("Hello from instance main!");

    Object obj = 42;
    switch (obj) {
        case int i -> System.out.println("Primitive int: " + i);
        case double d -> System.out.println("Primitive double: " + d);
        default -> System.out.println("Something else");
    }

    Integer code=-1;
    switch (code) {
        case int n when n > 0 -> System.out.println("Positive int: " + n);
        case int n when n < 0 -> System.out.println("Negative int: " + n);
        default -> System.out.println("Zero");
    }

    Object obj1 = 10;
    if (obj1 instanceof int val) {
        System.out.println("Primitive int value: " + val);
    } else if (obj1 instanceof double val) {
        System.out.println("Primitive double value: " + val);
    }
    ScopedValue.where(REQUEST_ID, "REQ-123").run(() -> {
        log("Start processing request");
        process();
    });


    int day = 2;
    String type = switch(day) {
        case 1, 7 -> "Weekend";
        default -> "Weekday";
    };
    System.out.println(type);

}