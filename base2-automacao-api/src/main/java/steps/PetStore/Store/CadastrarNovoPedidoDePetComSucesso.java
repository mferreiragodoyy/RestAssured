package steps.PetStore.Store;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;


public class CadastrarNovoPedidoDePetComSucesso {

    private Response response;

    @Given("que eu acesso o endpoint store order")
    public void queEuAcessoOEndpointStoreOrder() throws InterruptedException {

        String body = "{ " +
                "\"id\": 1, " +
                "\"petId\": 1, " +
                "\"quantity\": 1, " +
                "\"shipDate\": \"2024-08-13T00:16:25.549Z\", " +
                "\"status\": \"placed\", " +
                "\"complete\": true " +
                "}";

        response = RestAssured
                .given()
                .contentType("application/json")
                .body(body)
                .when()
                .post("https://petstore.swagger.io/v2/store/order");

}

    @When("eu informo os dados solicitados para o pedido")
    public void euInformoOsDadosSolicitadosParaOPedido() {
    }

    @And("eu clico em executar")
    public void euClicoEmExecutar() {
    }

    @Then("o servico deve retornar um status code {int}")
    public void oServicoDeveRetornarUmStatusCode(int arg0) {
        response.then().statusCode(200);
    }

    @And("o corpo da resposta deve conter os dados da inclusao do pedido")
    public void oCorpoDaRespostaDeveConterOsDadosDaInclusaoDoPedido() {
            response.then()
                    .body("id", notNullValue())
                    .body("petId", equalTo(1))
                    .body("quantity", equalTo(1))
                    .body("shipDate", notNullValue())
                    .body("status", equalTo("placed"))
                    .body("complete", equalTo(true));
        }
    }


