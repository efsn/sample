package cn.elmi.sample.mybatis.mapper;

import cn.elmi.sample.mybatis.vo.ChatMessage;

public interface ChatMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChatMessage record);

    int insertSelective(ChatMessage record);

    ChatMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChatMessage record);

    int updateByPrimaryKey(ChatMessage record);
}