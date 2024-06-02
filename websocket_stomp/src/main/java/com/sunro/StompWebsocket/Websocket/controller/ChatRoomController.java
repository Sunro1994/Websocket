package com.sunro.StompWebsocket.Websocket.controller;

import com.sunro.StompWebsocket.Websocket.dto.ChatRoom;
import com.sunro.StompWebsocket.Websocket.service.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRepository chatRepository;

    @GetMapping("/room")
    public String rooms(Model model) {
        return "room";
    }

    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> rooms() {
        return chatRepository.findAllRoom();
    }

    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name) {
        return chatRepository.createRoom(name);
    }

    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId) {
        model.addAttribute("roomId", roomId);
        return "roomDetail"; // 수정: 명확한 뷰 이름 사용
    }

    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoom roomDetail(@PathVariable String roomId) {
        return chatRepository.findRoomById(roomId);
    }
}
