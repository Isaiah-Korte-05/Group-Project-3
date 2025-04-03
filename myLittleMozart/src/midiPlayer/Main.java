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
			
			// Obtains the filename of the given mystery song
			String filename = System.getProperty("user.dir") + "\\src\\midiPlayer\\files\\mystery_song.csv";
			
			// Parses the CSV file and creates a list of MIDI data
			List<MidiEventData> midiEvents = MidiCsvParser.parseCsv(filename);
			// Creates new MIDI sequence
			Sequence sequence = new Sequence(Sequence.PPQ, 384);
			// Creates track in MIDI sequence
			Track track = sequence.createTrack();
			
			// Variable used to ensure correct option input
			boolean doBreak = false;
			
			// Sets up new scanner for user input
			try (Scanner scanner = new Scanner(System.in)) {
				// Initializes abstract factory and corresponding factory
				MidiEventFactoryAbstract factoryAbstract = null;
				MidiEventFactory factory = null;
				
				// Selection for note length behavior; creates corresponding abstract factory and creates corresponding concrete factory
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
				
				// Initializes strategy to select instrument
				InstrumentStrategy instrumentStrategy = null;
				// Resets selection boolean
				doBreak = false;
				
				// Selection for instrument strategy and applies it to MIDI track
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
						instrumentStrategy.applyInstrument(track, 1);
						instrumentStrategy.applyInstrument(track, 2);
						instrumentStrategy.applyInstrument(track, 3);
						instrumentStrategy.applyInstrument(track, 4);
						doBreak = true;
						break;
					case 1:
						instrumentStrategy = new ElectricBassGuitarStrategy();
						instrumentStrategy.applyInstrument(track, 0);
						instrumentStrategy.applyInstrument(track, 1);
						instrumentStrategy.applyInstrument(track, 2);
						instrumentStrategy.applyInstrument(track, 3);
						instrumentStrategy.applyInstrument(track, 4);
						doBreak = true;
						break;
					case 2:
						instrumentStrategy = new TrumpetStrategy();
						instrumentStrategy.applyInstrument(track, 0);
						instrumentStrategy.applyInstrument(track, 1);
						instrumentStrategy.applyInstrument(track, 2);
						instrumentStrategy.applyInstrument(track, 3);
						instrumentStrategy.applyInstrument(track, 4);
						doBreak = true;
						break;
					default:
						System.err.println("Invalid input, please try again.");
					}
				}
				
				// Initializes strategy to affect pitch
				PitchStrategy pitchStrategy = null;
				// Resets selection boolean
				doBreak = false;
				
				// Selection for pitch change; creates corresponding concrete class
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
				
				// Iterates through MIDI event data list to apply each method
				for(MidiEventData event : midiEvents) {
					// Applies pitch modification five (5) times
					int modifiedNote = pitchStrategy.modifyPitch(event.getNote());;
					for(int i = 0; i < 4; i++) {modifiedNote = pitchStrategy.modifyPitch(modifiedNote);}
					
					// Uses correct factory based on previously selected note length factory and if current note is ON/OFF
					if(event.getNoteOnOff() == ShortMessage.NOTE_ON) {
						track.add(factory.createNoteOn(event.getStartEndTick(), modifiedNote, event.getVelocity(), event.getChannel()));
					}
					else {
						track.add(factory.createNoteOff(event.getStartEndTick(), modifiedNote, event.getChannel()));
					}
				}
			}
			
			// Gets instance of MIDI sequencer
			Sequencer sequencer = MidiSystem.getSequencer();
			// Opens MIDI sequencer
			sequencer.open();
			// Gives sequence build above to MIDI sequencer
			sequencer.setSequence(sequence);
			// Plays track in MIDI sequence
			sequencer.start();
			
			// While MIDI sequence is open or running, pause program and wait
			while(sequencer.isRunning() | sequencer.isOpen()) {
				Thread.sleep(100);
			}
			Thread.sleep(500);
			// Closes MIDI sequence
			sequencer.close();
						
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
