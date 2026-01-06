static final ScopedValue<String> REQUEST_ID = ScopedValue.newInstance();
static void log(String msg) {
    System.out.println("[" + REQUEST_ID.get() + "] " + msg);
}
static void handleRequest(Object request) {
    String response = switch (request) {
        case String s -> {
            if (s.startsWith("CREATE")) {
                log("Creating entity: " + s);
                yield "Created successfully";
            } else if (s.startsWith("UPDATE")) {

                log("Updating entity: " + s);
                yield "Updated successfully";
            } else if (s.startsWith("DELETE")) {
                log("Deleting entity: " + s);
                yield "Deleted successfully";
            } else {
                yield "Other string request";
            }
        }
        case null -> {
            log("Received null request");
            yield "No request to process";
        }
        default -> {
            log("Unknown request type: " + request);
            yield "Unknown request";
        }
    };
}


void main() {
        System.out.println("Hello");

        Object[] requests = {"CREATE_USER", "DELETE_USER", 404, "UPDATE_USER", null};
        for (Object req : requests) {
            // Set a scoped request ID for each request
            ScopedValue.where(REQUEST_ID, "REQ-" + System.currentTimeMillis())
                    .run(() -> handleRequest(req));
        }
    }

