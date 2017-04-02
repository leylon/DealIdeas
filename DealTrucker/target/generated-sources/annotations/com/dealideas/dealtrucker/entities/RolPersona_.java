package com.dealideas.dealtrucker.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RolPersona.class)
public abstract class RolPersona_ {

	public static volatile SingularAttribute<RolPersona, Integer> idRol;
	public static volatile SingularAttribute<RolPersona, String> nombre;
	public static volatile CollectionAttribute<RolPersona, Persona> personas;

}

