package com.haulmount.test_task.service.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

public class CustomerDTO {

    private UUID id;

    @NotNull
    @Size(min = 10, max = 120,
            message = "must be between 10 and 120 characters")
    private String fullyQualifiedName;

    @NotNull
    @Pattern(regexp = "[0-9]")
    private String phoneNumber;

    @NotNull
    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "[0-9]")
    @Size(min = 10, message = "must be 10 character")
    private String passportNumber;

    public CustomerDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullyQualifiedName() {
        return fullyQualifiedName;
    }

    public void setFullyQualifiedName(String fullyQualifiedName) {
        this.fullyQualifiedName = fullyQualifiedName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerDTO that = (CustomerDTO) o;

        if (fullyQualifiedName != null ? !fullyQualifiedName.equals(that.fullyQualifiedName) : that.fullyQualifiedName != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return passportNumber != null ? passportNumber.equals(that.passportNumber) : that.passportNumber == null;
    }

    @Override
    public int hashCode() {
        int result = fullyQualifiedName != null ? fullyQualifiedName.hashCode() : 0;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (passportNumber != null ? passportNumber.hashCode() : 0);
        return result;
    }
}
