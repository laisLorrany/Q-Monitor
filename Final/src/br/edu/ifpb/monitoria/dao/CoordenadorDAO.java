package br.edu.ifpb.monitoria.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifpb.monitoria.entidade.Coordenador;
import br.edu.ifpb.monitoria.entidade.Monitor;
import br.edu.ifpb.monitoria.hibernate.HibernateUtil;

public class CoordenadorDAO extends GenericDao<Integer, Coordenador> {

	private static Logger logger = LogManager.getLogger(MonitorDAO.class);

	static MonitorDAO instance;

	public static MonitorDAO getInstance() {

		instance = new MonitorDAO();
		return instance;
	}

	@Override
	public List<Coordenador> getAll() throws HibernateException {
		// TODO Auto-generated method stub
		return getAll("Monitor.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return Coordenador.class;
	}

	@Override
	public Coordenador find(Coordenador entity) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Coordenador getByLogin(Coordenador coordenador) throws HibernateException {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Coordenador coordenadorResult = null;

		try {

			String hql = "from Coordenador as c" + " where c.login = :login and c.senha = :senha";

			Query query = session.createQuery(hql);
			query.setParameter("login", coordenador.getLogin());
			query.setParameter("senha", coordenador.getSenha());

			coordenadorResult = (Coordenador) query.uniqueResult();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new HibernateException(hibernateException);

		} finally {

			session.close();
		}
		
		return coordenadorResult;
	}

	public List<Monitor> getByName(String disciplina) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Monitor> monitores = null;

		try {

			session.beginTransaction();
			Query query = session.createQuery("from Coordenador c where c.disciplina like :disciplina");
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
