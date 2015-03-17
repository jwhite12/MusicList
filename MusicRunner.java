import java.util.*;
public class MusicRunner
{
public static void main (String[] args)
{
int count = 0;
ArrayList<Song> songs = new ArrayList<Song>();
MusicReader musicreader = new MusicReader();
musicreader.open("musiclist.csv");
String[] data = musicreader.getSongData(); // Get next line of song data
System.out.println(Arrays.toString(data));
data = musicreader.getSongData();
// if data is null then we were unable to read a line of song data, so
// this loop will continue to read lines of song data as long as there
// IS song data available
while (data != null)
{
// You probably will comment this out but for now print out the line so you can see what is there
//System.out.println(Arrays.toString(data));
int year = Integer.parseInt(data[3]);
double score = Double.parseDouble(data[4]);
if (data[2].equals("song"))
{
// Let's try to create a Song object
Song song = new Song(data[0], data[1], year, score, data[16]); // data[0] is the artist and data[1] is the name
songs.add(song);
System.out.println("The song \"" + song.name + "\" was dropped by \"" + song.artist + "\" in the fiscal year " + song.year);
count++;
}
if (count == 10) // For now only read ONE song
break;
data = musicreader.getSongData(); // Get next line of song data
}
for(int i = songs.size()-1; i >=0; i--)
{
Song song = songs.get(i);
System.out.println("Song: " + song.name + " | Artist: " + song.artist);
}
musicreader.close();
}
}