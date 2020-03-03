package mathiasschoepke.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.Getter;
import lombok.Setter;

@Named
@SessionScoped
public class SessionBean implements Serializable {
	private static final long serialVersionUID = 1L;

	EntityManagerFactory emf;
	@Getter
	@Setter
	EntityManager em;

	@Getter
	JPAQueryFactory queryFactory;

	@PostConstruct
	public void init() {
		emf = Persistence.createEntityManagerFactory("peri");
		em = emf.createEntityManager();
		queryFactory = new JPAQueryFactory(em);
	}

	public void persist(Object obj) {
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}
}
