package com.cauanlagrotta.mapper;

import com.cauanlagrotta.model.Saloon;
import com.cauanlagrotta.payload.dto.SaloonDTO;

public class SaloonMapper {

  public static SaloonDTO mapToDTO(Saloon saloon){
    SaloonDTO saloonDTO = new SaloonDTO();
    saloonDTO.setId(saloon.getId());
    saloonDTO.setName(saloon.getName());
    saloonDTO.setAddress(saloon.getAddress());
    saloonDTO.setCity(saloon.getCity());
    saloonDTO.setImages(saloon.getImages());
    saloonDTO.setPhoneNumber(saloon.getPhoneNumber());
    saloonDTO.setClosingTime(saloon.getClosingTime());
    saloonDTO.setOpeningTime(saloon.getOpeningTime());
    saloonDTO.setOwnerId(saloon.getOwnerId());

    return saloonDTO;
  }
}
