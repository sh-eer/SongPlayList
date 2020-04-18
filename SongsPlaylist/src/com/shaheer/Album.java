package com.shaheer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songList = new ArrayList<Song>();

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songList.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong (String title) {
        for(Song checkedSong: songList) {
            if(checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addSongToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("Song " + title + "does not exist in this album.");
        return false;
    }

}
