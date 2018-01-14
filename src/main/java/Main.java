import model_lesson10.Product;
import model_lesson10.ProductCategory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by alex on 07.01.2018.
 */
public class Main {
    /*
     SQL запрос: select * from product p inner join product_category pc on p.product_category_id = pc.id
     сопоставимый
     HQL запрос: from Product as p INNER JOIN p.productCategory as pc
     */

    public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session  session = sessionFactory.openSession();
//		List<Object []> productsLesson12 = null;
        List<Product> productsLesson13 = null;
        List<Product> productsLesson14 = null;
    	try {
//            productsLesson12 = sqlRequestLesson12(session);
//            productsLesson13 = getHqlProductsLesson13(session);
            productsLesson14 = getCriteraiProductsLesson14(session);
    	}  finally {
    	    session.close();
			sessionFactory.close();
		}

//		for (Object [] obj : productsLesson12){
//            System.out.println(obj[0].toString());
//            for (int i = 0; i < obj[0].toString().length(); i++) System.out.print("-");
//            System.out.println();
//        }

//        for (Product product : productsLesson13){
//            System.out.println(product);
//            for (int i = 0; i < product.toString().length(); i++) System.out.print("-");
//            System.out.println();
//        }

        for (Product product : productsLesson14){
            System.out.println(product);
            for (int i = 0; i < product.toString().length(); i++) System.out.print("-");
            System.out.println();
        }

		System.out.println("Hello");
    }

    public static List<Object []> sqlRequestLesson12(Session session){
        List<Object []> result = null;
        try {
            session.beginTransaction();
//            NativeQuery updateQuery = session.createSQLQuery("insert into product (description, price, title, product_category_id) values(?, ?, ?, ?)");
//            updateQuery.setParameter(0, "Айпонт");
//            updateQuery.setParameter(1, 2000.00);
//            updateQuery.setParameter(2, "Товар гогда");
//            updateQuery.setParameter(3, 1);
//            updateQuery.executeUpdate();
            NativeQuery query = session.createSQLQuery("select {p.*}, {pc.*} from product p " +
                    "inner join product_category pc on p.product_category_id = pc.id");
            query.addEntity("p", Product.class);
            query.addJoin("pc", "p.productCategory");
            result = query.list();
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return result;
    }

    public static  List<Product> getHqlProductsLesson13(Session session){
        List<Product> result = null;
        try {
            session.beginTransaction();
//            Query query = session.createQuery("from Product");
//            FETCH указывает что productCategory внутренний объект
            Query query = session.createQuery("from Product as p INNER JOIN FETCH p.productCategory as pc");
            result = query.list();
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return result;
    }

    public static List<Product> getCriteraiProductsLesson14(Session session){
        List<Product> result = null;
        try {
            Long id[] = {1L,2L,3L};
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Product.class, "product");
            criteria.createCriteria("product.productCategory", "productCategory");
            criteria.add(Restrictions.eq("product.title", "Товар гогда"));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            //select * from product where id not in (1,2,3)
            //criteria.add(Restrictions.not(Restrictions.in("id",id)));
            //select * from product where id in (1,2,3)
            //criteria.add(Restrictions.in("id",id));
            //select * from product where title = 'Товар гогда'
            //criteria.add(Restrictions.eq("title","Товар гогда"));
            result = criteria.list();
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return result;
    }
}
