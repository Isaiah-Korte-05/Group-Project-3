package midiComposition.eventFactories.abstractFactories;

import midiComposition.eventFactories.MidiEventFactory;
import midiComposition.eventFactories.MidiEventFactoryAbstract;
import midiComposition.eventFactories.factoryTypes.StandardMidiEventFactory;

public class StandardMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	@Override
	public MidiEventFactory createFactory() {
		return new StandardMidiEventFactory();
	}

}