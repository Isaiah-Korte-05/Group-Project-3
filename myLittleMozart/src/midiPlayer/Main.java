package midiPlayer;

import java.util.List;
import java.util.Scanner;

import javax.sound.midi.*;

import midiComposition.fileData.*;
import midiComposition.eventFactories.*;
import midiComposition.eventFactories.abstractFactories.*;
import midiComposition.strategy.instrument.*;
import midiComposition.strategy.pitch.*;

public class Main {

	public static void main(String[] args) {

		try {
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("./files/mystery_song.csv");
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
			
			try (Scanner scanner = new Scanner(System.in)) {
				MidiEventFactoryAbstract factoryAbstract = null;
				MidiEventFactory factory = null;
				
				System.out.println("Please select which Note Length Behavior you wish to apply:");
				System.out.println("[0] Standard Length");
				System.out.println("[1] Legato");
				System.out.println("[2] Staccato");
				int eventSelector = scanner.nextInt();
				
				switch(eventSelector) {
				case 0:
					factoryAbstract = new StandardMidiEventFactoryAbstract();
					factory = factoryAbstract.createFactory();
					break;
				case 1:
					factoryAbstract = new LegatoMidiEventFactoryAbstract();
					factory = factoryAbstract.createFactory();
					break;
				case 2:
					factoryAbstract = new StaccatoMidiEventFactoryAbstract();
					factory = factoryAbstract.createFactory();
					break;
				}
				
				InstrumentStrategy instrumentStrategy = null;
				
				System.out.println("Please select which instrument you wish to apply:");
				System.out.println("[0] Acoustic Grand Piano");
				System.out.println("[1] Electric Bass Guitar");
				System.out.println("[2] Trumpet");
				int instrumentSelector = scanner.nextInt();
				
				switch(instrumentSelector) {
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
				
				System.out.println("Please select which pitch adjustment you wish to apply:");
				System.out.println("[0] Lower");
				System.out.println("[1] Higher");
				int pitchSelector = scanner.nextInt();
				
				switch(pitchSelector) {
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
