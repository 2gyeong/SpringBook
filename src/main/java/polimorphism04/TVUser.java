package polimorphism04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {

		
	// 객체 생성을 Spring Framework에서 생성 후 DI를 통해서 객체를 주입
		// 1. XML 파일에서 객체를 생성해서 주입
			// src/main/resource : 주로 설정에 관련된 내용을 저장하는 곳 (mybatis 매퍼설정, bean의 xml, db Connection 설정)
				// applicationContext.xml : Bean을 셋팅하는 파일 
		// 2. @(어노테이션)을 사용해서 객체를 생성 후 DI(객체를 주입) <== Spring Boot 사용하는 방식
	
		
		
// 1. Spring 컨테이너를 구동
	AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
	
		
		
// 2. Spring 컨테이너로 부터 필요한 객체를 Lookup한다. : DI (객체를 주입)
	TV tv = (TV) factory.getBean("tv");
	
	tv.powerOn();
	tv.powerOff();
	tv.volumeUp();
	tv.volumeDown();

	}

}
