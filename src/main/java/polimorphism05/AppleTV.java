package polimorphism05;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("AppleTV")
public class AppleTV implements TV {
	
	//@Resource(name="speaker2") //@Autowired +@qualifier
	
	@Autowired
	@Qualifier("speaker2")
	private Speaker speaker ;

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
		speaker.volumeUp();

	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}

}