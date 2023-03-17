package com.simplework.simplework.Repository;

import com.simplework.simplework.Bean.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat,String> {
    @Query(value = "select * from chat where (sendid = ?1 and toid = ?2) or (sendid = ?2 and toid = ?1) ORDER BY time",nativeQuery = true)
    List<Chat> findallbysendidandtoidorder(String id1, String id2);
    @Query(value = "select * from chat where toid = ?1 and toitem = ?2 group by sendid ",nativeQuery = true)
    List<Chat> findByToidAndToitem(String id,String item);
    @Query(value = "select * from chat where sendid = ?1 and senditem = ?2 group by toid ",nativeQuery = true)
    List<Chat> findBySendidAndSenditem(String id,String item);
}
