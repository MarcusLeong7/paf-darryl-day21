package vttp.paf.day21.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vttp.paf.day21.model.Room;
import vttp.paf.day21.repository.RoomRepository;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepo;

    public List<Room> getAllRooms() {
        return roomRepo.getRooms();
    }

    public Room getRoomById(int id) {
        return roomRepo.getRoom(id);
    }

    public Boolean deleteRoomById(int id) {
        return roomRepo.deleteRoom(id);
    }

    public Boolean updateRoom(int id, Room room) {
        return roomRepo.updateRoom(id, room);
    }

    public Boolean addRoom(Room room) {return roomRepo.insertNewRoom(room);}
}
