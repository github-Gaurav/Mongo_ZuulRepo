package restDocumentation.restDocs;

import java.util.Collections;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	
	@GetMapping("/get")
	public Map<String, Object> run(){
		System.out.println("Inside get Method");
		return Collections.singletonMap("message", "hello");
		
	}

}
