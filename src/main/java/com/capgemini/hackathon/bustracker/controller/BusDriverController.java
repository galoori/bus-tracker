package com.capgemini.hackathon.bustracker.controller;

import com.capgemini.hackathon.bustracker.dao.BusDriverDao;
import com.capgemini.hackathon.bustracker.exception.UserNotFoundException;
import com.capgemini.hackathon.bustracker.model.BusDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by galoori on 12/10/2016.
 */
@RestController
public class BusDriverController {

    @Autowired
    private BusDriverDao busDriverDao;

    @RequestMapping(value = "/busdrivers", method = RequestMethod.POST)
    public BusDriver create(@RequestBody BusDriver busDriver) {
        return busDriverDao.create(busDriver);
    }

    @RequestMapping(value = "/busdrivers/{id}", method = RequestMethod.GET)
    public BusDriver find(@PathVariable Integer id) {
        return busDriverDao.find(id);
    }

    @RequestMapping(value = "/busdrivers", method = RequestMethod.GET)
    public List<BusDriver> list() {
        return busDriverDao.list();
    }

    @RequestMapping(value = "/busdrivers/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        busDriverDao.delete(id);
    }

    @RequestMapping(value = "/busdrivers/{id}", method = RequestMethod.POST)
    public BusDriver update(@PathVariable Integer id, @RequestBody BusDriver busDriver)
            throws UserNotFoundException {
        return busDriverDao.update(id, busDriver);
    }
}
