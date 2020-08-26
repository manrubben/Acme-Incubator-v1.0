
package acme.features.anonymous.maderoBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.maderoBulletins.MaderoBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousMaderoBulletinRepository extends AbstractRepository {

	@Query("select s from MaderoBulletin s")
	Collection<MaderoBulletin> findMany();

}
