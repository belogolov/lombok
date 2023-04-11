package model;

import lombok.Builder;
import lombok.ToString;

@Builder (setterPrefix = "with", builderMethodName = "creator", buildMethodName = "create")
@ToString
public class Vegetable {
    private int id;
    private String name;
}
