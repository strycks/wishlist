package org.strycks.wishlist.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.strycks.wishlist.dto.WishRequestDTO;
import org.strycks.wishlist.dto.WishResponseDTO;
import org.strycks.wishlist.handler.NotFoundException;
import org.strycks.wishlist.model.Tag;
import org.strycks.wishlist.model.Wish;
import org.strycks.wishlist.model.WishCondition;
import org.strycks.wishlist.model.WishMethod;
import org.strycks.wishlist.model.WishStatus;
import org.strycks.wishlist.repository.TagRepository;
import org.strycks.wishlist.repository.WishRepository;

/**
 * The type Wishlist service.
 */
@AllArgsConstructor
@Service
public class WishlistService {
  private final WishRepository wishRepository;
  private final TagRepository tagRepository;

  /**
   * Create wish response dto.
   *
   * @param request the request
   * @return the wish response dto
   */
  @Transactional
  public WishResponseDTO createWish(WishRequestDTO request) {
    Wish wish = mapToWish(request);
    wishRepository.save(wish);
    return mapToResponse(wish);
  }

  /**
   * Gets wish.
   *
   * @param id the id
   * @return the wish
   */
  public WishResponseDTO getWish(Long id) {
    Optional<Wish> wish = wishRepository.findById(id);
    return wish.map(this::mapToResponse)
               .orElseThrow(() -> new NotFoundException("Resource Not Found"));
  }

  /**
   * Gets all wishes.
   *
   * @return the all wishes
   */
  public List<WishResponseDTO> getAllWishes() {
    List<Wish> wishes = wishRepository.findAll();
    return wishes.stream().map(this::mapToResponse).toList();
  }

  /**
   * Map to wish wish.
   *
   * @param dto the dto
   * @return the wish
   */
  @Transactional
  public Wish mapToWish(WishRequestDTO dto) {
    if (dto == null) {
      return null;
    }

    Wish wish = new Wish();
    wish.setName(dto.getName());
    wish.setPrice(dto.getPrice());
    wish.setNote(dto.getNote());
    wish.setMeter(dto.getMeter());
    wish.setQuantity(dto.getQuantity());
    wish.setAbout(dto.getAbout());
    wish.setDeadline(dto.getDeadline());
    wish.setStatus(WishStatus.valueOf(dto.getStatus()));

    wish.setRetailers(new HashSet<>(dto.getRetailers()));
    wish.setUrls(new HashSet<>(dto.getUrls()));
    wish.setConditions(dto.getConditions().stream()
        .filter(cond -> !cond.isBlank())
        .map(WishCondition::valueOf).collect(Collectors.toSet()));
    wish.setMethods(dto.getMethods().stream()
        .filter(cond -> !cond.isBlank())
        .map(WishMethod::valueOf).collect(Collectors.toSet()));

    List<Tag> createdTags = tagRepository.findByNameIn(dto.getTags());
    Set<String> createdNames = createdTags.stream()
        .map(Tag::getName).collect(Collectors.toSet());
    createdTags.forEach(wish::addTag);
    dto.getTags().stream()
        .filter(tagName -> !createdNames.contains(tagName))
        .forEach(tagName -> {
          Tag tmp = new Tag();
          tmp.setName(tagName);
          tagRepository.save(tmp);
          wish.addTag(tmp);
        });
    return wish;
  }

  /**
   * Map to response wish response dto.
   *
   * @param wish the wish
   * @return the wish response dto
   */
  public WishResponseDTO mapToResponse(Wish wish) {
    if (wish == null) {
      return null;
    }

    WishResponseDTO dto = new WishResponseDTO();
    dto.setId(wish.getId());
    dto.setName(wish.getName());
    dto.setPrice(wish.getPrice());
    dto.setNote(wish.getNote());
    dto.setMeter(wish.getMeter());
    dto.setQuantity(wish.getQuantity());
    dto.setAbout(wish.getAbout());
    dto.setStatus(wish.getStatus().toString());
    dto.setDeadline(wish.getDeadline());
    dto.setCreationDate(wish.getCreationDate());
    dto.setTags(wish.getTags().stream().map(Tag::getName).toList());
    dto.setConditions(wish.getConditions().stream().map(Enum::toString).toList());
    dto.setMethods(wish.getMethods().stream().map(Enum::toString).toList());
    dto.setUrls(wish.getUrls().stream().toList());
    dto.setRetailers(wish.getRetailers().stream().toList());

    return dto;
  }
}
