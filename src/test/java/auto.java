import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;

public class auto {

    @Test
    public void processEmails() {
        // Base URLs
        String getBaseURL = "https://www.brizy.cloud/api/users";
        String patchBaseURL = "https://www.brizy.cloud/api/users/";

        // Authorization token
        String authToken = "YTU4NDQ5YzRhY2FiNzE4ZjU1NjJjNDllMmZmMDdhMzJkYzc0YzllMGFiMDg3NWU4NzJjMzA0YzA1YzkyZTdmMg";

        // Array of emails
        List<String> emails = Arrays.asList(
                "utkarsh@learnyst.com","ashish.kumar@learnyst.com");

        for (String email : emails) {
            try {
                // Step 1: Make GET request to fetch user ID by email
                Response getResponse =
                        given()
                                .header("Content-Type", "application/json")
                                .header("x-auth-user-token", authToken)
                                .queryParam("page", 1)
                                .queryParam("count", 50)
                                .queryParam("email", email)
                                .when()
                                .get(getBaseURL);

                // Print GET response
                System.out.println("GET Response for email " + email + ": " + getResponse.getBody().asString());

                // Extract the ID from the JSON response (handle array structure)
                List<Object> responseList = getResponse.jsonPath().getList("$"); // Extract the root JSON array
                String userId = null;

                if (!responseList.isEmpty()) {
                    // Get the first object's "id"
                    userId = getResponse.jsonPath().getString("[0].id");
                }

                if (userId != null && !userId.isEmpty()) {
                    // Step 2: Make PATCH request to remove pro_package for the user
                    String payload = "{\"pro_package\": \"remove\"}";

                    Response patchResponse =
                            given()
                                    .header("Content-Type", "application/json")
                                    .header("x-auth-user-token", authToken)
                                    .body(payload)
                                    .when()
                                    .patch(patchBaseURL + userId);

                    // Print PATCH response
                    System.out.println("PATCH Response for email " + email + ": " + patchResponse.getBody().asString());
                    System.out.println("PATCH Status Code for email " + email + ": " + patchResponse.getStatusCode());
                } else {
                    System.out.println("User ID not found for email: " + email);
                }
            } catch (Exception e) {
                System.out.println("An error occurred for email " + email + ": " + e.getMessage());
            }
        }
    }
}
