package steps.PetStore.Pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsIterableContaining.hasItem;


public class AtualizarDadosDeUmPetExistente {

    private Response response;

    @Given("que eu acesso o endpoint de atualizacao")
    public void queEuAcessoOEndpointDeAtualizacao() throws InterruptedException {

        String body = "{ " +
                "\"id\": 1, " +
                "\"category\": { " +
                "\"id\": 1, " +
                "\"name\": \"animal1\" " +
                "}, " +
                "\"name\": \"doggie\", " +
                "\"photoUrls\": [ " +
                "\"string\" " +
                "], " +
                "\"tags\": [ " +
                "{ " +
                "\"id\": 2, " +
                "\"name\": \"cachorro\" " +
                "} " +
                "], " +
                "\"status\": \"available\" " +
                "}";


        response = RestAssured
                .given()
                .contentType("application/json")
                .body(body)
                .when()
                .put("https://petstore.swagger.io/v2/pet");
    }


    @When("eu informo os dados do pet que desejo atualizar")
    public void euInformoOsDadosDoPetQueDesejoAtualizar() {
    }

    @Then("a chamada deve retornar um status code {int}")
    public void aChamadaDeveRetornarUmStatusCode(int arg0) {
        response.then().statusCode(200);
    }

    @And("o corpo da resposta deve conter os dados atualizados do pet")
    public void oCorpoDaRespostaDeveConterOsDadosAtualizadosDoPet() {
        response.then()
                .body("id", equalTo(1))
                .body("category.id", equalTo(1))
                .body("category.name", equalTo("animal1"))
                .body("name", equalTo("doggie"))
                .body("photoUrls", hasItem("string"))
                .body("tags[0].id", equalTo(2))
                .body("tags[0].name", equalTo("cachorro"))
                .body("status", equalTo("available"));
    }

}


