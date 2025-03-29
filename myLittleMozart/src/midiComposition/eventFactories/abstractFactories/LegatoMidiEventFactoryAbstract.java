package midiComposition.eventFactories.abstractFactories;

import midiComposition.eventFactories.MidiEventFactory;
import midiComposition.eventFactories.MidiEventFactoryAbstract;
import midiComposition.eventFactories.factoryTypes.LegatoMidiEventFactory;

public class LegatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	@Override
	public MidiEventFactory createFactory() {
		return new LegatoMidiEventFactory();
	}

}
