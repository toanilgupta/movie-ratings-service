package com.microservices.ratingsdata.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;*/

@RestController
@RequestMapping("/secured")
//@Path("/secured")
public class SecuredResource {

    //@GET
    //@Path("/{message}")
    @RequestMapping("/{movieName}")
    //@Produces(MediaType.TEXT_PLAIN)
    public String secureMethod(){
        return "This API needs login";
    }

}
