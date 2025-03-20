package midiComposition.strategy.pitch;

public class LowerPitchStrategy implements PitchStrategy {

	public int modifyPitch(int note) {
		note -= 2;
		return note;
	}
	
}
