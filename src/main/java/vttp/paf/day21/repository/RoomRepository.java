package vttp.paf.day21.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import vttp.paf.day21.model.Room;
import vttp.paf.day21.utils.sql;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepository {

    @Autowired
    private JdbcTemplate template;

    // PAF Day 21 - slide 26/27
    public List<Room> getRooms() {
        final List<Room> rooms = new ArrayList<>();
        SqlRowSet rs = template.queryForRowSet(sql.SQL_GET_ALL_ROOMS);
        while (rs.next()) {
            Room room = new Room();
            room.setId(rs.getInt("id"));
            room.setRoom_type(rs.getString("room_type"));
            room.setPrice(rs.getFloat("price"));
            rooms.add(room);
        }
        return rooms;
    }

    // Get room by id
    public Room getRoom(int id) {
        SqlRowSet rs = template.queryForRowSet(sql.SQL_GET_ROOM_BY_ID, id);
        if (rs.next()) {
            Room room = new Room();
            room.setId(rs.getInt("id"));
            room.setRoom_type(rs.getString("room_type"));
            room.setPrice(rs.getFloat("price"));
            return room;
        } else {
            throw new RuntimeException("No room found with id " + id);
        }

    }

    public Boolean deleteRoom(int id) {
        int roomDeleted = template.update(sql.SQL_DELETE_ROOM_BY_ID, id);
        if (roomDeleted > 0) {
            return true;
        }
        return false;
    }

    public Boolean updateRoom(final int id, Room room) {

        int roomUpdated = template.update(sql.SQL_UPDATE_ROOM_BY_ID,
                room.getRoom_type(),room.getPrice(),id);

        if (roomUpdated > 0) {
            return true;
        }
        return false;

    }
}
