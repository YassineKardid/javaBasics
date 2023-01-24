package com.test3.restTest3;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class HomeRepositoryTest {
    @Autowired
    HomeRepository homeRepository;
    @Autowired
    RoomRepository roomRepository;
    @Test
    public void testShouldReturnContainingAddresses(){
        Home home1 = new Home("addr 1");
        home1.setNumber(1);
        Home home2 = new Home("addr 2");
        home2.setNumber(2);
        List<Home> homes = new ArrayList<>(Arrays.asList(home1, home2));
        homeRepository.saveAll(homes);
        List<Home> results = homeRepository.findByAddressContaining("addr");
        assertEquals(results.size(), homes.size());
        List<Home> results2 = homeRepository.findByAddressContaining("dummy");
        List<Home> emptyArray = new ArrayList<>();
        //assertArrayEquals(results2.toArray(), new Home[0]);
        Home[] home = {};
        assertArrayEquals(results2.toArray(), home);
        assertTrue(results2.isEmpty(), "No home found with the given address");
        //assert (results2.isEmpty());
    }
    @Test
    void testShouldReturnRightValueByJoiningTables(){
        Home home1 = new Home("addr 1");
        home1.setNumber(1);
        Home home2 = new Home("addr 2");
        home2.setNumber(2);
        Room room1 = new Room(30, home1);
        Room room2 = new Room(40, home1);
        homeRepository.save(home1);
        homeRepository.save(home2);
        roomRepository.save(room1);
        roomRepository.save(room2);
        List<Home> result = homeRepository.joinTablesTest(12);
        for (Home r : result){
            System.out.println("#################");
            System.out.println(r.getNumber());
        }

    }
}