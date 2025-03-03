package com.chat.chatapp.Repository;

import com.chat.chatapp.Entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room,String> {
    Room findByRoomId(String roomId);
}
