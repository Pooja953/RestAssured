import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestCreateEmployee {

    @Test(dataProvider = "EmployeeDataProvider")
    void addNewEmployee(String name ,String job){

        RestAssured.baseURI = "https://reqres.in";
        JSONObject requestParam = new JSONObject();
        requestParam.put("name",name);
        requestParam.put("job",job);
        RequestSpecification httpRequest = RestAssured.given().header("Content-Type","application/json").body(requestParam.toString());
        Response response = httpRequest.when().post("/api/users");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body : "+responseBody);


        int responseStatusCode = response.getStatusCode();
        Assert.assertEquals(responseStatusCode,201);

        Assert.assertEquals(responseBody.contains(name),true);

    }

    @DataProvider(name = "EmployeeDataProvider")
    String[][] getEmployeeData(){
        
        String[][] empData = {{"Chetu","QA"},{"Ramya","QA"},{"Dimple","QA"}};
        return empData;
    }
}
