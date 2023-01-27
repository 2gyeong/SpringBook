package polimorphism01;

public class TVUser {

	public static void main(String[] args) {
		// ������(�ڵ��� ���յ��� ����) : ���� ������ ��ư� �ϴ� �ڵ��̴�.
			// 1. �ڵ��� ���յ��� �����ϰ� �ؼ� ���� ������ ���� �ϴ� �ڵ�
				// a. �������̽��� ����ؼ� ������ ��ü���� ������ �޼ҵ� �̸��� ���
				// b. ��ü ������ �����ڰ� �ڵ峻�ο��� �����ϴ� ���� �ƴ϶� Spring �����ӿ�ũ���� ����(IoC)
						//��ü�� �ʿ��� ���� ����(DI)
						// Bean (��ü): �����ӿ�ũ���� �����ؼ� ����
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		System.out.println("================");

		// TV ����ڰ� Samsung TV���� lgTV�� �ٲ����.
		
		LgTV tv2 = new LgTV(); 
		tv2.turnOn();
		tv2.turnOff();
		tv2.soundUp();
		tv2.soundDown();
	}

}