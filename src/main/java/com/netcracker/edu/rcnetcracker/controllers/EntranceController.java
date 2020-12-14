package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.dao.Checker;
import com.netcracker.edu.rcnetcracker.db.access.TestAccess;
import com.netcracker.edu.rcnetcracker.model.Entrance;
import com.netcracker.edu.rcnetcracker.servicies.EntranceService;
import com.netcracker.edu.rcnetcracker.servicies.RequestBuilder;
import com.netcracker.edu.rcnetcracker.servicies.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/entrance")
@RestController
public class EntranceController {

    private final EntranceService service;

    public EntranceController(EntranceService service) {
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
    public void updateEntrance(@PathVariable("id")Entrance object) {
        service.update(object);
    }

    @GetMapping
    public Page<Entrance> getAll(@RequestParam("page") int page, @RequestParam("size") int size,
                                 @RequestParam(value = "typeId", required = false) String typeId,
                                 @RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "buildingId", required = false) String buildingId,
                                 @RequestParam(value = "isActive", required = false) String isActive,
                                 @RequestParam(value = "sort", required = false) String sort) {
        RequestBuilder builder = new RequestBuilder(page, size);
        if (typeId != null){
            builder.addFilterCriteria("typeId", typeId);
        }
        if (name != null){
            builder.addFilterCriteria("name", name);
        }
        if (buildingId != null){
            builder.addFilterCriteria("buildingId", buildingId);
        }
        if (isActive != null){
            builder.addFilterCriteria("isActive", isActive);
        }
        if (sort != null){
            builder.setSortCriteria(new SortCriteria(sort));
        }

        return service.getAll(builder);
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
    public Page<Entrance> testWithFilter(@RequestParam("page") int page,
                                         @RequestParam("size") int size,
                                         @RequestParam(value = "typeId", required = false) String type_id,
                                         @RequestParam(value = "name", required = false) String name,
                                         @RequestParam(value = "buildingId", required = false) String building_id,
                                         @RequestParam(value = "isActive", required = false) String isActive,
                                         @RequestParam(value = "sort", required = false) String sort){
        List<SearchCriteria> filterParameters = new ArrayList<>();
        if (type_id != null) {
            Checker.checkNumParameter(type_id);
            filterParameters.add(new SearchCriteria("typeId", type_id));
        }
        if (name != null) {
            filterParameters.add(new SearchCriteria("name", "like '%"+name+"%' "));
        }
        if (building_id != null) {
            Checker.checkNumParameter(building_id);
            filterParameters.add(new SearchCriteria("buildingId", building_id));
        }
        if (isActive != null) {
            Checker.checkBooleanParameter(isActive);
            filterParameters.add(new SearchCriteria("isActive", isActive));
        }
        List<Entrance> resultArray = testAccess.selectAll(Entrance.class, filterParameters.toArray(new SearchCriteria[0]));
        return new PageImpl<>(resultArray, PageRequest.of(page, size), resultArray.size());
    }

    @RequestMapping(value = "/get-one/{id}")
    public Entrance getOne(@PathVariable("id") String id){
        List<SearchCriteria> params = new ArrayList<>();
        params.add(new SearchCriteria("id", "="+id));
        List<Entrance> list = testAccess.selectAll(Entrance.class, params.toArray(new SearchCriteria[0]));
        Entrance entrance = list.get(0);
        return entrance;
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
