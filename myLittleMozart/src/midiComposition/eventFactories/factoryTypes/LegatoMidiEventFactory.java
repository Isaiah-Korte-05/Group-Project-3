package midiComposition.eventFactories.factoryTypes;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

import midiComposition.eventFactories.MidiEventFactory;

public class LegatoMidiEventFactory implements MidiEventFactory {
	
	/**
	 * This creates a MIDI "Note On" event with the legato length behavior
	 * that indicates the start of a note played.
	 */
	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		try {
			ShortMessage message = new ShortMessage();
			message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
			return new MidiEvent(message, tick);
		} catch (InvalidMidiDataException e) {
			throw new InvalidMidiDataException("Error creating NoteOn event: " + e.getMessage());
		}
	}

	/**
	 * This creates a MIDI "Note Off" event with the legato length behavior
	 * that indicates the end of a note played
	 */
	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		try {
			ShortMessage message = new ShortMessage();
			message.setMessage(ShortMessage.NOTE_OFF, channel, note, 0);	
			return new MidiEvent(message, tick + 80);
		} catch (InvalidMidiDataException e) {
			throw new InvalidMidiDataException("Error creating NoteOff event: " + e.getMessage());
		}
	}

}
