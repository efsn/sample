package cn.elmi.sample.mybatis.mapper;

import java.util.List;

import cn.elmi.sample.mybatis.vo.ChatMessage;

public interface ChatMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChatMessage record);

    int batchInsert(List<ChatMessage> records);

    int insertSelective(ChatMessage record);

    ChatMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChatMessage record);

    int updateByPrimaryKey(ChatMessage record);
}