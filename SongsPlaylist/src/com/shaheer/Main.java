package com.shaheer;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();
    private static LinkedList<Song> playList = new LinkedList<Song>();

    public static void main(String[] args) {

        Album album = new Album("Everyday Life", "Coldplay");
        album.addSong("Sunrise", 2.31);
        album.addSong("Church", 3.50);
        album.addSong("Trouble in Town", 4.38);
        album.addSong("Broken", 2.30);
        album.addSong("Daddy", 4.58);
        album.addSong("WOTW / POTP", 1.16);
        album.addSong("Arabesque", 5.40);
        album.addSong("When I Need a Friend", 2.35);
        albums.add(album); //adding to the albums arraylist

        album = new Album("21", "Adele");
        album.addSong("Rolling In The Deep", 3.49);
        album.addSong("Rumour Has It", 3.43);
        album.addSong("Turning Tables", 4.10);
        album.addSong("Don't You Remember", 4.03);
        album.addSong("Set Fire To The Rain", 4.01);
        album.addSong("He Won't Go", 4.38);
        album.addSong("Take It All", 3.40);
        album.addSong("I'll Be Waiting", 4.01);
        album.addSong("One And Only", 5.48);
        album.addSong("Lovesong", 5.16);
        albums.add(album); //adding to the albums arraylist

        albums.get(0).addSongToPlayList("Sunrise", playList);
        albums.get(1).addSongToPlayList("Rolling Stone", playList);
        albums.get(0).addSongToPlayList("Broken", playList);
        play(playList); // starts the play list

    }

    public static void play(LinkedList<Song> playList) {
        ListIterator<Song> songListIterator = playList.listIterator();
        if(playList.size() == 0 ) {
            System.out.println("No songs in play list. Add songs please.");
            return;
        } else {
            System.out.println("Now playing --> " + songListIterator.next().toString());
        }

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        while(!quit) {
            System.out.println("Enter 5 to see the menu");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        System.out.println("PlayList Completed!");
                        quit = true;
                        break;
                    case 1:
                        if(!forward) {
                            if(songListIterator.hasNext()) {
                                songListIterator.next();
                            }
                            forward = true;
                        }
                        if (songListIterator.hasNext()) {
                            System.out.println("Now playing " + songListIterator.next().toString());
                        } else {
                            System.out.println("We've reached the end of the play list!");
                            forward = true;
                        }
                        break;

                    case 2:
                        if(forward) {
                            if(songListIterator.hasPrevious()) {
                                songListIterator.previous();
                            }
                            forward = false;
                        }
                        if (songListIterator.hasPrevious()) {
                            System.out.println("Now playing " + songListIterator.previous().toString());
                        } else {
                            System.out.println("We're at the start of the play list!");
                            forward = false;
                        }
                        break;

                    case 3:
                        if(forward) {
                            if(songListIterator.hasPrevious()) {
                                System.out.println("Now replaying " + songListIterator.previous().toString());
                                forward = false;
                            } else {
                                System.out.println("We're at the start of the play list.");
                            }
                        } else {
                            if (songListIterator.hasNext()) {
                                System.out.println("Now replaying " + songListIterator.next().toString());
                                forward = true;
                            } else {
                                System.out.println("We are at the end of the play list.");
                            }
                        }
                        break;

                    case 4:
                        printList(playList);
                        break;

                    case 5:
                        printMenu();
                        break;

                    case 6:
                        if(playList.size() > 0) {
                            songListIterator.remove();
                            if(songListIterator.hasNext()) {
                                System.out.println("Now playing " + songListIterator.next());
                            } else if (songListIterator.hasPrevious()) {
                                System.out.println("Now playing " + songListIterator.previous());
                            }
                        }
                        break;

                    case 7:
                        quit = true;
                        break;
                }
            } catch (InputMismatchException exception) {
                scanner.nextLine();
                System.out.println("Please Choose amongst these options only!");
                printMenu();
            }
        }
    }

    private static void printMenu(){
        System.out.println();
        System.out.println("Choose the actions below\n" +
                "0 to exit the list.\n" +
                "1 to play next song.\n" +
                "2 to for previous song.\n" +
                "3 to replay the current song.\n" +
                "4 to print the play list.\n" +
                "5 to print the menu again.\n" +
                "6 to remove song from play list.\n" +
                "7 to quit");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("====================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        System.out.println("====================");
    }

}
