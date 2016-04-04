package br.edu.ifpb.Monitoria.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.edu.ifpb.Monitoria.entidade.Monitor;
import br.edu.ifpb.Monitoria.hibernate.HibernateUtil;

public class MonitorDAO extends GenericDao<Integer, Monitor> {

	private static Logger logger = LogManager.getLogger(MonitorDAO.class);

	static MonitorDAO instance;

	public static MonitorDAO getInstance() {

		instance = new MonitorDAO();
		return instance;
	}

	@Override
	public List<Monitor> getAll() throws HibernateException {
		// TODO Auto-generated method stub
		return getAll("Monitor.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return Monitor.class;
	}

	@Override
	public Monitor find(Monitor entity) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Monitor getByKeyAuth(String keyAuth) throws HibernateException {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Monitor monitor = null;

		try {

			String hql = "from Monitor as m" + " where m.keyAuth = :keyAuth";

			Query query = session.createQuery(hql);
			query.setParameter("keyAuth", keyAuth);

			monitor = (Monitor) query.uniqueResult();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new HibernateException(hibernateException);

		} finally {

			session.close();
		}

		return monitor;
	}

	public List<Monitor> getByName(String disciplina) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Monitor> monitores = null;

		try {

			session.beginTransaction();
			Query query = session.createQuery("from Monitor m where m.disciplina like :disciplina");
			query.setParameter("disciplina", "%" + disciplina + "%");

			monitores = query.list();
			session.getTransaction().commit();

		} catch (HibernateException e) {

			logger.error(e.getMessage());
			session.getTransaction().rollback();

		} finally {

			session.close();
		}

		return monitores;
	}
}
