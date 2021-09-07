package edu.act.moneytransfer.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // https://en.wikipedia.org/wiki/Builder_pattern
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is mandatory.")
    @Column(nullable = false)
    @Size(max = 15, min = 3)
    private String firstName;

    @NotBlank(message = "Middle name is mandatory.")
    @Column(nullable = false)
    @Size(max = 15)
    private String middleName;

    @NotBlank(message = "Last name is mandatory.")
    @Column(nullable = false)
    @Size(max = 15)
    private String lastName;

    @NotBlank(message = "Email is mandatory.")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Phone number is mandatory.")
    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @NotNull(message = "Date of birth is mandatory.")
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @NotNull(message = "Pin is mandatory.")
    @Column(nullable = false)
    private Integer pin;

    // assign default value
    private Boolean isVerified = Boolean.TRUE;

    // assign default value
    private Double balance = 0.0;
}
