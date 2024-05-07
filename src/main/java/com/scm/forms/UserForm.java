package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "User name is required...")
    @Size(min = 3, message = "Min 3 characters required")
    private String name;

    @NotBlank(message = "Email is required...")
    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Password is required...")
    @Size(min = 6, message = "Min 6 characters are required")
    private String password;

    @NotBlank(message = "About is required...")
    private String about;

    @Size(min = 6, max = 12, message = "Invalid phone number !")
    private String phoneNumber;
    

}
