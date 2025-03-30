package midiComposition.fileData;

public class MidiEventData {
	
	private int startEndTick;
	private int noteOnOff;
	private int channel;
	private int note;
	private int velocity;
	private int instrument;
	
	public MidiEventData(int startEndTick, int noteOnOff, int channel, 
							int note, int velocity, int instrument) {
		this.startEndTick = startEndTick;
		this.noteOnOff = noteOnOff;
		this.channel = channel;
		this.note = note;
		this.velocity = velocity;
		this.instrument = instrument;
	}

	public int getStartEndTick() {
		return startEndTick;
	}

	public void setStartEndTick(int startEndTick) {
		this.startEndTick = startEndTick;
	}

	public int getNoteOnOff() {
		return noteOnOff;
	}

	public void setNoteOnOff(int noteOnOff) {
		this.noteOnOff = noteOnOff;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getInstrument() {
		return instrument;
	}

	public void setInstrument(int instrument) {
		this.instrument = instrument;
	}

}
