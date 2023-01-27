package polimorphism03;

public class AppleTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("AppleTV - 전원을 켭니다.");

	}

	@Override
	public void powerOff() {
		System.out.println("AppleTV - 전원을 끕니다.");

	}

	@Override
	public void volumeUp() {
		System.out.println("AppleTV - 소리를 놉입니다.");

	}

	@Override
	public void volumeDown() {
		System.out.println("AppleTV - 소리를 줄입니다.");
	}

}
