package com.capgemini.hackathon.bustracker.repo;

import com.capgemini.hackathon.bustracker.model.BusDriver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by galoori on 12/10/2016.
 */
@Repository
public interface BusDriverRepository extends CrudRepository<BusDriver, Integer> {
}
