package hellojpa.jpabasic.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaBasicMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            //영속
//            System.out.println("==Before==");
//            em.persist(member);
//            System.out.println("==After==");

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

//            Member findMember = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L); //똑같은걸 두번째 찾을 때는 select쿼리문이 한번 나간다 (첫번째 찾을때는 1차캐시에서 2번째부터는 데이터베이스에서 조회한다) 가져와서 1차캐시에 저장해놓는다(영속성컨텍스트에 올림) -> 그리고 1차캐시에서 가져온다
//            //insert쿼리문이 나가기 전에 조회됨 1차캐시에서 조회하기 때문에
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
//
//            System.out.println("findMember == findMember2 = " + (findMember == findMember2)); //동일성비교 true

//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//            em.persist(member1);
//            em.persist(member2); //여기까진 insert 쿼리문을 보내지 않음
//            //쓰기지연 SQL저장소에 쿼리문들을 저장해 놓았다가 커밋시점에 쿼리문을 한번에 보낸다

//            Member member = em.find(Member.class, 150L);
//            member.setName("BTH");  //변경감지 -> 트랜잭션 커밋시점에 변경사항 반영

//            Member member = new Member(200L, "member200");
//            em.persist(member);
//
//            em.flush(); //이 시점에 insert 쿼리문이 나가게된다
//            //플러쉬는 쓰기지연SQL저장소에 쌓인 쿼리들을 데이터베이스에 반영하는 과정이다 (변경감지등 포함) 보통 커밋이나 쿼리(JPQL)를 실행하는시점에 자동으로 호출됨(기본값) (이것도 설정으로 변경가능하다)

//            Member member = em.find(Member.class, 150L);
//            member.setName("AAA");

//            em.detach(member); //JPA에서 관리를 안하게됨(준영속상태) <- 커밋시점에 아무일도 일어나지 않을 것
//
//            em.clear(); //영속성 컨텍스트를 통으로 다 지움(초기화)
//
//            Member member2 = em.find(Member.class, 150L); //영속성 컨텍스트를 초기화했기때문에 DB에서 조회해와서 1차캐시에 다시 올려놓기위해 select쿼리문이 나간다

//            em.close(); //영속성 컨텍스트 종료



            tx.commit(); //트랜젝션 커밋시점에 쿼리가 나가게 된다
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}

