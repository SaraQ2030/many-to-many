package org.example.teacheradress.Service;

import lombok.RequiredArgsConstructor;
import org.example.teacheradress.API.ApiException;
import org.example.teacheradress.DTO.AddressDTO;
import org.example.teacheradress.Model.Address;
import org.example.teacheradress.Model.Teacher;
import org.example.teacheradress.Repository.AddressRepository;
import org.example.teacheradress.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacherId());
        if (teacher == null) {
            throw new ApiException("not found teacher id");
        }

        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO){
        Address a=addressRepository.findAddressById(addressDTO.getTeacherId());
        if (a==null){
            throw new ApiException("not found address");
        }

        a.setArea(addressDTO.getArea());
        a.setStreet(addressDTO.getStreet());
        a.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(a);
    }

    public void deleteAddress(Integer id){
        Address a=addressRepository.findAddressById(id);
        if (a==null){
            throw new ApiException("not found address");
        }

        addressRepository.delete(a);
    }
}
