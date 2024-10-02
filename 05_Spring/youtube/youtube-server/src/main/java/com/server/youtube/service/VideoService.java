package com.server.youtube.service;

import com.querydsl.core.BooleanBuilder;
import com.server.youtube.domain.Video;
import com.server.youtube.repo.VideoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    @Autowired
    private VideoDAO dao;

    public List<Video> viewAll() {
        return dao.findAll();
    }

    public Page<Video> viewAll(BooleanBuilder builder, Pageable pageable) {
        return dao.findAll(builder, pageable);
    }
    public void create(Video vo) {
        dao.save(vo);
    }
}
