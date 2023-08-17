package com.example.myshop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderDto {

    private String firstname;
    private String lastname;
    private String address;
    private String postCode;
    private String city;

}
