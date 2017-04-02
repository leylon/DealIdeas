package com.dealideas.dealtrucker.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RolEmpresa.class)
public abstract class RolEmpresa_ {

	public static volatile SingularAttribute<RolEmpresa, Integer> idrol;
	public static volatile CollectionAttribute<RolEmpresa, Empresa> empresas;
	public static volatile SingularAttribute<RolEmpresa, String> nombre;

}

