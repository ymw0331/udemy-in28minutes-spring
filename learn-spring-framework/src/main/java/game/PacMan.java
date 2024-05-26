package game;

public class PacMan implements GamingConsole {

	@Override
	public void up() {
		System.out.println("PacMan heading up");

	}

	@Override
	public void down() {
		System.out.println("PacMan heading down");

	}

	@Override
	public void left() {
		System.out.println("PacMan turning left");

	}

	@Override
	public void right() {
		System.out.println("PacMan turning right");

	}

}
