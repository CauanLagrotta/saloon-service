package com.cauanlagrotta.service;

import com.cauanlagrotta.model.Saloon;
import com.cauanlagrotta.payload.dto.SaloonDTO;
import com.cauanlagrotta.payload.dto.UserDTO;

import java.util.List;

public interface SaloonService {
  Saloon create(SaloonDTO salon, UserDTO user);

  Saloon update(SaloonDTO salon, UserDTO user, Long saloonId);

  List<Saloon> getAll();

  void delete(Long id, UserDTO user);

  Saloon getById(Long id);

  Saloon getByOwnerId(Long ownerId);

  List<Saloon> getAllByCity(String city);
}
