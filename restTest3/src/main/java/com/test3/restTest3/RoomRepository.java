package com.test3.restTest3;

import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Integer> {

    Iterable<Room> findBySurfaceGreaterThan(float number);
}
