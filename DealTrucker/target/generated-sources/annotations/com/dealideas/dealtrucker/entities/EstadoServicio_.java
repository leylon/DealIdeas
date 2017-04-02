package com.dealideas.dealtrucker.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EstadoServicio.class)
public abstract class EstadoServicio_ {

	public static volatile CollectionAttribute<EstadoServicio, Servicio> servicios;
	public static volatile SingularAttribute<EstadoServicio, Integer> idEstado;
	public static volatile SingularAttribute<EstadoServicio, String> nombre;

}

