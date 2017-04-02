package com.dealideas.dealtrucker.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Chofer.class)
public abstract class Chofer_ {

	public static volatile CollectionAttribute<Chofer, Servicio> servicios;
	public static volatile SingularAttribute<Chofer, String> nrolicencia;
	public static volatile SingularAttribute<Chofer, Persona> persona;
	public static volatile SingularAttribute<Chofer, String> username;

}

