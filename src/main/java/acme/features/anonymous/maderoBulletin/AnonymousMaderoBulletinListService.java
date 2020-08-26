
package acme.features.anonymous.maderoBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.maderoBulletins.MaderoBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousMaderoBulletinListService implements AbstractListService<Anonymous, MaderoBulletin> {

	// Internal state ----------------------------------------------------------

	@Autowired
	AnonymousMaderoBulletinRepository repository;


	// AbstractListService<Anonymous, Shout> interface --------------------

	@Override
	public boolean authorise(final Request<MaderoBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<MaderoBulletin> findMany(final Request<MaderoBulletin> request) {
		assert request != null;

		Collection<MaderoBulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<MaderoBulletin> request, final MaderoBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "photo");
	}

}
