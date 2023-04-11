import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import model.Berry;
import model.Fruit;
import model.Vegetable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    @SneakyThrows
    public static void main(String[] args) {
        Fruit apple = new Fruit();
        apple.setId(1);
        apple.setName("Apple");
        log.info(apple.toString());

        Vegetable tomato = Vegetable.creator()
                .withId(2)
                .withName("Tomato")
                .create();
        log.info(tomato.toString());

        String json = "{\"title\":\"Blueberry\",\"id\":3}";

        var objectMapper = newObjectMapper();
        Berry blueberry = objectMapper.readValue(json, Berry.class);
        log.info(blueberry.toString());
        log.info(String.format("Object equals - %s", blueberry.equals(Berry.builder()
                .id(3)
                .name("Blueberry")
                .build())));

        Berry wildberry = Berry.builder()
                .id(5)
                .build();

        log.info(wildberry.toString());
        String json2 = objectMapper.writeValueAsString(wildberry);
        log.info(json2);

    }

    private static ObjectMapper newObjectMapper() {
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}