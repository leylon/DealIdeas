package com.dealideas.dealtrucker.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Provincia.class)
public abstract class Provincia_ {

	public static volatile SingularAttribute<Provincia, String> descripcion;
	public static volatile SingularAttribute<Provincia, String> codigo;
	public static volatile CollectionAttribute<Provincia, Ubigeo> ubigeos;
	public static volatile SingularAttribute<Provincia, Departamento> departamento;

}

