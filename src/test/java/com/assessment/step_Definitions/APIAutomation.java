package com.assessment.step_Definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

public class APIAutomation {
    @When("Use Get and Delete methods, see successful Status Codes")
    public void useGetAndDeleteMethodsSeeSuccessfulStatusCodes() {

        Response responseGet = RestAssured.get("http://dummy.restapiexample.com/api/v1/employees");
        responseGet.body().prettyPrint();

        Assert.assertEquals(200,responseGet.getStatusCode());

        Response responseDelete = RestAssured.delete("http://dummy.restapiexample.com/api/v1/delete/3");

        Assert.assertEquals(200, responseDelete.getStatusCode());

    }

    @Then("Get a specific Employee details")
    public void getASpecificEmployeeDetails() {
        Response responseGetSpecific = RestAssured.get("http://dummy.restapiexample.com/api/v1/employee/1");
        responseGetSpecific.body().prettyPrint();

        Assert.assertEquals(200,responseGetSpecific.getStatusCode());
    }

    @And("Delete an Employee, and see message : successfully! deleted Records")
    public void deleteAnEmployeeAndSeeMessageSuccessfullyDeletedRecords() {

        Response responseDeleteEmployee = RestAssured.delete("http://dummy.restapiexample.com/api/v1/delete/37");

        JsonPath jsonData = responseDeleteEmployee.jsonPath();
        String deletedMessage = jsonData.getString("message");

        Assert.assertEquals("Successfully! Record has been deleted",deletedMessage);

    }
}
