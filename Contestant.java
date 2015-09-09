
public class Contestant implements Comparable<Contestant> {

	private final String NAME;
	private final int WINS;
	private final int LOSSES;

	public Contestant(String name) {
		NAME = name;
		WINS = -1;
		LOSSES = -1;
	}

	public Contestant(String name, int prelimWins, int prelimLosses) {
		NAME = name;
		WINS = prelimWins;
		LOSSES = prelimLosses;
	}

	public String getName() {
		return NAME;
	}

	public int getWins() {
		return WINS;
	}

	public int getLosses() {
		return LOSSES;
	}

	@Override
	public int compareTo(Contestant other) {
		return (other.getWins() - other.getLosses()) - (WINS - LOSSES);
	}

}
