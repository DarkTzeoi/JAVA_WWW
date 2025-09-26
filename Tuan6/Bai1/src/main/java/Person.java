import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private String name;
    private List<String> emails;
    private List<Address> addresses;
    private int age;
}
