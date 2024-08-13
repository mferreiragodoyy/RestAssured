package steps.PetStore.Pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;


public class PesquisarPorUmPetInexistente {

    private Response response;

    @Given("que eu acesso o endpoint de busca de pets")
    public void queEuAcessoOEndpointDeBuscaDePets() throws InterruptedException {
        int petId;
        petId = 1982;

        response = RestAssured
                .given()
                .header("Accept", "application/json")
                .when()
                .request(Method.GET, "https://petstore.swagger.io/v2/pet/" + petId);

    }

    @When("eu informo um petId que nao esta cadastrado")
    public void euInformoUmPetIdQueNaoEstaCadastrado() {
    }

    @Then("o servico deve retornar um status {int}")
    public void oServicoDeveRetornarUmStatus(int arg0) {
        response.then().statusCode(404);
    }

    @And("a mensagem Pet not found deve estar presente na resposta")
    public void aMensagemPetNotFoundDeveEstarPresenteNaResposta() {
            response.then()
                    .body("code", equalTo(1))
                    .body("type", equalTo("error"))
                    .body("message", equalTo("Pet not found"))
                    .extract()
                    .response();

        System.out.println(response.asString());
        }



}


