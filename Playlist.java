/**
 * Jaymohan Kottilil
 * 111978111
 * Jaymohan.Kottilil@stonybrook.edu
 * Assignment #1
 * CSE 214, Recitation 01, Juan Tarquino
 *
 */

package com.company;

import java.util.ArrayList;

public class Playlist extends SongRecord implements Cloneable {

    private static final int MAX_SONGS = 50;
    private SongRecord[] playlist1;
    private SongRecord[] copiedList;
    private int currentSize = 0;


    public Playlist() {

       playlist1 = new SongRecord [MAX_SONGS + 1];




    }

    public Object clone() throws CloneNotSupportedException {

        currentSize ++;
        return  super.clone();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SongRecord)) {
            return false;
        }

        SongRecord c = (SongRecord) obj;
        for (int i = 1; i < MAX_SONGS + 1; i++) {
            if ((playlist1[i].getSongTitle().compareTo(c.getSongTitle()) == 0) && (playlist1[i].getSongArtist().compareTo(c.getSongArtist()) == 0) &&
                    (Integer.compare(playlist1[i].getSongLength_minutes(), c.getSongLength_minutes()) == 0)
                    && (Integer.compare(playlist1[i].getSongLength_seconds(), c.getSongLength_seconds()) == 0)) {

            } else {
                return false;
            }
        }
        return true;
    }






    public int size() {
        return currentSize;


    }

    /**
     *
     *
     *
     *
     * @param song
     * @param position
     */
    public void addSong(SongRecord song, int position){
            try{
                currentSize++;
                if(position <= 0 || position > currentSize){
                    throw new IllegalArgumentException();
                }
                if( currentSize == MAX_SONGS) {
                    throw new FullPlaylistException();
                }
                for(int x = currentSize-1; x >= position-1; x--){
                    playlist1[x+1] = playlist1[x];

                }
                playlist1[position] = song;


            }
            catch(IllegalArgumentException e) {
                System.out.println("Invalid position to insert");
            }
            catch(FullPlaylistException e) {
                System.out.println("\n cannot insert");

            }

    }

    /**
     * // First, set index to the location of target in the data array,
     * // which could be as small as 0 or as large as curentSize.
     * // If target is not in the array, then an error is thrown .
     * @param position
     */
    public void removeSong(int position) {

        try {
            if (position <= 0 || position > currentSize) {
                throw new IllegalArgumentException();
            }
            for(int i = currentSize;i>position;i--){
                playlist1[i] = playlist1[i+1];

            }


        }catch(IllegalArgumentException e){
            System.out.println("\n position not in range");
        }
    }

    /**
     *
     * @param position
     * @return
     */
    public SongRecord getSong( int position) {

        try

        {
            if(position <= 0 || position > currentSize)
                throw new IllegalArgumentException();

        }

        catch(IllegalArgumentException ie)

        {

            System.out.println("\nInvalid position.");

        }

        return playlist1[position];
    }

    /**
     * Prints a neatly formatted table of each SongRecord in the Playlist on its own line
     * with its position number as shown in the sample output.
     */
    public void PrintAllSongs() {
            for(int i = 1;i <= currentSize;i++){
                System.out.println(playlist1[i].toString());
            }
    }

    /**
     *Takes an empty playlist and iterates over original to check for the same artist then adds into the empty
     * playlist.
     * @param originaList
     * @param artist
     */


    public static Playlist getSongsByArtists(Playlist originaList, String artist) {
        if (originaList == null) {
            return null;
        }
        if (artist == null) {
            return null;

        }
        Playlist copiedList = new Playlist();

        int counter = 0;
        for (int i = 0;i<originaList.size();i++) {
            if (originaList.getSong(i).getSongArtist().equals(artist)) {
                copiedList.addSong(originaList.getSong(i), counter);
                counter += 1;

            }
        }
            return copiedList;

    }



            /**
             *  formats into a table with headings
             * @return
             */

    @Override
    public String toString() {
        System.out.println((String.format("%-6s%18s%18s%20s", "Song #", "Title", "Artist", "Length")));
        System.out.println("----------------------------------------------------------------------");
        for (int i = 1; i <= currentSize; i++) {
            System.out.println(this.getSong(i).toString());
        }
        return "";

    }
}