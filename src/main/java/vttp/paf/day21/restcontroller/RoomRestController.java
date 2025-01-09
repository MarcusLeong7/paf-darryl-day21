package vttp.paf.day21.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vttp.paf.day21.model.Room;
import vttp.paf.day21.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomRestController {

    @Autowired
    RoomService roomSvc;

    @GetMapping
    public ResponseEntity<List<Room>> getAllRoom() {
        List<Room> rooms = roomSvc.getAllRooms();

        return ResponseEntity.ok().body(rooms);
    }
}
