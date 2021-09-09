package edu.act.moneytransfer;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class AccountControllerIntegrationTest {

    private final String ACCOUNT_ENDPOINT = "/api/account/create";
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldCreateAnAccountWithValidInformation() throws Exception {
        String payload = "{\n" +
                "  \"firstName\": \"Jane2\",\n" +
                "  \"middleName\": \"G.2\",\n" +
                "  \"lastName\": \"Doe2\",\n" +
                "  \"phoneNumber\": \"+1898882822\",\n" +
                "  \"email\": \"janedoe2@gmail.com\",\n" +
                "  \"dateOfBirth\": \"2000-01-01\",\n" +
                "  \"pin\": 233222\n" +
                "}";
        mockMvc.perform(
                        post(ACCOUNT_ENDPOINT)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payload)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":3,\"firstName\":\"Jane2\",\"middleName\":\"G.2\"," +
                        "\"lastName\":\"Doe2\",\"email\":\"janedoe2@gmail.com\",\"phoneNumber\":\"+1898882822\"," +
                        "\"dateOfBirth\":\"2000-01-01\",\"pin\":233222,\"isVerified\":true,\"balance\":0.0}"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
    }

    @Ignore
    public void shouldFailBecausePhoneNumberAndEmailIsNotEmpty() throws Exception {

        String payload = "{\n" +
                "  \"firstName\": \"Jane2\",\n" +
                "  \"middleName\": \"G.2\",\n" +
                "  \"lastName\": \"Doe2\",\n" +
                "  \"dateOfBirth\": \"2000-01-01\",\n" +
                "  \"pin\": 233222\n" +
                "}";

        mockMvc.perform(
                        post(ACCOUNT_ENDPOINT)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payload)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    // Sad path - failing
}
