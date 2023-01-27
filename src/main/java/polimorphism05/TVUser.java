package polimorphism05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {

		
	// ��ü ������ Spring Framework���� ���� �� DI�� ���ؼ� ��ü�� ����
		// 1. XML ���Ͽ��� ��ü�� �����ؼ� ����
			// src/main/resource : �ַ� ������ ���õ� ������ �����ϴ� �� (mybatis ���ۼ���, bean�� xml, db Connection ����)
				// applicationContext.xml : Bean�� �����ϴ� ���� 
		// 2. @(������̼�)�� ����ؼ� ��ü�� ���� �� DI(��ü�� ����) <== Spring Boot ����ϴ� ���
			//a. @(������̼�)�� ����� �� �ֵ��� ������ �ʿ���.
			// applicationContext.xml : Bean ���� ����, ������̼��� ����� �� �ֵ��� ���� �ʿ� (context ���)
			//<context:component-scan base-package="polimophism05"></context:component-scan>
			//<context:component-scan base-package="com.spring"></context:component-scan>
			// b. Ŭ���� ���� @Component ������̼��� �ٿ��� ��ü�� ����
				// �پ��� ������ Ŭ������ �����ϱ� ������ Ŭ������ ������ ���� ���� �̸����� ������̼��� ����.
			// @component	: �Ϲ����� Ŭ������ Bean (��üȭ) ����
			// @service		: ����Ͻ� ������ ó���ϴ� Ŭ������ Bean ����
			// @Repository	: ������ ���̽� ������ ó���ϴ� DAO Ŭ������ ����
			// @Controller	: ����� ��û�� Controller Ŭ������ �ٿ��ִ� 
		// c. Spring Framework ���� ������ ��ü�� ������ ����(DI)�ϴ� ������̼�
				// @Autowired : �ش� Ÿ���� ��ü�� ã�Ƽ� �ڵ����� �Ҵ��ϴ� ������̼�,
						// �ش�Ÿ���� ��ü�� ���� �� ������ ��� ������ �߻�
				// @Qualifier : Ư�� ��ü �̸��� ����ؼ� �ҷ����� ��, @Autowired �� ���� �����
				
				// @Inject : �ڹٿ��� �����Ǵ� ������̼�, @autowired�� ������ ������̼� (Ÿ������ ��ü�� ������ �´�.)
				// @resource : �ڹٿ��� �����ϴ� ������̼�, <== �̸����� ��ü�� �ĺ�
					// @Autowired + @Qualifier �� �ϳ��� �����.
		
		
// 1. Spring �����̳ʸ� ����
	AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
	
		
		
// 2. Spring �����̳ʷ� ���� �ʿ��� ��ü�� Lookup�Ѵ�. : DI (��ü�� ����)
	TV tv = (TV) factory.getBean("tv3");
	
	tv.powerOn();
	tv.powerOff();
	tv.volumeUp();
	tv.volumeDown();

	}

}
