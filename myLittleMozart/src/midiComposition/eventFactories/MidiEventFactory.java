package midiComposition.eventFactories;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;

public interface MidiEventFactory {
	
	/**
	 * This creates a MIDI "Note On" event that indicates the start of a note played
	 * @param tick
	 * 		  this parameter takes an int and represents the tick, or time
	 * 		  position, where the note event occurs in the MIDI track
	 * @param note
	 * 		  this parameter takes an int and represents the MIDI note number
	 * @param velocity
	 * 		  this parameter takes an int and represents the velocity, or
	 * 		  intensity, of the note
	 * @param channel
	 * 		  this parameter takes an int and represents the MIDI channel on
	 * 		  which the note is played
	 * @return a new MidiEvent instance
	 * @throws InvalidMidiDataException if there is an error creating the MIDI
	 * 									event or if any of the provided parameters
	 * 									are invalid
	 */
	MidiEvent createNoteOn(int tick, int note, int velocity, int channel) throws InvalidMidiDataException;
	
	/**
	 * This creates a MIDI "Note Off" event that indicates the end of a note played
	 * @param tick
	 * 		  this parameter takes an int and represents the tick, or time
	 * 		  position, where the note event occurs in the MIDI track
	 * @param note
	 * 		  this parameter takes an int and represents the MIDI note number
	 * @param velocity
	 * 		  this parameter takes an int and represents the velocity, or
	 * 		  intensity, of the note
	 * @param channel
	 * 		  this parameter takes an int and represents the MIDI channel on
	 * 		  which the note is played
	 * @return a new MidiEvent instance
	 * @throws InvalidMidiDataException if there is an error creating the MIDI
	 * 									event or if any of the provided parameters
	 * 									are invalid
	 */
	MidiEvent createNoteOff(int tick, int note, int channel) throws InvalidMidiDataException;

}
