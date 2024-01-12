package com.example.codestates.mention.repository;

import com.example.codestates.mention.entity.Mention;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface MentionRepository extends JpaRepository<Mention, Long> {
    @EntityGraph(attributePaths = {"receiver", "sender"})
    List<Mention> findByReceiverMentionId(Long receiverId);

    @EntityGraph(attributePaths = {"sender"})
    Optional<Mention> findById(Long MentionId);

    Long countByReceiverMentionIdAndIsReadFalse(Long receiverId);
}
