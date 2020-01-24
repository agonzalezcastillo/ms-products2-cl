package com.bct.msproducts2cl.api;

import com.bct.msproducts2cl.model.JwtUser;
import com.bct.msproducts2cl.security.JwtGenerator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
@AllArgsConstructor
public class TokenApi {

    JwtGenerator jwtGenerator;

    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser){
        return jwtGenerator.generate(jwtUser);
    }

}
