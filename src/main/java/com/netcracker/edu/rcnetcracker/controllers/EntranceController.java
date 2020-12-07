package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.dao.Checker;
import com.netcracker.edu.rcnetcracker.dao.EntityDAO;
import com.netcracker.edu.rcnetcracker.dao.EntranceDAO;
import com.netcracker.edu.rcnetcracker.db.access.TestAccess;
import com.netcracker.edu.rcnetcracker.model.Entrance;
import org.springframework.beans.factory.annotation.Autowired;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/entrance")
@RestController
public class EntranceController {

    private final EntranceDAO service;

    public EntranceController(EntranceDAO service) {
        this.service = service;
    }

    @Autowired
    private TestAccess testAccess;

    @GetMapping(value = "/open",
            params = {"key_id", "entrance_id"})
    public boolean openGate(@RequestParam("key_id") Long key_id, @RequestParam("entrance_id") Long entrance_id) {
        //will return isOpened
        return false;
    }

    @GetMapping(value = "/block",
            params = {"key_id", "entrance_id"})
    public boolean blockGate(@RequestParam("key_id") Long key_id, @RequestParam("entrance_id") Long entrance_id) {
        //will return isBlock
        return false;
    }

    @PostMapping("/add")
    public void createEntrance(@RequestBody Entrance entrance) {
        service.create(entrance);
    }

    @DeleteMapping(params = {"id"})
    public void deleteEntrance(@RequestParam("id") Long entranceId) {
        service.delete(entranceId);
    }

    @PutMapping("{id}")
    public void updateEntrance(@PathVariable("id")Long id) {
        service.update(id);
    }

    @GetMapping
    public Page<Entrance> getAll(@RequestParam("page") int page, @RequestParam("size") int size,
                                 @RequestParam(value = "type_id", required = false) String type_id,
                                 @RequestParam(value = "building_id", required = false) String building_id,
                                 @RequestParam(value = "isActive", required = false) String isActive,
                                 @RequestParam(value = "sort", required = false) String sort) {
        EntityDAO<Entrance> ser = new EntityDAO<>(service);
        List<SearchCriteria> filterParameters = new ArrayList<>();
        if (type_id != null) {
            Checker.checkNumParameter(type_id);
            filterParameters.add(new SearchCriteria("type_id", type_id));
        }
        if (building_id != null) {
            Checker.checkNumParameter(building_id);
            filterParameters.add(new SearchCriteria("building_id", building_id));
        }
        if (isActive != null) {
            Checker.checkBooleanParameter(isActive);
            filterParameters.add(new SearchCriteria("isActive", isActive));
        }

        return ser.getAll(page, size, filterParameters, sort);
    }

    @GetMapping("/log")
    public void getLog(@RequestParam("page") int page, @RequestParam("size") int size,
                       @RequestParam(value = "filter", required = false) String filter,
                       @RequestParam(value = "sort", required = false) String sort) {

    }

    @RequestMapping(value = "/select-all", method = RequestMethod.GET)
    public List<Entrance> test1() {
        return testAccess.selectAll(Entrance.class, new SearchCriteria[0]);
    }

    @RequestMapping(value = "/select-all-with-filter", method = RequestMethod.GET)
    public Page<Entrance> testWithFilter(@RequestParam(value = "typeId", required = false) String type_id,
                                         @RequestParam(value = "description", required = false) String description,
                                         @RequestParam(value = "name", required = false) String name,
                                         @RequestParam(value = "buildingId", required = false) String building_id,
                                         @RequestParam(value = "isActive", required = false) String isActive,
                                         @RequestParam(value = "sort", required = false) String sort){
        List<SearchCriteria> filterParameters = new ArrayList<>();
        EntityDAO<Entrance> ser = new EntityDAO<>(service);
        if (type_id != null) {
            Checker.checkNumParameter(type_id);
            filterParameters.add(new SearchCriteria("typeId", type_id));
        }
        if (description != null) {
            description = "like %"+description+"%";
            filterParameters.add(new SearchCriteria("description", description));
        }
        if (name != null) {
            name = "like %"+name+"%";
            filterParameters.add(new SearchCriteria("name", name));
        }
        if (building_id != null) {
            Checker.checkNumParameter(building_id);
            filterParameters.add(new SearchCriteria("buildingId", building_id));
        }
        if (isActive != null) {
            Checker.checkBooleanParameter(isActive);
            filterParameters.add(new SearchCriteria("isActive", isActive));
        }
        return ser.getAll(1,5, filterParameters,sort);
    }

    @GetMapping(value = "/get-one/{id}")
    public List<Entrance> getOne(@PathVariable("id") String id){
        id = "=" +  id;
        List<SearchCriteria> params = new ArrayList<>();
        params.add(new SearchCriteria("id", id));
        return testAccess.selectAll(Entrance.class, params.toArray(new SearchCriteria[0]));
    }

    /*@RequestMapping(value = "/select-roles", method = RequestMethod.GET)
    public List<Role> test2() {
        return testAccess.selectAll(Role.class);
    }*/

    @PostMapping("/insert-entrance")
    public int test3(@RequestBody Entrance entrance) {
        return testAccess.insert(entrance);
    }

    @PutMapping("/update-entrance")
    public int test4(@RequestBody Entrance entrance) {
        return testAccess.update(entrance);
    }

}
