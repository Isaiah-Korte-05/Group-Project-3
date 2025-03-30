package midiPlayer;

import java.util.List;

import javax.sound.midi.*;

import midiComposition.fileData.*;
import midiComposition.eventFactories.*;
import midiComposition.eventFactories.factoryTypes.*;
import midiComposition.strategy.instrument.*;
import midiComposition.strategy.pitch.*;

public class Main {

	public static void main(String[] args) {

		try {
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./files/mystery_song.csv");
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
			
			int eventSelector = 0;
			int pitchSelector = 0;
			int instrumentSelector = 0;
			
			MidiEventFactoryAbstract factoryAbstract = null;
			MidiEventFactory factory = null;
			
			switch(eventSelector) {
			case 0:
				factoryAbstract = new StandardMidiEventFactory();
				factory = factoryAbstract.createFactory();
				break;
			case 1:
				factoryAbstract = new LegatoMidiEventFactory();
				factory = factoryAbstract.createFactory();
				break;
			case 2:
				factoryAbstract = new StaccatoMidiEventFactory();
				factory = factoryAbstract.createFactory();
				break;
			}
			
			InstrumentStrategy instrumentStrategy = null;
			
			switch(eventSelector) {
			case 0:
				instrumentStrategy = new AcousticGrandPianoStrategy();
				instrumentStrategy.applyInstrument(track, 0);
				break;
			case 1:
				instrumentStrategy = new ElectricBassGuitarStrategy();
				instrumentStrategy.applyInstrument(track, 0);
				break;
			case 2:
				instrumentStrategy = new TrumpetStrategy();
				instrumentStrategy.applyInstrument(track, 0);
				break;
			}
			
			PitchStrategy pitchStrategy = null;
			
			switch(eventSelector) {
			case 0:
				pitchStrategy = new LowerPitchStrategy();
				break;
			case 1:
				pitchStrategy = new HigherPitchStrategy();
				break;
			}
			
			for(MidiEventData event : midiEvents) {
				int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
				
				if(event.getNoteOnOff() == ShortMessage.NOTE_ON) {
					track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getVelocity(), event.getChannel()));
				}
				else {
					track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
				}
			}
			
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.start();
			
			while(sequencer.isRunning() | sequencer.isOpen()) {
				Thread.sleep(100);
			}
			Thread.sleep(500);
			sequencer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
