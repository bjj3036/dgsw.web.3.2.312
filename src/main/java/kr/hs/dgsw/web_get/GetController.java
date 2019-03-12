package kr.hs.dgsw.web_get;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GetController {

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(required = false, defaultValue = "Hello") String say,
            @RequestParam(required = false, defaultValue = "World") String to
    ) {
        return say + ", " + to + "!";
    }

    @GetMapping(
            value = {
                    "/greeting1/{say}/{to}",
                    "greeting1/{say}",
                    "greeting1//{to}",
                    "greeting1"
            }
    )
    public String sayHello(
            @PathVariable Optional<String> say,
            @PathVariable Optional<String> to
    ) {
        String tmp = to.isPresent() ? to.get() : "NoName";
        return (say.isPresent() ? say.get() : "Hello") + ", " + tmp + "!";
    }
}
