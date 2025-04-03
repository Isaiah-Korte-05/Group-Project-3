package midiComposition.eventFactories.abstractFactories;

import midiComposition.eventFactories.MidiEventFactory;
import midiComposition.eventFactories.MidiEventFactoryAbstract;
import midiComposition.eventFactories.factoryTypes.StaccatoMidiEventFactory;

public class StaccatoMidiEventFactoryAbstract implements MidiEventFactoryAbstract {

	/**
	 * This creates a new instance of a factory with staccato note length behavior,
	 * or short and detached notes with shorter durations of notes and gaps
	 * between notes.
	 * @return a new StandardMidiEventFactory instance.
	 */
	@Override
	public MidiEventFactory createFactory() {
		return new StaccatoMidiEventFactory();
	}
	
	

}
