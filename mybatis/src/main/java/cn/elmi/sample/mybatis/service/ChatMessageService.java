package cn.elmi.sample.mybatis.service;

import cn.elmi.sample.mybatis.mapper.ChatMessageMapper;
import cn.elmi.sample.mybatis.vo.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @authur Arthur
 */
@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageMapper mapper;

    public ChatMessage findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public int insert(ChatMessage chatMessage) {
        return mapper.insert(chatMessage);
    }

    public int update(ChatMessage chatMessage) {
        return mapper.updateByPrimaryKey(chatMessage);
    }

    public int delete(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

}
