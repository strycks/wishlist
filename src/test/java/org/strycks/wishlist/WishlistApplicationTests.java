package org.strycks.wishlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.strycks.wishlist.model.Wish;
import tools.jackson.databind.ObjectMapper;

import java.time.Duration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class WishlistApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper mapper;

  @Test
  void contextLoads() {

  }

  @Test
  void showInserted() throws Exception {
    Wish wish = new Wish();
    wish.setName("Sylvanian");
    wish.setMeter(1);
    wish.setPrice(125000L);
    wish.getTags().add("sylvanian");
    wish.setQuantity(1);
    String jsonWish = mapper.writeValueAsString(wish);
    mockMvc.perform(post("/api/wishlist").contentType(MediaType.APPLICATION_JSON).content(jsonWish));
  }

}
