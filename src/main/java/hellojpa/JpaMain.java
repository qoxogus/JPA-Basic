package hellojpa;

import hellojpa.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Order order = new Order();
//            order.addOrderItem(new OrderItem()); //연관관계 메서드 사용 (양쪽 객체에 값을 다 넣어준다)

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("배태현");

            em.persist(book);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
