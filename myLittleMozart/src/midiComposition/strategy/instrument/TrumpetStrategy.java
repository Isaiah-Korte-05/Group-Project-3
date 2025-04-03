package midiComposition.strategy.instrument;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class TrumpetStrategy implements InstrumentStrategy {

	/**
	 * This applies a MIDI instrument change to a trumpet to the given track and
	 * on the specified channel.
	 * @throws InvalidMidiDataException if there is an error creating the MIDI short
	 * 		   message or if any of the provided parameters are invalid
	 */
	@Override
	public void applyInstrument(Track track, int channel) {
		try {
			ShortMessage message = new ShortMessage();
			message.setMessage(ShortMessage.PROGRAM_CHANGE, channel, 56, 0);
			MidiEvent event = new MidiEvent(message, 0);
			track.add(event);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}

}