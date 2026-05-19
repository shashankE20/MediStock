package com.medistock.pharma.medicine.controller;

import com.medistock.pharma.medicine.dto.MedicineRequest;
import com.medistock.pharma.medicine.model.Medicine;
import com.medistock.pharma.medicine.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicines" )
@RequiredArgsConstructor
@CrossOrigin("*")
public class MedicineController   {

    private final MedicineService medicineService;

    @PostMapping
    public Medicine addMedicine(@RequestBody MedicineRequest request) {

        return medicineService.addMedicine(request);
    }

    @GetMapping
    public List<Medicine> getAllMedicines() {

        return medicineService.getAllMedicines();
    }

    @GetMapping("/{id}")
    public Medicine getMedicineById(@PathVariable String id) {

        return medicineService.getMedicineById(id);
    }

    @PutMapping("/{id}")
    public Medicine updateMedicine(
            @PathVariable String id,
            @RequestBody MedicineRequest request
    )  {

        return medicineService.updateMedicine(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteMedicine(@PathVariable String id) {

        return medicineService.deleteMedicine(id);
    }
}
