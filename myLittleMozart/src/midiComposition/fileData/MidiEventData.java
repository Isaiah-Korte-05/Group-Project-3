package midiComposition.fileData;

public class MidiEventData {
	
	// Integers representing corresponding data elements of a MIDI event
	private int startEndTick;
	private int noteOnOff;
	private int channel;
	private int note;
	private int velocity;
	private int instrument;
	
	/**
	 * This is a parameterized constructor for MidiEventData
	 * @param startEndTick This is an integer representing beginning of Note_On or Note_Off
	 * @param noteOnOff This is an integer representing if current note is On or Off
	 * @param channel This is an integer representing which of the 16 MIDI channels the current event is on
	 * @param note This is an integer representing note pitch
	 * @param velocity This is an integer representing the velocity or intensity that the note is hit
	 * @param instrument This is an integer representing which of the 128 MIDI instruments the current event is playing
	 */
	public MidiEventData(int startEndTick, int noteOnOff, int channel, 
							int note, int velocity, int instrument) {
		this.startEndTick = startEndTick;
		this.noteOnOff = noteOnOff;
		this.channel = channel;
		this.note = note;
		this.velocity = velocity;
		this.instrument = instrument;
	}

	/**
	 * This is a getter.
	 * @return Returns beginning of Note_On or Note_Off
	 */
	public int getStartEndTick() {
		return startEndTick;
	}

	/**
	 * This is a setter.
	 * @param startEndTick Integer representing beginning of Note_On or Note_Off
	 */
	public void setStartEndTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}

	/**
	 * This is a getter.
	 * @return Returns current note state
	 */
	public int getNoteOnOff() {
		return noteOnOff;
	}

	/**
	 * This is a setter.
	 * @param startEndTick Integer representing note state
	 */
	public void setNoteOnOff(int noteOnOff) {
		this.noteOnOff = noteOnOff;
	}

	/**
	 * This is a getter.
	 * @return Returns channel of current event
	 */
	public int getChannel() {
		return channel;
	}

	/**
	 * This is a setter.
	 * @param startEndTick Integer representing MIDI event channel
	 */
	public void setChannel(int channel) {
		this.channel = channel;
	}

	/**
	 * This is a getter.
	 * @return Returns pitch of current note
	 */
	public int getNote() {
		return note;
	}

	/**
	 * This is a setter.
	 * @param startEndTick Integer representing note pitch
	 */
	public void setNote(int note) {
		this.note = note;
	}

	/**
	 * This is a getter.
	 * @return Returns velocity or intensity of current note
	 */
	public int getVelocity() {
		return velocity;
	}

	/**
	 * This is a setter.
	 * @param startEndTick Integer representing note velocity or intensity
	 */
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	/**
	 * This is a getter.
	 * @return Returns instrument of current event
	 */
	public int getInstrument() {
		return instrument;
	}

	/**
	 * This is a setter.
	 * @param startEndTick Integer representing instrument of current event
	 */
	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}

}
