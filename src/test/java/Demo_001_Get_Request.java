import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.response.Response;
import io.restassured.specification.PreemptiveAuthSpec;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import java.lang.String;


public class Demo_001_Get_Request {

    @Test
   public void getWeatherDetails(){
        RestAssured.baseURI = "https://reqres.in/api/users/2";
//
//        PreemptiveBasicAuthScheme preemptiveBasicAuthScheme = new PreemptiveBasicAuthScheme();
//
//        preemptiveBasicAuthScheme.setUserName();
//        preemptiveBasicAuthScheme.setUserName();

//        RestAssured.authentication = preemptiveBasicAuthScheme;


        RequestSpecification httpRequest = RestAssured.given();

        Response httpResponse = httpRequest.request(Method.GET, "/Hyderabad");

        String response = httpResponse.getBody().asString();
        System.out.println(response);

//        ObjectMapper objectMapper = new ObjectMapper() {
//
//        String jsonString = objectMapper.writeValueAsString(myObject); // Serialization
//        MyObject myObject = objectMapper.readValue(jsonString, MyObject.class);

    }

}
