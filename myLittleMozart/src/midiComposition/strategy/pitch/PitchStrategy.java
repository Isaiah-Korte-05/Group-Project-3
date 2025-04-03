package midiComposition.strategy.pitch;

public interface PitchStrategy {
	
	/**
	 * Modifies the note pitch by 2 semitones.
	 * @param note This parameter is an integer representation note pitch
	 * @return Returns new modified note pitch
	 */
	int modifyPitch(int note);

}
