package midiComposition.eventFactories.factoryTypes;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

import midiComposition.eventFactories.MidiEventFactory;

public class StaccatoMidiEventFactory implements MidiEventFactory {

	@Override
	public MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException {
		try {
			ShortMessage message = new ShortMessage();
			message.setMessage(ShortMessage.NOTE_ON, channel, note, velocity);
			return new MidiEvent(message, tick - 120);
		} catch (InvalidMidiDataException e) {
			throw new InvalidMidiDataException("Error creating NoteOn event: " + e.getMessage());
		}
	}

	@Override
	public MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException {
		try {
			ShortMessage message = new ShortMessage();
			message.setMessage(ShortMessage.NOTE_OFF, channel, note);
			return new MidiEvent(message, tick - 120);
		} catch (InvalidMidiDataException e) {
			throw new InvalidMidiDataException("Error creating NoteOff event: " + e.getMessage());
		}
	}
	
}
