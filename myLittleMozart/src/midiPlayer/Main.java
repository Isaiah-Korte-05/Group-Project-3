package midiPlayer;

import java.util.List;

import javax.sound.midi.*;

import midiComposition.fileData.MidiCsvParser;
import midiComposition.fileData.MidiEventData;

public class Main {

	public static void main(String[] args) {

		try {
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./files/mystery_song.csv");
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
