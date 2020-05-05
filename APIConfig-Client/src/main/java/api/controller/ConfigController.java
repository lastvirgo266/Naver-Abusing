package api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {
	
	@Value("${re.bye.suhyeon}")
	private String suhyeon;
	
	@Value("${re.bye.chanhyeok}")
	private String chanhyeok;
	
	@GetMapping("/akmu")
	public String test() {
		return suhyeon + "  " + chanhyeok;
	}

}
