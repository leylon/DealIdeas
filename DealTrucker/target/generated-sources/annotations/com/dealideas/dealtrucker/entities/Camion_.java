package com.dealideas.dealtrucker.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Camion.class)
public abstract class Camion_ {

	public static volatile SingularAttribute<Camion, String> descripcion;
	public static volatile CollectionAttribute<Camion, Servicio> serviciosTracto;
	public static volatile CollectionAttribute<Camion, Servicio> serviciosCamion;
	public static volatile SingularAttribute<Camion, Empresa> empresa;
	public static volatile SingularAttribute<Camion, String> placa;

}

