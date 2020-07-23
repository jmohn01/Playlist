/**
 * Jaymohan Kottilil
 * 111978111
 * Jaymohan.Kottilil@stonybrook.edu
 * Assignment #1
 * CSE 214, Recitation 01, Juan Tarquino
 *
 */
package com.company;


import java.security.Principal;
import java.util.Scanner;



public class PlaylistOperations {
    private SongRecord song1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean bigLoop = true;
        Playlist playlist1 = new Playlist();
        Playlist list1 = new Playlist();



        String key;
        String choice;

        do {
            System.out.println("A) Add Song");
            System.out.println("B) Print Songs by Artist");
            System.out.println("G) Get Song");
            System.out.println("R) Remove Song");
            System.out.println("P) Print All Songs");
            System.out.println("S) Size");
            System.out.println("Q) Quit");

            System.out.print("Select a menu option: ");

            key = sc.nextLine();
            choice = key.toUpperCase();




            switch(choice.toUpperCase()) {

                case "A":
                    Scanner scan = new Scanner(System.in);
                    System.out.print("Enter the song title:\n");
                    String title = scan.nextLine();
                    System.out.print("Enter the song artist:\n");
                    String artist = scan.nextLine();
                    System.out.print("Enter the song length (minutes):\n");
                    int length1 = scan.nextInt();
                    playlist1.setSongLength_minutes(length1);
                    System.out.print("Enter the song length (seconds):\n");
                    int length2 = scan.nextInt();
                    playlist1.setSongLength_seconds(length2);
                    System.out.print("Enter the position:");
                    int position = scan.nextInt();
                    System.out.println("Song added: " + title + " by " + artist);
                    SongRecord song1 = new SongRecord(title, artist, length1, length2);
                    playlist1.addSong(song1, position);
                    break;

                case "B":
                    System.out.print("Enter the artist: ");
                    artist = sc.nextLine();
                    //(Playlist.getSongsByArtists(playlist1, artist)).toString();



                    break;

               // + " " + playlist1.getSong(getPos)
                case "G":
                    System.out.println();
                    System.out.print("Enter the position:");
                    int getPos = sc.nextInt();
                    playlist1.getSong(getPos);
                    if(getPos <= 0 || getPos > playlist1.size()){
                        System.out.println("No song at position: " + getPos);
                    }
                    else{
                        System.out.println(playlist1.toString());
                        //System.out.println(String.format("%-21d%-26s%19s%06d","Song#","Title","Artist","Length"));
                        //System.out.println("----------------------------------------------------------------------");
                        //System.out.println(getPos);
                    }

                case "R":

                    System.out.print("Enter the position: ");
                    int getRem = sc.nextInt();
                    playlist1.removeSong(getRem);
                    System.out.println("Song removed at position " + getRem);
                    break;


                case "P":
                    playlist1.PrintAllSongs();
                    System.out.println(playlist1.toString());
                    break;


                case "S":
                    System.out.println("There are " + playlist1.size() + " song(s) in the current playlist");
                    break;

                case "Q":
                    System.out.println("Program terminating normally...");

                    break;
            }

            }while (!choice.toUpperCase().equals("Q")); {




            }
        }

    }



    /**
     * Example doc
     * @param args
     * temp in farenheit
     *
     * @Return
     * Temperature in Kelvin
     */

 /**System.out.print("N) Size\n");
         System.out.print("V) Size\n");
         System.out.print("C) Size\n");
         System.out.print("E) Size\n");
         System.out.print("D) Size\n");
  */