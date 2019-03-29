package cn.elmi.sample.restful.action;

import java.util.List;

import cn.elmi.sample.mybatis.service.ChatMessageService;
import cn.elmi.sample.mybatis.vo.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @authur Arthur
 */
@RestController
@RequestMapping("/chat")
public class ChatMessageController {

    @Autowired
    private ChatMessageService chatMessageService;

    @PostMapping
    public int add(@RequestBody ChatMessage chatMessage) {
        return chatMessageService.insert(chatMessage);
    }

    @GetMapping
    public List<ChatMessage> chatMessages() {
        return null;
    }

    @GetMapping("/{id}")
    public ChatMessage chatMessage(@PathVariable("id") Integer id) {
        return chatMessageService.findById(id);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Integer id, @RequestBody ChatMessage chatMessage) {
        chatMessage.setId(id);
        return chatMessageService.update(chatMessage);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") Integer id) {
        return chatMessageService.delete(id);
    }

}
