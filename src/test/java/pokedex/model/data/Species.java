package pokedex.model.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Species {
    private int id;
    private String name;
    @JsonProperty("is_baby")
    private boolean is_baby;
    @JsonProperty("is_legendary")
    private boolean is_legendary;
    @JsonProperty("is_mythical")
    private boolean is_mythical;
    private int base_happiness;
    private int capture_rate;
    private int gender_rate;
    private boolean has_gender_differences;
    private boolean forms_switchable;
    private Localised[] localised;
    private EvolutionChain evolution_chain;
    @JsonProperty("flavor_text")
    private FlavorText[] flavor_text;
}
