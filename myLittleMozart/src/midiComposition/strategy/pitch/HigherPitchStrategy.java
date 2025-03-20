package midiComposition.strategy.pitch;

public class HigherPitchStrategy implements PitchStrategy {

	public int modifyPitch(int note) {
		note += 2;
		return note;
	}

}
