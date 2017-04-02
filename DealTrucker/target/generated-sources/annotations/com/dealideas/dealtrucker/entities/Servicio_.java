package com.dealideas.dealtrucker.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Servicio.class)
public abstract class Servicio_ {

	public static volatile SingularAttribute<Servicio, Camion> camion;
	public static volatile SingularAttribute<Servicio, Date> fechaCita;
	public static volatile SingularAttribute<Servicio, EstadoServicio> estado;
	public static volatile SingularAttribute<Servicio, TipoServicio> tipo;
	public static volatile SingularAttribute<Servicio, String> nroContenedor;
	public static volatile SingularAttribute<Servicio, Ubigeo> origen;
	public static volatile CollectionAttribute<Servicio, Monitoreo> monitoreos;
	public static volatile SingularAttribute<Servicio, String> direccionDestino;
	public static volatile SingularAttribute<Servicio, Chofer> chofer;
	public static volatile SingularAttribute<Servicio, Date> fechaInicio;
	public static volatile SingularAttribute<Servicio, Long> idServicio;
	public static volatile SingularAttribute<Servicio, Ubigeo> destino;
	public static volatile SingularAttribute<Servicio, Camion> tracto;

}

