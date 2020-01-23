package org.ron.beautiful_monolith.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.ron.beautiful_monolith.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void findUserByIdShouldReturnUser() throws Exception {
        this.mockMvc.perform(get("/users/{id}", Long.toString(1L)))
                .andDo(print())
                .andExpect(jsonPath("$.username", is("kts1021")));
    }

    @Test
    public void findNotExistingUserShouldReturn404() throws Exception {
        this.mockMvc.perform(get("/users/{id}", Long.toString(10L)))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void findAllUsersShouldSucceed() throws Exception {
        this.mockMvc.perform(get("/users")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$[0].username", is("kts1021"))).andExpect(jsonPath("$[1].username", is("ksh1021")));
    }

    @Test
    public void createUserWithExistingUsernameShouldFail() throws Exception {
        User user = User.ByUserUsername()
                .username("kts1021")
                .build();

        this.mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(user)))
                .andDo(print())
                .andExpect(status().isConflict());
    }

    @Test
    public void createNonExistingUserShouldSucceed() throws Exception {
        User user = User.ByUserUsername()
                .username("kts1021c")
                .build();

        this.mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(user)))
                .andDo(print()).andExpect(status().isCreated()).andExpect(jsonPath("$.username", is("kts1021c")));
    }

    @Test
    public void updateUserUsernameWithNonExistingOneShouldSucceed() throws Exception {
        User user = User.ByUserIdAndUsername()
                .id(1L)
                .username("kts1021cc")
                .build();

        this.mockMvc.perform(patch("/users").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(user)))
                .andDo(print())
                .andExpect(status().isNoContent());

        this.mockMvc.perform(get("/users/{id}", Long.toString(1L)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is("kts1021cc")));
    }

    @Test
    public void updateUserUsernameWithExistingOneShouldFail() throws Exception {
        User user = User.ByUserIdAndUsername()
                .id(1L)
                .username("ksh1021")
                .build();

        this.mockMvc.perform(patch("/users").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(user)))
                .andDo(print())
                .andExpect(status().isConflict());
    }
}
