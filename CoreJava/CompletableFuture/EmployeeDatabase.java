package CompletableFuture;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class EmployeeDatabase {

    public static List<Emp> fetchEmployees() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File("employee.json"), new TypeReference<List<Emp>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
