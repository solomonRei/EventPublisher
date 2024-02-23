package com.practice.repository;

import com.practice.model.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public EventRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<EventModel> rowMapper = (rs, rowNum) -> {
        EventModel event = new EventModel();
        event.setId(rs.getLong("id"));
        event.setData(rs.getString("data"));
        event.setType(rs.getString("type"));
        return event;
    };

    public List<EventModel> findAll() {
        return jdbcTemplate.query("SELECT * FROM events", rowMapper);
    }

    public void save(EventModel event) {
        String sql = "INSERT INTO events (type, data) VALUES (:type, CAST(:data AS JSONB))";

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("type", event.getType())
                .addValue("data", event.getData());

        jdbcTemplate.update(sql, parameters);
    }


}
