package study.springadvanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import study.springadvanced.app.proxy.config.AppV1Config;

@Import(AppV1Config.class)
@SpringBootApplication(scanBasePackages = "study.springadvanced.app.proxy")	// 컴포넌트 스캔을 시작할 위치를 지정
public class SpringAdvancedApplication {	// sacnBasePackage 없으면 Application 이 있는 패키지와 하위패키지를 스캔

	public static void main(String[] args) {
		SpringApplication.run(SpringAdvancedApplication.class, args);
	}

}
