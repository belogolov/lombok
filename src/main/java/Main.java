import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import model.Berry;
import model.Fruit;
import model.Vegetable;


public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Fruit apple = new Fruit();
        apple.setId(1);
        apple.setName("Apple");
        System.out.println(apple);

        Vegetable tomato = Vegetable.creator()
                .withId(2)
                .withName("Tomato")
                .create();
        System.out.println(tomato);

        String json = "{\"title\":\"Blueberry\",\"id\":3}";

        var objectMapper = newObjectMapper();
        Berry blueberry = objectMapper.readValue(json, Berry.class);
        System.out.println(blueberry);
        System.out.println(blueberry.equals(Berry.builder()
                .id(3)
                .name("Blueberry")
                .build()));

        Berry wildberry = Berry.builder()
                .id(5)
                .build();

        System.out.println(wildberry);
        String json2 = objectMapper.writeValueAsString(wildberry);
        System.out.println(json2);

    }

    private static ObjectMapper newObjectMapper() {
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}