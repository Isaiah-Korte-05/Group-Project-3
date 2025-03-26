package midiComposition.fileData;

public class MidiEventData {
	
	private int channel;
	private int note;
	private int startTick;
	private int endTick;
	private int velocity;
	private int instrument;
	
	public MidiEventData(int channel, int note, int startTick, int endTick, int velocity, int instrument) {
		this.channel = channel;
		this.note = note;
		this.startTick = startTick;
		this.endTick = endTick;
		this.velocity = velocity;
		this.instrument = instrument;
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

	public int getStartTick() {
		return startTick;
	}

	public void setStartTick(int startTick) {
		this.startTick = startTick;
	}

	public int getEndTick() {
		return endTick;
	}

	public void setEndTick(int endTick) {
		this.endTick = endTick;
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
