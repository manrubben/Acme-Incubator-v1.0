
package acme.features.anonymous.sanabriaBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.sanabriaBulletins.SanabriaBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousSanabriaBulletinListService implements AbstractListService<Anonymous, SanabriaBulletin> {

	// Internal state ----------------------------------------------------------

	@Autowired
	AnonymousSanabriaBulletinRepository repository;


	// AbstractListService<Anonymous, Shout> interface --------------------

	@Override
	public boolean authorise(final Request<SanabriaBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<SanabriaBulletin> findMany(final Request<SanabriaBulletin> request) {
		assert request != null;

		Collection<SanabriaBulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<SanabriaBulletin> request, final SanabriaBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "song");
	}

}
