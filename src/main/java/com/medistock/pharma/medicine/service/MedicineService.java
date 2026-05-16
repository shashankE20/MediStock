package com.medistock.pharma.medicine.service;


import com.medistock.pharma.medicine.dto.MedicineRequest;
import com.medistock.pharma.medicine.model.Medicine;
import com.medistock.pharma.medicine.repository.MedicineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicineService {

    private final MedicineRepository medicineRepository;

    public Medicine addMedicine(MedicineRequest request) {

        Medicine medicine = Medicine.builder()
                .medicineName(request.getMedicineName())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .expiryDate(request.getExpiryDate())
                .manufacturer(request.getManufacturer())
                .build();

        return medicineRepository.save(medicine);
    }

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Medicine getMedicineById(String id) {

        return medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine Not Found"));
    }

    public Medicine updateMedicine(String id, MedicineRequest request) {

        Medicine medicine = getMedicineById(id);

        medicine.setMedicineName(request.getMedicineName());
        medicine.setQuantity(request.getQuantity());
        medicine.setPrice(request.getPrice());
        medicine.setExpiryDate(request.getExpiryDate());
        medicine.setManufacturer(request.getManufacturer());

        return medicineRepository.save(medicine);
    }

    public String deleteMedicine(String id) {

        medicineRepository.deleteById(id);

        return "Medicine Deleted Successfully";
    }
}