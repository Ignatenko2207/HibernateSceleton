package org.itstep;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.itstep.model.Account;
import org.itstep.model.Good;
import org.itstep.model.GoodAction;
import org.itstep.util.HibernatePropertiesUtil;

/**
 * @author Alex Ignatenko
 */
public class App
{
	public static void main(String[] args)
	{
		Account account = new Account("ignatenko2207", "123456", "Alex", "Ignatenko", new Date(82, 7, 22).getTime());

		Good good = new Good("BAJDHG52HG", "Some name for test good", 12599);

		HibernatePropertiesUtil hUtil = new HibernatePropertiesUtil();

		Session session1 = hUtil.getSessionFactory().openSession();

		session1.getTransaction().begin();

		session1.save(good);

		session1.save(account);

		session1.getTransaction().commit();

		session1.close();

		GoodAction goodAction = new GoodAction(System.currentTimeMillis(), "try to add to cart", Boolean.FALSE, account, good);

		Session session2 = hUtil.getSessionFactory().openSession();

		session2.getTransaction().begin();

		session2.save(goodAction);

		session2.getTransaction().commit();

		session2.close();

		String sql = "SELECT account_login FROM good_actions WHERE time_action> :time";

		Session session3 = hUtil.getSessionFactory().openSession();

		session3.getTransaction().begin();

		Query query = session3.createNativeQuery(sql);

		query.setParameter("time", Long.valueOf(System.currentTimeMillis() - (15 * 60 * 1000)));

		List<String> result = query.getResultList();

		session3.getTransaction().commit();

		session3.close();

		System.out.println(result.size());

		for ( String string : result )
		{
			System.out.println(string);
		}

		System.out.println("Everything is done!");

	}
}
