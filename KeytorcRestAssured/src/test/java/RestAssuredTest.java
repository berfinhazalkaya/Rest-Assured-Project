import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class RestAssuredTest {


    @Test
    public void signInTest() {
        String data = "{\n" +
                "  \"email\": \"dummy@email.com\",\n" +
                "  \"password\": \"123456\"\n" +
                "}";
        given().
                contentType(ContentType.JSON).
                body(data).
                when().
                post("http://api.fakeshop-api.com/users/signin").
                then().
                statusCode(201);
    }

    @Test
    public void getCart() {
        given().
                contentType(ContentType.JSON).
                when().
                post("http://api.fakeshop-api.com/carts/getCart").
                then().
                statusCode(404);
    }

    @Test
    public void addToCart() {
        String postData = "{\n" +
                "  \"id\": \"1\"\n" +
                "}";
        given().
                contentType(ContentType.JSON).
                body(postData).
                when().
                post("http://api.fakeshop-api.com/carts/addToCart").
                then().
                statusCode(401);
    }
}
