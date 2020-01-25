package com.bct.msproducts2cl;

import com.bct.msproducts2cl.model.Product;
import com.bct.msproducts2cl.model.Supplier;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProjectStepDefs {

    @LocalServerPort
    private int port;

    private RestTemplate restTemplate = new RestTemplate();

    private String endpointUrl = "http://localhost";
    private Integer id = 252253114;
    private final String AUTHORIZATION = "Authorization";
    private final String TOKEN = "Token  eyJhbGciOiJIUzUxMiJ9.eyJ1c2VySWQiOiJudWxsIn0.TQlI5Vr-5_aQl0vzS8yZjHc5KkQ50jxu0Qyll39tOXP_qkPRFip2Z_5zLv4DX7jHNmYMHqTN2udgTpAurzkKrg";
    private HttpHeaders headers = new HttpHeaders();

    @Given("i can get a supplier")
    public void i_can_get_a_supplier() {
        String url = endpointUrl + ":" + port + "/rest/supplier/" + id;
        headers.set(AUTHORIZATION , TOKEN);
        HttpEntity entity =  new HttpEntity(headers);
        ResponseEntity<Supplier> supplier = restTemplate.exchange(url, HttpMethod.GET,entity,Supplier.class);
        assertTrue(supplier.getBody().getId().equals(252253114));
    }

    @When("^the client receives an ok status code (\\d+)$")
    public void the_client_receives_an_ok_status_code_200(int statusCode) {
        String url = endpointUrl + ":" + port + "/rest/supplier/" + id;
        headers.set(AUTHORIZATION , TOKEN);
        HttpEntity entity =  new HttpEntity(headers);
        ResponseEntity<Supplier> supplier = restTemplate.exchange(url, HttpMethod.GET,entity,Supplier.class);
        assertTrue(supplier.getStatusCode().value() == statusCode);
    }

    @Then("the client Receives an object")
    public void the_client_Receives_an_object() {
        String url = endpointUrl + ":" + port + "/rest/supplier/" + id;
        headers.set(AUTHORIZATION , TOKEN);
        HttpEntity entity =  new HttpEntity(headers);
        ResponseEntity<Supplier> supplier = restTemplate.exchange(url, HttpMethod.GET,entity,Supplier.class);
        assertEquals(3, supplier.getBody().getProducts().size());
    }

    @Given("some products have been stored in the database")
    public void someProductsHaveBeenStoredInTheDatabase() {
        String url = endpointUrl + ":" + port + "/rest/product/";
        headers.set(AUTHORIZATION , TOKEN);
        HttpEntity entity =  new HttpEntity(headers);
        ResponseEntity<List<Product>> products = restTemplate.exchange(url, HttpMethod.GET,entity,
                new ParameterizedTypeReference<List<Product>>(){});
        System.out.println(products.getBody().toString());
        assertTrue(products.getBody().size() > 0);
    }

    @When("the client makes a call to get rest product endpoint")
    public void theClientMakesACallToGetRestProductEndpoint() {
        String url = endpointUrl + ":" + port + "/rest/product/";
        headers.set(AUTHORIZATION , TOKEN);
        HttpEntity entity =  new HttpEntity(headers);
        ResponseEntity<List<Product>> products = restTemplate.exchange(url, HttpMethod.GET,entity,
                new ParameterizedTypeReference<List<Product>>(){});
        System.out.println(products.getBody().toString());
        assertTrue(products.getStatusCode().equals(HttpStatus.OK));
    }

    @Then("the client gets a list of products")
    public void theClientGetsAListOfProducts() {
        String url = endpointUrl + ":" + port + "/rest/product/";
        headers.set(AUTHORIZATION , TOKEN);
        HttpEntity entity =  new HttpEntity(headers);
        ResponseEntity<List<Product>> products = restTemplate.exchange(url, HttpMethod.GET,entity,
                new ParameterizedTypeReference<List<Product>>(){});
        System.out.println(products.getBody().toString());
        assertTrue(products.getBody().size() > 0);
    }

    @When("the client makes a call to PUT rest product endpoint")
    public void theClientMakesACallToPUTRestProductEndpoint() {
        Integer productId = 2;
        String url = endpointUrl + ":" + port + "/rest/product/" + productId;

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("qty", 1);

        headers.set(AUTHORIZATION , TOKEN);
        HttpEntity entity =  new HttpEntity(headers);
        ResponseEntity<Boolean> response = restTemplate.exchange(builder.toUriString(), HttpMethod.PUT,entity,Boolean.class);
        assertTrue(response.getBody());

    }

    @Then("the client gets product quantity updated to (\\d+)$")
    public void theClientGetsProductQuantityUpdated(int qty) {
        Integer productId = 2;
        String url = endpointUrl + ":" + port + "/rest/product/";
        headers.set(AUTHORIZATION , TOKEN);
        HttpEntity entity =  new HttpEntity(headers);
        ResponseEntity<List<Product>> products = restTemplate.exchange(url, HttpMethod.GET,entity,
                new ParameterizedTypeReference<List<Product>>(){});
        Product updatedProduct = products.getBody().stream()
                .filter(product -> product.getId().equals(productId))
                .findAny().orElse(new Product());
        assertTrue(updatedProduct.getQuantity().equals(qty));
    }

    @Given("there is a supplier stored in the database")
    public void thereIsASupplierStoredInTheDatabase() {
        Integer supplierId = 252253114;
        String url = endpointUrl + ":" + port + "/rest/supplier/" + id;
        headers.set(AUTHORIZATION , TOKEN);
        HttpEntity entity =  new HttpEntity(headers);
        ResponseEntity<Supplier> supplier = restTemplate.exchange(url, HttpMethod.GET,entity,Supplier.class);
        assertTrue(supplier.getBody().getId().equals(supplierId));
    }

    @When("the client makes a call to DELETE supplier endpoint")
    public void theClientMakesACallToDELETESupplierEndpoint() {
        Integer supplierId = 252253114;
        String url = endpointUrl + ":" + port + "/rest/supplier/" + id;
        headers.set(AUTHORIZATION , TOKEN);
        HttpEntity entity =  new HttpEntity(headers);
        ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.DELETE,entity,Boolean.class);
        assertEquals(true,  response.getBody());
    }

    @Then("the client Receives the list of suppliers and products updated")
    public void theClientReceivesTheListOfSuppliersAndProductsUpdated() {
        String url = endpointUrl + ":" + port + "/rest/product/";
        headers.set(AUTHORIZATION , TOKEN);
        HttpEntity entity =  new HttpEntity(headers);
        ResponseEntity<List<Product>> products = restTemplate.exchange(url, HttpMethod.GET,entity,
                new ParameterizedTypeReference<List<Product>>(){});
        System.out.println(products.getBody().toString());
        assertTrue(products.getBody().size() == 2);
    }
}
