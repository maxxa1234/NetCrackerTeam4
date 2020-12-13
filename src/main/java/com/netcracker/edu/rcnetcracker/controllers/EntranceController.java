package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.dao.Checker;
import com.netcracker.edu.rcnetcracker.db.access.TestAccess;
import com.netcracker.edu.rcnetcracker.model.Entrance;
import com.netcracker.edu.rcnetcracker.servicies.EntranceService;
import com.netcracker.edu.rcnetcracker.servicies.requestParam.*;
import com.netcracker.edu.rcnetcracker.servicies.requestParam.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestParam.criteria.SortCriteria;
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
        Director director = new Director();
        RequestParams requestParams = new RequestParams();
        List<SearchCriteria> filters = new ArrayList<>();
        if (typeId != null){
            filters.add(new SearchCriteria( "typeId",typeId));
        }
        if (name != null){
            filters.add(new SearchCriteria( "name", name));
        }
        if (buildingId != null){
            filters.add(new SearchCriteria( "buildingId", buildingId));
        }
        if (isActive != null){
            filters.add(new SearchCriteria( "isActive", isActive));
        }
        if (filters.size() != 0 && sort != null){
            director.setBuilder(new RequestWithFilterAndSort());
            requestParams = director.buildRequestParams(PageRequest.of(page, size), filters, new SortCriteria(sort));
        }
        if (filters.size() != 0 && sort == null){
            director.setBuilder(new RequestWithFilter());
            requestParams = director.buildRequestParams(PageRequest.of(page, size), filters, null);
        }
        if (filters.size() == 0 && sort != null){
            director.setBuilder(new RequestWithSort());
            requestParams = director.buildRequestParams(PageRequest.of(page, size), filters, new SortCriteria(sort));
        }
        if (filters.size() == 0 && sort == null){
            director.setBuilder(new RequestWithoutFilterAndSort());
            requestParams = director.buildRequestParams(PageRequest.of(page, size), null, null);
        }
        return service.getAll(requestParams);
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
