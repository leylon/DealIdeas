package com.dealideas.dealtrucker.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Monitoreo.class)
public abstract class Monitoreo_ {

	public static volatile SingularAttribute<Monitoreo, BigDecimal> latitud;
	public static volatile SingularAttribute<Monitoreo, BigDecimal> longitud;
	public static volatile SingularAttribute<Monitoreo, String> phonekey;
	public static volatile SingularAttribute<Monitoreo, Servicio> servicio;
	public static volatile SingularAttribute<Monitoreo, Persona> persona;
	public static volatile SingularAttribute<Monitoreo, Date> fechaHora;
	public static volatile SingularAttribute<Monitoreo, MonitoreoPK> pk;

}

