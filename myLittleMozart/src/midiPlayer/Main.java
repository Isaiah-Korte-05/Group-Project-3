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
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv("C:\\Users\\isaia\\git\\Group-Project-3\\myLittleMozart\\src\\midiPlayer\\files\\mystery_song.csv");
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			Track track = sequence.createTrack();
			
			boolean doBreak = false;
			
			try (Scanner scanner = new Scanner(System.in)) {
				MidiEventFactoryAbstract factoryAbstract = null;
				MidiEventFactory factory = null;
				
				while(!doBreak) {
					System.out.println("Please select which Note Length Behavior you wish to apply:");
					System.out.println("[0] Standard Length");
					System.out.println("[1] Legato");
					System.out.println("[2] Staccato\n");
					int eventSelector = scanner.nextInt();
					
					switch(eventSelector) {
					case 0:
						factoryAbstract = new StandardMidiEventFactoryAbstract();
						factory = factoryAbstract.createFactory();
						doBreak = true;
						break;
					case 1:
						factoryAbstract = new LegatoMidiEventFactoryAbstract();
						factory = factoryAbstract.createFactory();
						doBreak = true;
						break;
					case 2:
						factoryAbstract = new StaccatoMidiEventFactoryAbstract();
						factory = factoryAbstract.createFactory();
						doBreak = true;
						break;
					default:
						System.err.println("Invalid input, please try again.");
						break;
					}
				}
				
				InstrumentStrategy instrumentStrategy = null;
				doBreak = false;
				
				while(!doBreak) {
					System.out.println("\nPlease select which instrument you wish to apply:");
					System.out.println("[0] Acoustic Grand Piano");
					System.out.println("[1] Electric Bass Guitar");
					System.out.println("[2] Trumpet\n");
					int instrumentSelector = scanner.nextInt();
					
					switch(instrumentSelector) {
					case 0:
						instrumentStrategy = new AcousticGrandPianoStrategy();
						instrumentStrategy.applyInstrument(track, 0);
						doBreak = true;
						break;
					case 1:
						instrumentStrategy = new ElectricBassGuitarStrategy();
						instrumentStrategy.applyInstrument(track, 0);
						doBreak = true;
						break;
					case 2:
						instrumentStrategy = new TrumpetStrategy();
						instrumentStrategy.applyInstrument(track, 0);
						doBreak = true;
						break;
					default:
						System.err.println("Invalid input, please try again.");
					}
				}
				
				PitchStrategy pitchStrategy = null;
				doBreak = false;
				
				while(!doBreak) {
					System.out.println("\nPlease select which pitch adjustment you wish to apply:");
					System.out.println("[0] Lower");
					System.out.println("[1] Higher\n");
					int pitchSelector = scanner.nextInt();
					
					switch(pitchSelector) {
					case 0:
						pitchStrategy = new LowerPitchStrategy();
						doBreak = true;
						break;
					case 1:
						pitchStrategy = new HigherPitchStrategy();
						doBreak = true;
						break;
					default:
						System.err.println("Invalid input, please try again.");
					}
				}
				
				for(MidiEventData event : midiEvents) {
					int modifiedNote = pitchStrategy.modifyPitch(event.getNote());
					
					if(event.getNoteOnOff() == (int)ShortMessage.NOTE_ON) {
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
