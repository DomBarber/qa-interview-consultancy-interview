package pokedex.model.response;

import lombok.Data;
import pokedex.model.data.Localised;

@Data
public class SearchResponse {
    private int id;
    private String name;
    private Localised[] localised;
}
