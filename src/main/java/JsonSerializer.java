import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonSerializer {

    public static void serialize(Object obj) throws IOException, IllegalAccessException {
        Class<?> clazz = obj.getClass();

        // Check if class is annotated
        if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
            throw new RuntimeException("Class " + clazz.getSimpleName() + " is not annotated with @JsonSerializable");
        }

        // Get annotation and directory
        JsonSerializable annotation = clazz.getAnnotation(JsonSerializable.class);
        String directory = annotation.directory();
        Files.createDirectories(Paths.get(directory));

        // Build JSON string manually
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true); // Allow access to private fields
            String name = fields[i].getName();
            Object value = fields[i].get(obj);

            jsonBuilder.append("  \"").append(name).append("\": ");

            if (value instanceof String) {
                jsonBuilder.append("\"").append(value).append("\"");
            } else {
                jsonBuilder.append(value);
            }

            if (i < fields.length - 1) {
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\n");
        }

        jsonBuilder.append("}");

        // Write to file
        String fileName = directory + "/" + clazz.getSimpleName() + ".json";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(jsonBuilder.toString());
            System.out.println("Object serialized to: " + fileName);
        }
    }
}
