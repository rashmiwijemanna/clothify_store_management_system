package model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Customer {
    private String id;
    private String title;
    private String name;
    private LocalDate DOB;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
}
