package com.hostbook.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDTO {
	
	@NotEmpty(message = "Name must not be empty")
	@Size(min = 2, max=20,message = "Name should have atleast 2 characters")
	private String firstName;
	  @NotBlank(message = "Please enter last name")
	private String lastName;
	 @NotBlank(message = "Please enter the gender")
	private String gender;
	  	
		@Pattern(regexp = "(^$|[0-9]{6,14})", message = "Please enter a valid phone number")
	    @NotBlank(message = "Please enter the phone number")
	private String mobile;
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-[$&+,:;=?@#|'<>-^*()%!]]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Please enter a valid email address")
    @NotBlank(message = "Please enter the email")	
	private String email;
	 @NotBlank(message = "Please enter Address")
	private String address;
	 @NotBlank(message = "Please enter role")
	private String role;

}
