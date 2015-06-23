package Persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;






public class DAO {
	
	private static DAO instance;
	private Session sessao;
	private Transaction tx;
	
	public DAO(){
		
	}
	
	public static DAO getInstance(){
		if(instance == null)
			instance = new DAO();
		return instance;
	}
	
	public <T> Object buscarPorId(Class<T> clazz, Integer id){
		try{
			sessao = HibernateUtil.getSession().openSession();
			Object object = sessao.get(clazz, id);
			return object;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	public <T> Object buscarPorNome(Class<T> clazz, String nome){
		try{
			sessao = HibernateUtil.getSession().openSession();
			Object object = sessao.get(clazz, nome);
			return object;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public <T> Object buscarPorChaveUnica(Class<T> clazz, Long codigo, String coluna){
		try{
			sessao = HibernateUtil.getSession().openSession();
			Object object = sessao.createCriteria(clazz).add(Restrictions.eq(coluna, codigo)).uniqueResult();
			return object;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	
	
	public <T> boolean salvarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession().openSession();
			tx = sessao.beginTransaction();
			sessao.save(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}
	
	public <T> boolean salvarOuAtualizarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession().openSession();
			tx = sessao.beginTransaction();
			sessao.saveOrUpdate(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}

	
	
	public <T> boolean deletarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession().openSession();
			tx = sessao.beginTransaction();
			sessao.delete(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}
	
	public List<?> listarObjetos(Class<?> classe, String ordanacao){
		try{
			sessao = HibernateUtil.getSession().openSession();
			Criteria criteria = sessao.createCriteria(classe).addOrder(Order.asc(ordanacao));
			
			
			
			return  criteria.list();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("erro : "+e);
			return null;
		}finally{
			sessao.close();
		}
	}
		
	
	
	
}
