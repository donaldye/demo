package newPackage;

import newPackage.dto.Account;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//from: https://www.baeldung.com/spring-cors
//to test using Postman (by setting the header: Origin=http://abc.com), or
//curl -X OPTIONS "http://localhost:8080/account/123" -H "Origin: https://abc.com" -H "Access-Control-Request-Method: DELETE"
//curl -X OPTIONS "http://localhost:8080/account/123" -H "Origin: http://example.com" -H "Access-Control-Request-Method: DELETE"
//curl -X OPTIONS "http://localhost:8080/account/123" -H "Origin: http://abc.com" -H "Access-Control-Request-Method: GET"

//see csrf: https://onedrive.live.com/view.aspx?resid=F0FE3CF1BCF6058C%21113&id=documents&wd=target%28Modern%20Web.one%7C82533ED0-7FD0-47CC-A41F-D05718CDA8BF%2FCORS-Cross%20Origin%20Resource%20Sharing%7CC707D762-E6E0-4F8A-8384-6504B6BDCC75%2F%29
//onenote:https://d.docs.live.net/f0fe3cf1bcf6058c/Documents/Ye-Notes/Modern%20Web.one#CORS-Cross%20Origin%20Resource%20Sharing&section-id={82533ED0-7FD0-47CC-A41F-D05718CDA8BF}&page-id={C707D762-E6E0-4F8A-8384-6504B6BDCC75}&end

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/account")
public class AccountController {

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Account retrieve(@PathVariable Long id) {
        System.out.println("return account id " + id);
        return new Account(id);
    }

    @CrossOrigin("http://example.com")
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public void remove(@PathVariable Long id) {
        System.out.println("Deleted account id " + id);
    }
}