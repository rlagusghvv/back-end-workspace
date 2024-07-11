package com.kh.practice1.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.kh.practice1.model.Song;

public class SongManager {
    private List<Song> songs;

    public SongManager() {
        songs = new ArrayList<>();
    }

    public void addSongLast(String title, String singer) {
        songs.add(new Song(title, singer));
        System.out.println("추가 성공");
    }

    public void addSongFirst(String title, String singer) {
        songs.add(0, new Song(title, singer));
        System.out.println("추가 성공");
    }

    public void printAllSongs() {
        System.out.println("****** 전체 곡 목록 출력 ******");
        for (Song song : songs) {
            System.out.println(song);
        }
    }

    public Song searchSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().contains(title)) {
                System.out.println(song + " 을 검색 했습니다.");
                return song;
            }
        }
        System.out.println("검색할 곡을 찾지 못했습니다.");
        return null;
    }

    public void deleteSong(String title) {
        Song songToDelete = searchSong(title);
        if (songToDelete != null) {
            songs.remove(songToDelete);
            System.out.println(songToDelete + " 을 삭제 했습니다.");
        } else {
            System.out.println("삭제할 곡이 없습니다.");
        }
    }

    public void updateSong(String oldTitle, String newTitle, String newSinger) {
        Song songToUpdate = searchSong(oldTitle);
        if (songToUpdate != null) {
            songToUpdate.setTitle(newTitle);
            songToUpdate.setSinger(newSinger);
            System.out.println(songToUpdate + "의 값이 변경 되었습니다.");
        } else {
            System.out.println("수정할 곡을 찾지 못했습니다.");
        }
    }

    public void sortSongsBySingerDesc() {
        songs.sort(Comparator.comparing(Song::getSinger).reversed());
        System.out.println("****** 가수 명 내림차순 정렬 ******");
        printAllSongs();
    }

    public void sortSongsByTitleAsc() {
        songs.sort(Comparator.comparing(Song::getTitle));
        System.out.println("****** 곡 명 오름차순 정렬 ******");
        printAllSongs();
    }
}