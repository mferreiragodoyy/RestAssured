package steps.PetStore.Pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static org.hamcrest.core.IsEqual.equalTo;


public class PesquisarPorPetsComStatusPending {

    private Response response;

    @Given("que eu acesso o endpoint de busca")
    public void queEuAcessoOEndpointDeBusca() throws InterruptedException {
        String status = "pending";

        response = RestAssured
                .given()
                .header("Accept", "application/json")
                .when()
                .request(Method.GET, "https://petstore.swagger.io/v2/pet/findByStatus?status=" + status);
        System.out.println(response.asString());
    }

    @When("eu informo o status pending")
    public void euInformoOStatusPending() {
    }

    @Then("o servico deve retornar o status code {int}")
    public void oServicoDeveRetornarOStatusCode(int arg0) {
        response.then().statusCode(200);
    }


    @And("o corpo da resposta deve conter a lista de pets com status pending")
    public void oCorpoDaRespostaDeveConterAListaDePetsComStatusPending() {

        response.then()
                .body("[0].status", equalTo("pending"))
                .body("[1].status", equalTo("pending"))
                .extract();

        String status0 = response.jsonPath().getString("[0].status");
        String status1 = response.jsonPath().getString("[1].status");

        if ("pending".equals(status0) && "pending".equals(status1)) {
            System.out.println("O serviço foi executado com sucesso e retornou somente o status pending");
        }
    }
}


