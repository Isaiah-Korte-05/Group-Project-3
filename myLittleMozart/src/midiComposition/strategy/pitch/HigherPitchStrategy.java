package midiComposition.strategy.pitch;

public class HigherPitchStrategy implements PitchStrategy {

	/**
	 * This raises the given note pitch by 2 semitones.
	 */
	public int modifyPitch(int note) {
		note += 2;
		return note;
	}

}
