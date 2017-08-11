package com.afs.nats.stdapp.model;

import java.util.ArrayList;
import java.util.List;

public enum Role {
	ADMIN, USER;
	
	public static final List<Role> getValues(){
		List<Role> roles = new ArrayList<>();
		roles.add(ADMIN);
		roles.add(USER);
//		return new ArrayList<TipoDocumento>(Arrays.asList(TipoDocumento.values()));
		return roles;
	}
}
