import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("main");

        ObjectMapper objectMapper = new ObjectMapper();

        // 객체 생성
        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        Car car1 = new Car();
        car1.setName("K5");
        car1.setCarNumber("11가 1111");
        car1.setType("sedan");

        Car car2 = new Car();
        car2.setName("Q5");
        car2.setCarNumber("22가 2222");
        car2.setType("SUV");

        var carList = Arrays.asList(car1, car2);
        user.setCars(carList);

        System.out.println(user);

        // json 으로 변환하기
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        // 변환된 json을 트리노드 객체형태로 변환해서 접근하기
        JsonNode jsonNode = objectMapper.readTree(json); // tree구조의 노드로 변환
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();

        System.out.println("name : " + _name);
        System.out.println("age : " + _age);

        // 해당 노드객체 안에 또다른 노드가 있을시 접근법
        //생략된 코드
        //JsonNode cars = jsonNode.get("cars"); // cars 안의 노드 접근
        //ArrayNode arrayNode = (ArrayNode) cars; // 해당 노드를 배열 노드로 변환
        var _list = objectMapper.convertValue((ArrayNode) jsonNode.get("cars"), new TypeReference<List<Car>>() {});
        System.out.println(_list);

        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "steve");
        objectNode.put("age", 20);

        System.out.println(objectNode.toPrettyString());
    }
}
