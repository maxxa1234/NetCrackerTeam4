package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Address;
import com.netcracker.edu.rcnetcracker.model.Utility;
import com.netcracker.edu.rcnetcracker.servicies.AddressService;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("address")
@RestController
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Address> getAll(@RequestParam(value = "page", required = false) Integer page,
                                @RequestParam(value = "size", required = false) Integer size,
                                @RequestParam(value = "flat", required = false) String flat,
                                @RequestParam(value = "building", required = false) String building,
                                @RequestParam(value = "sort", required = false) String sort) {
        List<SearchCriteria> filters = new ArrayList<>();
        Pageable pageable = null;
        if (page == null && size != null) {
            pageable = PageRequest.of(0, size);
        }
        if (page != null && size != null) {
            pageable = PageRequest.of(page, size);
        }
        if (flat != null) {
            filters.add(new SearchCriteria("flat", flat));
        }
        if (building != null) {
            filters.add(new SearchCriteria("building",building));
        }
        return service.getAll(pageable, filters, new SortCriteria(sort));
    }

    @GetMapping("{id}")
    public Address getUtility(@PathVariable("id") Long addressID) {
        return service.getById(addressID);
    }

    @PostMapping("/add")
    public boolean createAddress(@RequestBody Address address) {
        return service.create(address);
    }

    @DeleteMapping("{id}")
    public boolean deleteAddress(@PathVariable("id") Long addressId) {
        return service.delete(addressId);
    }

    @PutMapping
    public boolean updateAddress(@RequestBody Address address) {
        return service.update(address);
    }

}
