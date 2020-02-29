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

@Named
@SessionScoped
public class SessionBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	JPAQueryFactory queryFactory;

	@PostConstruct
	public void init() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("peri");
		EntityManager em = emf.createEntityManager();
		queryFactory = new JPAQueryFactory(em);
	}
}
