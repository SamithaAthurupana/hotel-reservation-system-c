package com.hilton.hotel.service;

import com.hilton.hotel.domain.Room;
import com.hilton.hotel.dto.response.RoomResponse;
import com.hilton.hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class RoomService {


    private final RoomRepository roomRepository;


    @Transactional(readOnly = true)
    public List<Room> getAllRooms() {
        return roomRepository.findAll();

    }

    public RoomResponse getRoomById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));

        return RoomResponse.from(room);
    }

    public RoomResponse updateRoom(Long id, Room updatedRoom) {
        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));

        existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
        existingRoom.setType(updatedRoom.getType());
        existingRoom.setPricePerNight(updatedRoom.getPricePerNight());
        existingRoom.setCapacity(updatedRoom.getCapacity());
        existingRoom.setDescription(updatedRoom.getDescription());
        existingRoom.setStatus(updatedRoom.getStatus());

        Room savedRoom = roomRepository.save(existingRoom);

        return RoomResponse.from(savedRoom);
    }

    public void deleteRoom(Long id) {
        if (!roomRepository.existsById(id)) {
            throw new RuntimeException("Room not found with id: " + id);
        }

        roomRepository.deleteById(id);
    }
}
