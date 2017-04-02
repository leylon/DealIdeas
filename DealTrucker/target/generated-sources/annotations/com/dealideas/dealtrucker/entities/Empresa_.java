package com.dealideas.dealtrucker.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Empresa.class)
public abstract class Empresa_ {

	public static volatile SingularAttribute<Empresa, String> ruc;
	public static volatile SingularAttribute<Empresa, String> razonSocial;
	public static volatile CollectionAttribute<Empresa, Camion> camiones;
	public static volatile CollectionAttribute<Empresa, Persona> personas;
	public static volatile SingularAttribute<Empresa, RolEmpresa> rol;

}

