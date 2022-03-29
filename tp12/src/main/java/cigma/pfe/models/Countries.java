package cigma.pfe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="countries")
public class Countries {
    @Id
    @GeneratedValue
    @Column(name = "country_id")
    private Long id;
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy="country", fetch=FetchType.EAGER, orphanRemoval = true)
    private List<Client> clients;
}
