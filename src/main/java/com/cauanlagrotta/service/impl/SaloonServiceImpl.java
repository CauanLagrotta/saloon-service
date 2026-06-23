package com.cauanlagrotta.service.impl;

import com.cauanlagrotta.model.Saloon;
import com.cauanlagrotta.payload.dto.SaloonDTO;
import com.cauanlagrotta.payload.dto.UserDTO;
import com.cauanlagrotta.repository.SaloonRepository;
import com.cauanlagrotta.service.SaloonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaloonServiceImpl implements SaloonService {

  private final SaloonRepository saloonRepository;

  @Override
  public Saloon create(SaloonDTO req, UserDTO user) {
    Saloon saloon = new Saloon();
    saloon.setName(req.getName());
    saloon.setAddress(req.getAddress());
    saloon.setEmail(req.getEmail());
    saloon.setCity(req.getCity());
    saloon.setImages(req.getImages());
    saloon.setOwnerId(user.getId());
    saloon.setPhoneNumber(req.getPhoneNumber());
    saloon.setOpeningTime(req.getOpeningTime());
    saloon.setClosingTime(req.getClosingTime());
    return saloonRepository.save(saloon);
  }

  @Override
  public Saloon update(SaloonDTO saloon, UserDTO user, Long saloonId) {
    Saloon existingSaloon = saloonRepository.findById(saloonId).orElse(null);

    if(existingSaloon == null){
      throw new RuntimeException("Saloon not found");
    }

    if(!existingSaloon.getOwnerId().equals(user.getId())){
      throw new RuntimeException("User is not the owner of this saloon");
    }

    existingSaloon.setName(saloon.getName());
    existingSaloon.setAddress(saloon.getAddress());
    existingSaloon.setEmail(saloon.getEmail());
    existingSaloon.setCity(saloon.getCity());
    existingSaloon.setImages(saloon.getImages());
    existingSaloon.setOwnerId(user.getId());
    existingSaloon.setPhoneNumber(saloon.getPhoneNumber());
    existingSaloon.setOpeningTime(saloon.getOpeningTime());
    existingSaloon.setClosingTime(saloon.getClosingTime());

    return saloonRepository.save(existingSaloon);
  }

  @Override
  public List<Saloon> getAll() {
    return saloonRepository.findAll();
  }

  @Override
  public Saloon getById(Long id) {
    Saloon saloon = saloonRepository.findById(id).orElse(null);
    if(saloon == null){
      throw new RuntimeException("Saloon not found");
    }
    return saloon;
  }

  @Override
  public Saloon getByOwnerId(Long ownerId) {
    return saloonRepository.findByOwnerId(ownerId);
  }

  @Override
  public List<Saloon> getAllByCity(String city) {
    return saloonRepository.searchSaloons(city);
  }
}
