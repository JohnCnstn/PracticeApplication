//package classes.data.dao;
//
//import java.io.Serializable;
//
//import java.lang.reflect.ParameterizedType;
//
//import lombok.Setter;
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//public abstract class AbstractDao<PK extends Serializable, T> {
//
//    private final Class<T> persistentClass;
//
//    @SuppressWarnings("unchecked")
//    public AbstractDao(){
//        setSessionFactory();
//        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
//    }
//
//    SessionFactory sessionFactory;
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = (Session) entityManager.getDelegate();
//    }
//
//    protected Session getSession(){
//        return sessionFactory.getCurrentSession();
//    }
//
//    @SuppressWarnings("unchecked")
//    public T getByKey(PK key) {
//        return (T) getSession().get(persistentClass, key);
//    }
//
//    public void persist(T entity) {
//        getSession().persist(entity);
//    }
//
//    public void update(T entity) {
//        getSession().update(entity);
//    }
//
//    public void delete(T entity) {
//        getSession().delete(entity);
//    }
//
//    protected Criteria createEntityCriteria(){
//        return getSession().createCriteria(persistentClass);
//    }
//
//}