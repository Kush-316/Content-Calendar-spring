package com.examplekush316.content_calendar.repository;

import java.io.ObjectInputFilter.Status;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.examplekush316.content_calendar.model.Content;

public interface ContentRepository extends ListCrudRepository<Content,Integer> {
     
    List<Content> findAllByTitleContains(String keyword);

    @Query("""
            SELECT * FROM Content
            WHERE status = :status
            """)

    List<Content> listByStatus(@Param("status") com.examplekush316.content_calendar.model.Status status);
}
