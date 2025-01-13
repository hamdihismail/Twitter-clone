package org.ac.cst8277.ismail.hamdi.ums.util;
import java.util.UUID;

public class TokenUtil {
	UUID token;
	
	String uuidAsString = token.toString();

    public UUID generateToken() {  
    		this.token = UUID.randomUUID();
    		return token;
    }
}
