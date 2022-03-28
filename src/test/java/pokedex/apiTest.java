package pokedex;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pokedex.model.response.LookupResponse;
import pokedex.model.response.SearchResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class apiTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    ObjectMapper mapper = new ObjectMapper()
            .enable(SerializationFeature.INDENT_OUTPUT)
            .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    String baseUrl = "https://pokesearch-server.herokuapp.com/api/";

    // base HTTP GET request
    HttpResponse<String> httpGetRequest(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    // find a pokemon via the Pokédex search field
    SearchResponse[] searchPokemon(String pokemonName) throws Exception {
        return mapper.readValue(httpGetRequest(baseUrl + "search?query=" + pokemonName).body(), SearchResponse[].class);
    }

    // lookup stats of a searched pokemon, returning result to front end
    LookupResponse lookupPokemon(String pokemonName) throws Exception {
        return mapper.readValue(httpGetRequest(baseUrl + "lookup/" + pokemonName).body(), LookupResponse.class);
    }

    @Test
    public void validSearchQueryReturnsSinglePokemon() throws Exception {
        SearchResponse[] jsonObject = searchPokemon("charizard");
        String prettyJson = mapper.writeValueAsString(jsonObject);
        logger.info(prettyJson);
        Assert.assertEquals(1, jsonObject.length);
        Assert.assertEquals(6, jsonObject[0].getId());
        Assert.assertEquals("charizard", jsonObject[0].getName());
        Assert.assertEquals(1, jsonObject[0].getLocalised().length);
        Assert.assertEquals("Charizard", jsonObject[0].getLocalised()[0].getName());
    }

    @Test
    public void validSearchQueryReturnsMultiplePokemon() throws Exception {
        SearchResponse[] jsonObject = searchPokemon("charm");
        String prettyJson = mapper.writeValueAsString(jsonObject);
        logger.info(prettyJson);
        Assert.assertEquals(2, jsonObject.length);
        Assert.assertEquals("charmander", jsonObject[0].getName());
        Assert.assertEquals("charmeleon", jsonObject[1].getName());
    }

    @Test
    public void invalidSearchQueryReturnsEmpty() throws Exception {
        SearchResponse[] jsonObject = searchPokemon("bulbazard");
        String prettyJson = mapper.writeValueAsString(jsonObject);
        logger.info(prettyJson);
        Assert.assertEquals(0, jsonObject.length);
    }

    @Test
    public void validLookupQuery() throws Exception {
        LookupResponse jsonObject = lookupPokemon("charizard");
        String prettyJson = mapper.writeValueAsString(jsonObject);
        logger.info(prettyJson);
        // Height, Weight
        Assert.assertEquals(17, jsonObject.getHeight());
        Assert.assertEquals(905, jsonObject.getWeight());
        // Species
        Assert.assertEquals("'id' did not match", 6, jsonObject.getSpecies().getId());
        Assert.assertEquals("'name' did not match", "charizard", jsonObject.getSpecies().getName());
        Assert.assertEquals("'base_happiness' did not match", 50, jsonObject.getSpecies().getBase_happiness());
        Assert.assertEquals("'capture_rate' did not match", 45, jsonObject.getSpecies().getCapture_rate());
        Assert.assertEquals("'gender_rate' did not match", 1, jsonObject.getSpecies().getGender_rate());
        Assert.assertFalse("'has_gender_differences' did not match", jsonObject.getSpecies().isHas_gender_differences());
        Assert.assertTrue("'forms_switchable' did not match", jsonObject.getSpecies().isForms_switchable());
        Assert.assertEquals("'localised' length did not match", 1, jsonObject.getSpecies().getLocalised().length);
        Assert.assertEquals("'localised.name' did not match", "Charizard", jsonObject.getSpecies().getLocalised()[0].getName());
        // Species (Evolution Chain)
        int[] expectedEvolutionChainIds = new int[]{4,5,6};
        String[] expectedEvolutionsChainNames =  new String[]{"charmander", "charmeleon", "charizard"};
        String[] expectedEvolutionsChainLocalisedNames =  new String[]{"Charmander", "Charmeleon", "Charizard"};
        assertEvolutionChain(jsonObject, expectedEvolutionChainIds, expectedEvolutionsChainNames, expectedEvolutionsChainLocalisedNames);
        // Species (continued)
        Assert.assertEquals("'flavor_text' length did not match", 1, jsonObject.getSpecies().getFlavor_text().length);
        Assert.assertEquals("'flavor_text.id' did not match", 471, jsonObject.getSpecies().getFlavor_text()[0].getId());
        String expectedCharizardFlavorText = "Spits fire that\nis hot enough to\nmelt boulders.\fKnown to cause\nforest fires\nunintentionally.";
        Assert.assertEquals("'flavor_text.flavor_text' did not match", expectedCharizardFlavorText, jsonObject.getSpecies().getFlavor_text()[0].getFlavor_text());
        Assert.assertEquals("'name' did not match", "charizard", jsonObject.getSpecies().getName());
        // Type
        Assert.assertEquals("'types' length did not match", 2, jsonObject.getTypes().length);
        Assert.assertEquals("'types[0]' did not match", "fire", jsonObject.getTypes()[0].getNames().getName());
        Assert.assertEquals("'types[1]' did not match", "flying", jsonObject.getTypes()[1].getNames().getName());
        // Items
        Assert.assertEquals("'items' length did not match", 0, jsonObject.getItems().length);
    }

    private void assertEvolutionChain(LookupResponse jsonObject, int[] expectedIds, String[] expectedNames, String[] expectedLocalisedNames) {
        int expectedLocalisedLength = 1;
        int expectedEvolutionChainLength = expectedIds.length;
        for (int i = 0; i < expectedEvolutionChainLength; i++) {
            Assert.assertEquals("'evolution_chain.evolutions' length did not match", expectedEvolutionChainLength, jsonObject.getSpecies().getEvolution_chain().getEvolutions().length);
            Assert.assertEquals("'evolution_chain.evolutions[" + i + "].id' did not match", expectedIds[i], jsonObject.getSpecies().getEvolution_chain().getEvolutions()[i].getId());
            Assert.assertEquals("'evolution_chain.evolutions[" + i + "].name' did not match", expectedNames[i], jsonObject.getSpecies().getEvolution_chain().getEvolutions()[i].getName());
            Assert.assertEquals("'evolution_chain.evolutions[" + i + "].localised' length did not match", expectedLocalisedLength, jsonObject.getSpecies().getEvolution_chain().getEvolutions()[i].getLocalised().length);
            Assert.assertEquals("'evolution_chain.evolutions[" + i + "].localised' name did not match", expectedLocalisedNames[i], jsonObject.getSpecies().getEvolution_chain().getEvolutions()[i].getLocalised()[0].getName());
        }
    }

}
