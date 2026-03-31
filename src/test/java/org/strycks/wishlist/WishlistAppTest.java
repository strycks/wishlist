package org.strycks.wishlist;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.strycks.wishlist.dto.WishRequestDTO;
import tools.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
public class WishlistAppTest {
  private final ObjectMapper objectMapper = new ObjectMapper();
  @Autowired
  private MockMvc mvc;

  @Test
  public void getWishTest() throws Exception {
    mvc.perform(
        get("/api/wishlist").with(user("test"))
    ).andExpect(status().isOk());
  }

  @Test
  public void postWishTest() throws Exception {
    String query = "$['name']";
    mvc.perform(
        post("/api/wishlist").with(user("test"))
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(makeMockWishRequest("syl"))))
        .andExpect(status().isCreated())
        .andExpect(jsonPath(query).value("syl"));
    mvc.perform(get("/api/wishlist/1").with(user("test")))
        .andExpect(status().isOk())
        .andExpect(jsonPath(query).value("syl"));
  }

  @Test
  public void putWishTest() throws Exception {
    String query = "$['name']";
    mvc.perform(
        post("/api/wishlist").with(user("test"))
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(makeMockWishRequest("syl")))
        )
        .andExpect(status().isCreated())
        .andExpect(jsonPath(query).value("syl"));
    mvc.perform(
        put("/api/wishlist/1").with(user("test"))
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(makeMockWishRequest("abc")))
        )
        .andExpect(status().isCreated())
        .andExpect(jsonPath(query).value("abc"));
    mvc.perform(get("/api/wishlist/1").with(user("test")))
        .andExpect(status().isOk())
        .andExpect(jsonPath(query).value("abc"));
  }

  private WishRequestDTO makeMockWishRequest(String name) {
    WishRequestDTO w = new WishRequestDTO();
    w.setName(name);
    w.setQuantity(1);
    w.setPrice(1L);
    w.setMeter(1);
    w.setStatus("PENDING");
    return w;
  }
}
