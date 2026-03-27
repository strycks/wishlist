package org.strycks.wishlist;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.strycks.wishlist.dto.WishRequestDTO;
import org.strycks.wishlist.model.Wish;
import tools.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
public class WishlistAppTest {
  @Autowired
  private MockMvc mvc;

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  public void getWishTest() throws Exception {
    mvc.perform(
        get("/api/wishlist").with(user("test"))
    ).andExpect(status().isOk());
  }

  @Test
  public void postWish() throws Exception {
    mvc.perform(
        post("/api/wishlist").with(user("test"))
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(makeMockWishRequest())))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.name").value("syl"));
    mvc.perform(get("/api/wishlist/1").with(user("test")))
        .andExpect(status().isOk());
  }

  private WishRequestDTO makeMockWishRequest() {
    WishRequestDTO w = new WishRequestDTO();
    w.setName("syl");
    w.setQuantity(1);
    w.setPrice(1L);
    w.setMeter(1);
    w.setStatus("PENDING");
    return w;
  }
}
