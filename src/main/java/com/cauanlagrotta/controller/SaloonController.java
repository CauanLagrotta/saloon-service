package com.cauanlagrotta.controller;

import com.cauanlagrotta.mapper.SaloonMapper;
import com.cauanlagrotta.model.Saloon;
import com.cauanlagrotta.payload.dto.SaloonDTO;
import com.cauanlagrotta.payload.dto.UserDTO;
import com.cauanlagrotta.service.SaloonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saloons")
@RequiredArgsConstructor
public class SaloonController {

  private final SaloonService saloonService;

  @PostMapping
  public ResponseEntity<SaloonDTO> create(@RequestBody SaloonDTO saloonDTO){
    UserDTO user = new UserDTO();
    user.setId(1L);

    Saloon saloon = saloonService.create(saloonDTO, user);

    SaloonDTO first = SaloonMapper.mapToDTO(saloon);

    return ResponseEntity.ok(first);
  }

  @PatchMapping("/{saloonId}")
  public ResponseEntity<SaloonDTO> update(@PathVariable("saloonId") Long saloonId,
                                          @RequestBody SaloonDTO saloonDTO){

    UserDTO user = new UserDTO();
    user.setId(1L);

    Saloon saloon = saloonService.update(saloonDTO, user, saloonId);

    SaloonDTO toDTO = SaloonMapper.mapToDTO(saloon);

    return ResponseEntity.ok(toDTO);
  }

  @GetMapping
  public ResponseEntity<List<SaloonDTO>> list(){

    List<Saloon> saloons = saloonService.getAll();

    List<SaloonDTO> saloonList = saloons.stream().map(SaloonMapper::mapToDTO).toList();

    return ResponseEntity.ok(saloonList);
  }

  @GetMapping("/{saloonId}")
  public ResponseEntity<SaloonDTO> getById(@PathVariable("saloonId") Long saloonId){

    Saloon saloon = saloonService.getById(saloonId);

    SaloonDTO toDTO = SaloonMapper.mapToDTO(saloon);

    return ResponseEntity.ok(toDTO);
  }

  @GetMapping("/search")
  public ResponseEntity<List<SaloonDTO>> search(@RequestParam("city") String city){

    List<Saloon> saloons = saloonService.getAllByCity(city);

    List<SaloonDTO> saloonList = saloons.stream().map(SaloonMapper::mapToDTO).toList();

    return ResponseEntity.ok(saloonList);
  }

  @GetMapping("/owner/{ownerId}")
  public ResponseEntity<SaloonDTO> getByOwnerId(@PathVariable("ownerId") Long ownerId){

    UserDTO user = new UserDTO();
    user.setId(1L);

    Saloon saloon = saloonService.getByOwnerId(user.getId());

    SaloonDTO toDTO = SaloonMapper.mapToDTO(saloon);

    return ResponseEntity.ok(toDTO);
  }
}
