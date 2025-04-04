package midiComposition.fileData;

import java.io.*;
import java.util.*;

public class MidiCsvParser {

	/**
	 * This iterates through entire CSV file and reads data into MidiEventData list
	 * @param fileName This parameter is a string of CSV file name
	 * @return Returns MidiEventData list of parsed data
	 */
	public static List<MidiEventData> parseCsv(String fileName) {
		
		// Different fields of MidiEventData class to be read
		int startEndTick;
		int noteOnOff;
		int channel;
		int note;
		int velocity;
		int instrument;
		
		// Creates new ArrayList of type MidiEventData
		List<MidiEventData> list = new ArrayList<>();
		
		// Buffer for each line to be read
		String line;
		// Delimiter to separate each segment of data
        String csvDelimiter= ",";
        
        // Creates new buffer for file reader to read to
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

        	// Iterates through file by line
            while ((line = br.readLine()) != null) {
            	
            	// Splits each data segment on a line by delimiter into String array
                String[] data = line.split(csvDelimiter);
                
                // Converts each data segment to integer to save to MidiEventData
                startEndTick = Integer.parseInt(data[0]);
                
                String noteState = data[1];
                if(noteState.equals(" Note_on_c")) {
			// Integer equivalent of NOTE_ON
                	noteOnOff = 144;
                }
                else {
			// Integer equivalent of NOTE_OFF
                	noteOnOff = 128;
                }
                
                channel = Integer.parseInt(data[2]);
                note = Integer.parseInt(data[3]);
                velocity = Integer.parseInt(data[4]);
                instrument = Integer.parseInt(data[5]);
                
                // Adds new MidiEventData element to list with read data
            	list.add(new MidiEventData(startEndTick, noteOnOff, channel, note, velocity, instrument));
            }

        } 
	// If error reading CSV file
	catch (IOException e) {
            e.printStackTrace();
        }
		
		return list;
	}

}
