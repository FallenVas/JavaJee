package ma.cigma.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Countries {
    private Long id;
    private String name;
    private List<Client> clients;
}
