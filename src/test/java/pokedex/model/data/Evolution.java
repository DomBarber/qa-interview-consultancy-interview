package pokedex.model.data;

import lombok.Data;

@Data
public class Evolution {
    private int id;
    private String name;
    private Localised[] localised;
}
