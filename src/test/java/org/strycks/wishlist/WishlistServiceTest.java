package org.strycks.wishlist;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import org.strycks.wishlist.dto.WishRequestDTO;
import org.strycks.wishlist.dto.WishResponseDTO;
import org.strycks.wishlist.model.Wish;
import org.strycks.wishlist.model.WishStatus;
import org.strycks.wishlist.repository.TagRepository;
import org.strycks.wishlist.repository.WishRepository;
import org.strycks.wishlist.service.WishlistService;

@ExtendWith(MockitoExtension.class)
public class WishlistServiceTest {
  @Mock
  private WishRepository wishRepository;
  @Mock
  private TagRepository tagRepository;
  @InjectMocks
  private WishlistService wishlistService;

  @Test
  public void testGetWish() {
    Wish wish = new Wish();
    wish.setName("abc");

    Mockito.when(wishRepository.findById(1L)).thenReturn(Optional.of(wish));

    Assertions.assertEquals("abc", wishlistService.getWish(1).getName());
  }

  @Test
  public void testGetAllWishes() {
    Wish wish = new Wish();
    wish.setName("bcd");
    Wish wish2 = new Wish();
    wish2.setName("anc");
    Wish wish3 = new Wish();
    wish3.setName("lop");
    List<Wish> wishes = List.of(wish, wish2, wish3);

    Mockito.when(wishRepository.findAll()).thenReturn(wishes);

    List<String> names = List.of("bcd", "anc", "lop");
    Assertions.assertEquals(names, wishlistService.getAllWishes(Pageable.ofSize(10)).stream().map(WishResponseDTO::getName).toList());
  }

  @Test
  public void testReplaceWish() {
    WishRequestDTO request = new WishRequestDTO();
    request.setName("def");
    request.setStatus("PENDING");
    Wish wish = new Wish();
    wish.setName("abc");
    wish.setStatus(WishStatus.PENDING);

    Mockito.when(wishRepository.findById(1L)).thenReturn(Optional.of(wish));

    Assertions.assertEquals("def", wishlistService.replaceWish(1, request).getName());
  }
}
