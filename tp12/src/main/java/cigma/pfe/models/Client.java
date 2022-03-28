package cigma.pfe.models;
import lombok.*;
import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Clients")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id ;
  private String name;
  private int age;
  private String imageUrl;
  @ManyToOne
  @JoinColumn(name = "country_id")
  private Countries country;

}
