package midiComposition.fileData;

import java.io.*;
import java.util.*;

public class MidiCsvParser {

	public static List<MidiEventData> parseCsv(String fileName) {
		
		int channel;
		int note;
		int startTick;
		int endTick;
		int velocity;
		int instrument;
		
		List<MidiEventData> list = new ArrayList<>();
		
		String line;
        String csvDelimiter= ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            while ((line = br.readLine()) != null) {
            	
                String[] data = line.split(csvDelimiter);
                
                channel = Integer.parseInt(data[0]);
                note = Integer.parseInt(data[1]);
                startTick = Integer.parseInt(data[2]);
                endTick = Integer.parseInt(data[3]);
                velocity = Integer.parseInt(data[4]);
                instrument = Integer.parseInt(data[5]);
                
            	list.add(new MidiEventData(channel, note, startTick, endTick, velocity, instrument));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		return null;
	}

}
