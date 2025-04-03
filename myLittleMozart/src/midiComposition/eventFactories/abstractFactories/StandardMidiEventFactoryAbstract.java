package midiComposition.eventFactories.abstractFactories;

import midiComposition.eventFactories.MidiEventFactory;
import midiComposition.eventFactories.MidiEventFactoryAbstract;
import midiComposition.eventFactories.factoryTypes.StandardMidiEventFactory;

public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	/**
	 * This creates a new instance of a factory with standard note length behavior.
	 * @return a new StandardMidiEventFactory instance.
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new StandardMidiEventFactory();
	}

}