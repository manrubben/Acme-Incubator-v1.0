
package acme.features.anonymous.diazBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.diazBulletins.DiazBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousDiazBulletinRepository extends AbstractRepository {

	@Query("select b from DiazBulletin b")
	Collection<DiazBulletin> findMany();

}
