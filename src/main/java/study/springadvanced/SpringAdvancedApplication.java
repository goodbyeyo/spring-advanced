package study.springadvanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import study.springadvanced.app.proxy.config.AppV1Config;

@Import(AppV1Config.class)	// Application 이 있는 패키지와 그 하위 패키지를 스캔
@SpringBootApplication(scanBasePackages = "study.springadvanced.app.proxy") //주의
public class SpringAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAdvancedApplication.class, args);
	}

}
