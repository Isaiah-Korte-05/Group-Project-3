package midiComposition.strategy.pitch;

public class LowerPitchStrategy implements PitchStrategy {

	/**
	 * This lowers the given note pitch by 2 semitones.
	 */
	public int modifyPitch(int note) {
		note -= 2;
		return note;
	}
	
}
