
package acme.features.anonymous.sanabriaBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.sanabriaBulletins.SanabriaBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousSanabriaBulletinRepository extends AbstractRepository {

	@Query("select s from SanabriaBulletin s")
	Collection<SanabriaBulletin> findMany();

}
