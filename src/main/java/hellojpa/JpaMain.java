package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            //영속
            System.out.println("==Before==");
            em.persist(member);
            System.out.println("==After==");

            //insert
//            em.persist(member);

            //select
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getId() = " + findMember.getName());

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)  //FirstrResult 부터 MaxResult까지 가져와라
//                    .setMaxResults(10)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            //update
//            findMember.setName("HelloJPA"); //set 해준 뒤 findMember를 저장하지않아도 된다 (JPA가 관리중 변경사항이 있는지 트렌젝션 커밋시점에 체크를 함 (변경감지) 변경감지 -> update쿼리 )

            //delete
//            em.remove(findMember);



            //회원 엔티티를 영속성 컨텍스트에서 분리, 준영속상태
//            em.detach(member);

            //객체를 삭제한 상태(삭제)
//            em.remove(member);

            tx.commit(); //트랜젝션 커밋시점에 쿼리가 나가게 된다
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}

