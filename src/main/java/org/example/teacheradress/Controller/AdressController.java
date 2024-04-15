package org.example.teacheradress.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.teacheradress.API.ApiResponse;
import org.example.teacheradress.DTO.AddressDTO;
import org.example.teacheradress.Model.Teacher;
import org.example.teacheradress.Service.AddressService;
import org.example.teacheradress.Service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AdressController {
    private final AddressService addressService;
    Logger logger= LoggerFactory.getLogger(AdressController.class);

    @GetMapping("/get")
    public ResponseEntity getAllAddress(){

        logger.info("inside get all address");
        return ResponseEntity.status(200).body(addressService.getAllAddress());
    }


    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        logger.info("inside add address");
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("address added"));
    }
    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO addressDTO){
        logger.info("inside update address");
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("address update"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id ){
        logger.info("inside delete address");
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("address deleted"));
    }

}
