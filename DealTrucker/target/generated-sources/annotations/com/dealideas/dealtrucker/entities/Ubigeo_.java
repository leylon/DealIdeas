package com.dealideas.dealtrucker.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ubigeo.class)
public abstract class Ubigeo_ {

	public static volatile SingularAttribute<Ubigeo, String> descripcion;
	public static volatile CollectionAttribute<Ubigeo, Servicio> serviciosOrigen;
	public static volatile SingularAttribute<Ubigeo, String> codigo;
	public static volatile CollectionAttribute<Ubigeo, Servicio> serviciosDestino;
	public static volatile SingularAttribute<Ubigeo, Provincia> provincia;

}

