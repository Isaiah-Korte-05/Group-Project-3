package midiComposition.fileData;

import java.io.*;
import java.util.*;

public class MidiCsvParser {

	public static List<MidiEventData> parseCsv(String fileName) {
		
		int startEndTick;
		int noteOnOff;
		int channel;
		int note;
		int velocity;
		int instrument;
		
		List<MidiEventData> list = new ArrayList<>();
		
		String line;
        String csvDelimiter= ",";
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            while ((line = br.readLine()) != null) {
            	
                String[] data = line.split(csvDelimiter);
                
                startEndTick = Integer.parseInt(data[0]);
                
                String noteState = data[1];
                if(noteState.equals(" Note_on_c")) {
                	noteOnOff = 144;
                }
                else {
                	noteOnOff = 128;
                }
                
                channel = Integer.parseInt(data[2]);
                note = Integer.parseInt(data[3]);
                velocity = Integer.parseInt(data[4]);
                instrument = Integer.parseInt(data[5]);
                
            	list.add(new MidiEventData(startEndTick, noteOnOff, channel, note, velocity, instrument));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return list;
	}

}
