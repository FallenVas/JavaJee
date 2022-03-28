package ma.cigma.Pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.cigma.models.Countries;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {
    private long id ;
    private String name;
    private int age;
    private String imageUrl;
    private long countryId;
    public ClientRequest(long id , String name , int age , long countryid){
        this.id = id;
        this.name = name;
        this.age = age;
        this.countryId = countryid;
    }
}
