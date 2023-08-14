package com.example.virtualpetapi.repository;
import org.springframework.data.repository.CrudRepository;
import com.example.virtualpetapi.model.VirtualPet;
import net.bytebuddy.implementation.bind.MethodDelegationBinder.MethodInvoker.Virtual;

public interface VirtualPetRepo extends CrudRepository<VirtualPet, Long> {
    
}
