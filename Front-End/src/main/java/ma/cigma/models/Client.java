package ma.cigma.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private long id ;
    private String name;
    private int age;
    private String imageUrl;
    private Countries country;

}
