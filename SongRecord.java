/**
 * Jaymohan Kottilil
 * 111978111
 * Jaymohan.Kottilil@stonybrook.edu
 * Assignment #1
 * CSE 214, Recitation 01, Juan Tarquino
 *
 */

package com.company;

public class SongRecord {
     private String songArtist;
     private String songTitle;
     private int songLength_minutes;
     private int songLength_seconds;

    public SongRecord(){
        songTitle = songArtist = "";
        songLength_minutes = 0;
    }

    SongRecord(String title, String artist, int length1, int length2){
        songTitle = title;
        songArtist = artist;
        songLength_minutes = length1;
        songLength_seconds = length2;

    }

    void setTitle(String title){

        songTitle = title;
    }




    public String getSongArtist(){

        return songArtist;
    }

    public String getSongTitle(){

        return songTitle;
    }

    public int getSongLength_minutes(){

        return songLength_minutes;
    }

    public int getSongLength_seconds(){

        return songLength_seconds;

    }

    public void setSongArtist(String songArtist) {

        this.songArtist = songArtist;
    }

    /**
     *
     * @param songLength_seconds
     */
    public void setSongLength_seconds(int songLength_seconds) {
        this.songLength_seconds = songLength_seconds;
        try{
            if(songLength_seconds > 59 || songLength_seconds < 0) {
                throw new IllegalArgumentException("Invalid value: greater than 59 or less than 0");
            }


        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param songLength_minutes
     * @throws NegativeArraySizeException
     */
    public void setSongLength_minutes(int songLength_minutes) throws NegativeArraySizeException {
        this.songLength_minutes = songLength_minutes;
        try{
            if(songLength_minutes < 0){
                throw new IllegalArgumentException("Invalid value: negative number");
            }
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void setSongTitle(String songTitle) {

        this.songTitle = songTitle;
    }

    @Override
    public String toString() {
        return String.format("%19s%18s%20d:%02d",songTitle, songArtist, songLength_minutes,songLength_seconds);

    }
}

