package com.test3.restTest3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HomeController {
    @Autowired
    private HomeService homeService;
    @Autowired
    HomeRepository homeRepository;
    @GetMapping("/homes")
    public Iterable<Home> getHomes() {
        return homeService.findAllHomes();
    }

    @PostMapping("/homes")
    public Home addHome(@RequestBody Home home) { //@RequestParam String param
        return homeService.addHome(home);
    }

    @GetMapping("/homes/{id}")
    public Optional<Home> getHomeById(@PathVariable(value = "id") Integer id) {
        return homeService.getHomeById(id);
    }

//    @GetMapping("/rooms")
//    public Iterable<Room> getRooms() {
//        return roomRepository.findAll();
//    }
//    @GetMapping("/rooms/{id}")
//    public Iterable<Room> getId(@PathVariable(value = "id") float id) {
//        return roomRepository.findBySurfaceGreaterThan(id);
//    }
//
//    @PostMapping("/room")
//    public @ResponseBody Room addRoom(@RequestBody String body, @RequestParam Integer param) throws Exception {
//        Room room = new Room();
//
//        return homeRepository.findById(param).map(home1 -> {
//            room.setSurface(12.5f);
//            room.setHome(home1);
//            return roomRepository.save(room);
//        }).orElseThrow(()-> new Exception("can't add room"));
//    }
}
