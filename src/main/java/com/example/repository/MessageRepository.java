package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.example.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query(value = "select * from Message where posted_by = ?", nativeQuery = true)
    List<Message> findMessagesByPosted_By(Integer posted_by);
}
