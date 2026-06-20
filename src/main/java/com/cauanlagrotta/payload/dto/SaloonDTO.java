package com.cauanlagrotta.payload.dto;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

public class SaloonDTO {

  private Long id;

  private String name;

  private List<String> images;

  private String address;

  private String phoneNumber;

  private String email;

  private String city;

  private Long ownerId;

  private LocalTime openingTime;

  private LocalTime closingTime;
}
