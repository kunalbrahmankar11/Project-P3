package com.chat.chatapp.controller;


import com.chat.chatapp.Entities.Room;
import com.chat.chatapp.Repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private RoomRepository roomRepository;
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // create room
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId){
        if(roomRepository.findByRoomId(roomId)!=null){
            //If room is already their
            return ResponseEntity.badRequest().body("room already exist");
        }
        //If room not found then new room created.
        Room room = new Room();
        room.setRoomId(roomId);
       Room savedRoom =  roomRepository.save(room);
       return ResponseEntity.status(HttpStatus.CREATED).body(room);

    }
    // get room
    // get messages of from

}
