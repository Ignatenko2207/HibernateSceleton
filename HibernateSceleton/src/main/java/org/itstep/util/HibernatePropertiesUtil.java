package org.itstep.util;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernatePropertiesUtil {

	private final SessionFactory sessionFactory;

	public HibernatePropertiesUtil() {
		this.sessionFactory = configureSessionFactory();
	}

	/**
	 * Create SessionFactory
	 * 
	 * @return {@link SessionFactory}
	 * @throws HibernateException
	 */
	private SessionFactory configureSessionFactory() throws HibernateException {

		String userDir = System.getProperty("user.dir");

		Configuration configuration = new Configuration();
		Properties properties = new Properties();

		properties.setProperty("connection.driver_class", "org.postgresql.Driver");
		properties.setProperty("connection.url", "jdbc:postgresql://localhost:5432/hiber_sceleton");
		properties.setProperty("connection.user", "postgres");
		properties.setProperty("connection.password", "248842");
		properties.setProperty("connection.pool_size", "1");

		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "create");

		configuration.setProperties(properties);
		configuration.setProperty("packagesToScan", "org.itstep.model");

		return configuration.configure().buildSessionFactory();

	}

	/**
	 * Get SessionFactory
	 * 
	 * @return {@link SessionFactory}
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
