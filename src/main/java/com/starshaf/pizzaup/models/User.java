package com.starshaf.pizzaup.models;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String city;
    private String address;
    private String phoneNumber;
}
