package midiComposition.eventFactories.abstractFactories;

import midiComposition.eventFactories.MidiEventFactory;
import midiComposition.eventFactories.MidiEventFactoryAbstract;
import midiComposition.eventFactories.factoryTypes.LegatoMidiEventFactory;

public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	/**
	 * This creates a new instance of a factory with legato note length behavior,
	 * or smooth and connected notes with longer durations of notes and minimal
	 * gaps between notes.
	 * @return a new LegatoMidiEventFactory instance.
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new LegatoMidiEventFactory();
	}

}
