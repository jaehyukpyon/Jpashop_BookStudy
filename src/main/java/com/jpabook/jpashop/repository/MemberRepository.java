package com.jpabook.jpashop.repository;

import com.jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member) {
        System.out.println("entityManager: " + em);
        em.persist(member);
    }

    public Member findOne(Long id) {
        System.out.println("entityManager: " + em);
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        System.out.println("entityManager: " + em);
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name) {
        System.out.println("entityManager: " + em);
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                    .setParameter("name", name)
                    .getResultList();
    }

}
