package org.example.teacheradress.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddressDTO {
    @NotNull(message = "the id cannot be empty")
    private Integer teacherId;
    @NotEmpty(message = "area cannot be empty")
    private String area;
    @NotEmpty(message = "street cannot be empty")
    private String street;
    @NotNull(message = "building number cannot be empty")
    private Integer buildingNumber;
}
