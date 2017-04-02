package com.dealideas.dealtrucker.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Persona.class)
public abstract class Persona_ {

	public static volatile SingularAttribute<Persona, String> apellidos;
	public static volatile SingularAttribute<Persona, String> password;
	public static volatile SingularAttribute<Persona, Chofer> chofer;
	public static volatile CollectionAttribute<Persona, Monitoreo> monitoreoCollection;
	public static volatile SingularAttribute<Persona, String> telefono;
	public static volatile SingularAttribute<Persona, Empresa> empresa;
	public static volatile SingularAttribute<Persona, String> email;
	public static volatile SingularAttribute<Persona, RolPersona> rol;
	public static volatile SingularAttribute<Persona, String> username;
	public static volatile SingularAttribute<Persona, String> nombres;

}

