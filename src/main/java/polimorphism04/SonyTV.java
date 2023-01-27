package polimorphism04;

public class SonyTV implements TV {

	@Override
	public void powerOn() {
		System.out.println("SonyTV - 전원을 켭니다.");

	}

	@Override
	public void powerOff() {
		System.out.println("SonyTV - 전원을 끕니다.");

	}

	@Override
	public void volumeUp() {
		System.out.println("SonyTV - 소리를 높입니다.");

	}

	@Override
	public void volumeDown() {
		System.out.println("SonyTV - 소리를 줄입니다.");

	}

}
