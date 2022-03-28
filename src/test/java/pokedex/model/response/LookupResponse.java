package pokedex.model.response;

import lombok.Data;
import pokedex.model.data.Item;
import pokedex.model.data.Species;
import pokedex.model.data.Types;

@Data
public class LookupResponse {
    private int height;
    private int weight;
    private Species species;
    private Types[] types;
    private Item[] items;
}
