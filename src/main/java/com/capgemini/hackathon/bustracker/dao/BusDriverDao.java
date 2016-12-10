package com.capgemini.hackathon.bustracker.dao;

import com.capgemini.hackathon.bustracker.exception.UserNotFoundException;
import com.capgemini.hackathon.bustracker.model.BusDriver;
import com.capgemini.hackathon.bustracker.repo.BusDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by galoori on 12/10/2016.
 */
@Service
public class BusDriverDao {

    @Autowired
    private BusDriverRepository busDriverRepository;

    public BusDriver create(BusDriver busDriver) {
        return busDriverRepository.save(busDriver);
    }

    public BusDriver find(Integer id) {
        return busDriverRepository.findOne(id);
    }

    public List<BusDriver> list() {
        List<BusDriver> busDrivers = new ArrayList<BusDriver>();
        Iterator<BusDriver> busDriverIterator = busDriverRepository.findAll().iterator();
        while (busDriverIterator.hasNext()) {
            busDrivers.add(busDriverIterator.next());
        }
        return busDrivers;
    }

    public void delete(Integer id) {
        busDriverRepository.delete(id);
    }

    public BusDriver update(Integer id, BusDriver busDriver) throws UserNotFoundException {
        if (!busDriverRepository.exists(id)) {
            throw new UserNotFoundException("Cannot update. User with Id - "+id+" does not exist.");
        }
        return busDriverRepository.save(busDriver);
    }
}
