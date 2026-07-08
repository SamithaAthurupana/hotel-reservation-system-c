package com.hilton.hotel.controller;

import com.hilton.hotel.domain.Room;
import com.hilton.hotel.dto.response.RoomResponse;
import com.hilton.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    // Get All Rooms
    @GetMapping
    public ResponseEntity<List<RoomResponse>> getAllRooms() {
        List<RoomResponse> rooms = roomService.getAllRooms()
                .stream().map(room -> RoomResponse.from(room)).toList();
        return ResponseEntity.ok(rooms);
    }

//    // Create Room
//    @PostMapping
//    public ResponseEntity<RoomResponse> createRoom(@RequestBody Room room) {
//        RoomResponse savedRoom = roomService.createRoom(room);
//        return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
//    }



//    // Get Room By ID
//    @GetMapping("/{id}")
//    public ResponseEntity<RoomResponse> getRoomById(@PathVariable Long id) {
//        return ResponseEntity.ok(roomService.getRoomById(id));
//    }
//
//    // Update Room
//    @PutMapping("/{id}")
//    public ResponseEntity<RoomResponse> updateRoom(
//            @PathVariable Long id,
//            @RequestBody Room room) {
//
//        return ResponseEntity.ok(roomService.updateRoom(id, room));
//    }
//
//    // Delete Room
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
//        roomService.deleteRoom(id);
//        return ResponseEntity.noContent().build();
//    }
}
