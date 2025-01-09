package vttp.paf.day21.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{room_id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("room_id") int id) {
        Room room = roomSvc.getRoomById(id);
        return ResponseEntity.ok().body(room);
    }

    @DeleteMapping("/{room_id}")
    public ResponseEntity<Boolean> deleteRoomById(@PathVariable("room_id") int id) {
        Boolean roomDeleted = roomSvc.deleteRoomById(id);
        return ResponseEntity.ok().body(roomDeleted);
    }

    @PutMapping("/{room_id}")
    public ResponseEntity<Boolean> updateRoomById(@PathVariable("room_id") int id,
                                                  @RequestBody Room room) {
        Boolean roomUpdated = roomSvc.updateRoom(id, room);
        return ResponseEntity.ok().body(roomUpdated);
    }
}
