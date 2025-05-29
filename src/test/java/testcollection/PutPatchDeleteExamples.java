package testcollection;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {
	
    @Test
    public void testPut(){
    
//    Map<String, Object> map = new HashMap<String, Object>();
//    map.put("name","Raghav");
//    map.put("job", "Teacher");
    
    JSONObject request = new JSONObject();
    
    request.put("name", "Venkat");
    request.put("job", "Student");
    
    System.out.println(request.toJSONString());
    
    baseURI = "https://reqres.in/api";
    
    given().
    	header("Content-type", "application/json").
    	contentType(ContentType.JSON).
    	accept(ContentType.JSON).
    	body(request.toJSONString()).
    when().
    	put("/users?page=2").
    then().
    	statusCode(200)
    	.log().all();
    		
    }

    
    
    
}
