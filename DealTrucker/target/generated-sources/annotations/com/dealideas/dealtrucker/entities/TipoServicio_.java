package com.dealideas.dealtrucker.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TipoServicio.class)
public abstract class TipoServicio_ {

	public static volatile CollectionAttribute<TipoServicio, Servicio> servicios;
	public static volatile SingularAttribute<TipoServicio, Integer> idTipo;
	public static volatile SingularAttribute<TipoServicio, String> nombre;

}

