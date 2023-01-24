package com.test3.restTest3;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomeService {

    @Autowired
    public HomeRepository homeRepository;

    public HomeService() {
    }
    public HomeService(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public Iterable<Home> findAllHomes() {
        return homeRepository.findAll();
    }


    public Home addHome(Home home) {
        return homeRepository.save(home);
    }

    public Optional<Home> getHomeById(Integer id) {

        return homeRepository.findById(id);
    }
}
