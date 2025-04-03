package midiComposition.strategy.instrument;

import javax.sound.midi.Track;

public interface InstrumentStrategy {
	
	/**
	 * This applies a MIDI instrument change to the given track and on the
	 * specified channel.
	 * @param track
	 * 		  This takes a MIDI track and represents the track on which the instrument
	 * 		  change is to be applied
	 * @param channel
	 * 		  This takes an int and represents the MIDI channel on which the instrument
	 * 		  change is to be applied
	 */
	void applyInstrument(Track track, int channel);

}
