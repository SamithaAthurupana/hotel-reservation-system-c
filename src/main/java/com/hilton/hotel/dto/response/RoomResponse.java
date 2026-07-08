package com.hilton.hotel.dto.response;

import com.hilton.hotel.domain.Room;
import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class RoomResponse {

    private Long id;
    private String roomNumber;
    private String type;
    private BigDecimal pricePerNight;
    private Integer capacity;
    private String description;
    private String status;
    private LocalDateTime createdAt;

    public static RoomResponse from(Room room){
        return RoomResponse.builder()
                .id(room.getId())
                .roomNumber(room.getRoomNumber())
                .type(room.getType().name())
                .pricePerNight(room.getPricePerNight())
                .capacity(room.getCapacity())
                .description(room.getDescription())
                .status(room.getStatus().name())
                .createdAt(room.getCreatedAt())
                .build();
    }

}
