package com.afs.nats.stdapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TipoDocumento {
	DNI, RUC;
	
	public static final List<TipoDocumento> getValues(){
		List<TipoDocumento> docs = new ArrayList<>();
		docs.add(DNI);
		docs.add(RUC);
//		return new ArrayList<TipoDocumento>(Arrays.asList(TipoDocumento.values()));
		return docs;
	}
}
