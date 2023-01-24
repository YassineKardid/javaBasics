package com.test3.restTest3;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface HomeRepository extends CrudRepository<Home, Integer> {
    List<Home> findByAddressContaining(String address);

    //@Query(value = "select h.number, h.address from home h", nativeQuery=true)
    @Query(value = "select h.number, h.address, r.surface from home h left join room r " +
                " on h.number=r.home_number where r.surface>?1", nativeQuery = true) // group by h.address having r.surface>12
    List<Home> joinTablesTest(float surface);
}
