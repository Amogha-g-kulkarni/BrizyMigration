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
                "utkarsh@learnyst.com",
                "mohitchugh9@gmail.com", "ashwin.aac.training@gmail.com", "abhi.nnit@gmail.com",
                "academy@pharmacy.page", "ziyan@premierpartners.edu.lk", "gu.s.paiva@gmail.com",
                "academy@adzefit.com", "rohanlakhne@gmail.com", "agroacademy.in@gmail.com",
                "ajeyaed@gmail.com", "akash@learnyst.com", "alaqmarh1313@gmail.com",
                "enquiry@aldine.edu.in", "sundeepeddu@gmail.com", "bellavista@alphaonecollege.com.au",
                "support@anilinsights.in", "anujgupta3391@gmail.com", "anupvarma@hotmail.com",
                "arkmrcog@gmail.com", "arvindseoweb@gmail.com", "honestashwinc@gmail.com",
                "asmitapatel.gsot@gmail.com", "atulsharma.cse@gmail.com",
                "gate@careeravenues.co.in", "bankersuniversityinbox@gmail.com",
                "crashcourse6to10@gmail.com", "whatnextlearning@gmail.com",
                "support@blackperldfir.com", "bodheeprep@gmail.com", "admin@tharunraj.com",
                "dineshfoss@gmail.com", "officebfacrnc@gmail.com", "chaineux@hotmail.com",
                "himanshusharma26june@gmail.com", "higher.education@cii.in",
                "cmr@bizoticedtech.com", "support@codingrad.com",
                "ranjan+admin@learnyst.com", "pinnaclecoachingnlb@gmail.com",
                "whycse1@gmail.com", "arjanhazra.2001@gmail.com",
                "datafortrader@gmail.com", "debojyotiboruahonline@gmail.com",
                "devopswithcloud@gmail.com", "sales.careergeek@gmail.com",
                "helpmedharam143@gmail.com", "dinochase2024@gmail.com", "info@diplomathon.in",
                "doc.vamsidhar@gmail.com", "mail@docemy.com", "haarrssh@e-learn.net.in",
                "upscaxis@gmail.com", "educare2470@gmail.com", "educate.bharat21@gmail.com",
                "info@edumaster.ind.in", "sanjeev_suman2001@yahoo.com",
                "amit.23.kumar.88@gmail.com", "ekceltech@gmail.com",
                "vyomdeep2000@yahoo.com", "mohan@finmoindia.com", "a.matun0304@gmail.com",
                "ayushi@fpa.edu.in", "freshrideecommerce@gmail.com",
                "biplabadhikary.gateit@gmail.com", "geographerspoint@gmail.com",
                "pavan.kumar@getsalesforce.com", "arpit.garg@riskman.in",
                "gootleeglobal@gmail.com", "gurukkulsurgery@gmail.com",
                "1008guruprasad@gmail.com", "thanksvinayofficial@gmail.com",
                "himanshukr115@gmail.com", "oxford@bizoticedtech.com",
                "chez@indiacollegefinder.org", "thelead@indiclaw.com",
                "anu04450@gmail.com", "qamar@infortified.com",
                "chirayu+89@learnyst.com", "jyothish@iplusts.com",
                "iplustrainingsolutions@gmail.com", "iquestict@gmail.com",
                "ismcircle@gmail.com", "admin@jarvis.ltd",
                "jdvastudesigns@gmail.com", "jonichols@me.com",
                "devansh@learnyst.com", "judisure@gmail.com", "khesavrao32@gmail.com",
                "kickstartbusiness.club@gmail.com", "mhailinabil@gmail.com",
                "avocadoakash@gmail.com", "questionkota@gmail.com",
                "mailbox@designkubo.com", "lawgiriofficial@gmail.com",
                "learncodewithdurgesh@gmail.com", "team@learnkarts.com",
                "bittusonowal2@gmail.com", "mail@learnx.co.in",
                "contactleelabhoomi@gmail.com", "controller@lawaspirants.com",
                "mahatayari4@gmail.com", "manasra68@hotmail.com",
                "hi.learnskillstoday@gmail.com", "manoharkumarsony@gmail.com",
                "editor@dailyrounds.org", "Thelrdimaster@gmail.com",
                "mba@cloudninecare.live", "maverickktech@gmail.com",
                "haleefafsal@gmail.com", "pranav.pant@mbakaro.in",
                "support@mbaskills.in", "merchantnavydecodedshorts@gmail.com",
                "mgmentorship@gmail.com", "mockswizard@gmail.com",
                "moneyclever.in@gmail.com", "connect@myhealthschool.in",
                "utkarsh@learnyst.com", "sowcreativestudios@gmail.com",
                "support@namastedev.com", "ashish.kumar@learnyst.com",
                "wizyowl@gmail.com", "dev@simplyy.in", "ashishirse.38@gmail.com",
                "prathambanker@gmail.com", "aknowledgist01@gmail.com",
                "admin@prepmedico.com", "promeritbankers@gmail.com",
                "qsmilesacademy@gmail.com", "rajdeep.mukherjee07@gmail.com",
                "drfinco@gmail.com", "raseadhyay@gmail.com",
                "a.deepaksurana@gmail.com", "gowtham@learnyst.com",
                "support@coolbeansacademy.com", "roadtocat99@gmail.com",
                "amitisrani22@gmail.com", "sachin@learnyst.com",
                "sakshi@learnyst.com", "sanyaldk@gmail.com",
                "david.sarika@hotmail.ca", "satheesh18499@gmail.com",
                "saurabh@learnyst.com", "info@sachinbhatia.com",
                "ram@ndskills.in", "info@scoreplusca.in", "vishal@learnyst.com",
                "sharath@learnyst.com", "2coschool@gmail.com",
                "vidit@shrividhya.in", "shuruschoolofficial@gmail.com",
                "sit@bizoticedtech.com", "info@skillbez.com",
                "info@skillsblock.in", "info@skillslash.com",
                "pavankrishna@smartlearnedtech.com", "smart.programming.2101@gmail.com",
                "support@physicaleducationprep.com", "supathacademy@outlook.com",
                "suprmentr@gmail.com", "hello@takshzila.com",
                "TRAINING@TALENTMARKACADEMY.COM", "abhiramvmurthy@gmail.com",
                "support@technodrivingmastery.com", "teluskotraining@gmail.com",
                "paulsonchelliah39@gmail.com", "testurself.gate@gmail.com",
                "gupta.tashu171@gmail.com", "anurag@theartofsolotraveling.com",
                "thecatwayofficial@gmail.com", "hello@themedprep.com",
                "hi@thethinkschool.com", "hemantverma2595@gmail.com",
                "thoughtphysix@gmail.com", "tkhan6080@gmail.com",
                "teachinglawsofindia@gmail.com", "pavneet.tmentors@gmail.com",
                "mailmesatyambhatt@gmail.com", "admin@trielab.io",
                "tutorplusplus@rediffmail.com", "karthik@learnyst.com",
                "reachvarghesepolson@gmail.com", "vijay@xerut.com",
                "virtualizatepr@gmail.com", "imthomas1973@gmail.com",
                "helloshyamkarri@gmail.com", "durgesh.b@wow-ppl.com",
                "admin@learnwwa.com", "info.yatharthias");

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
