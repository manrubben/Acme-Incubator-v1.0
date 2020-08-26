
package acme.features.anonymous.gallardoBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.gallardoBulletins.GallardoBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousGallardoBulletinListService implements AbstractListService<Anonymous, GallardoBulletin> {

	// Internal state ----------------------------------------------------------

	@Autowired
	AnonymousGallardoBulletinRepository repository;


	// AbstractListService<Anonymous, Gallardobulletin> interface --------------------

	@Override
	public boolean authorise(final Request<GallardoBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<GallardoBulletin> findMany(final Request<GallardoBulletin> request) {
		assert request != null;

		Collection<GallardoBulletin> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<GallardoBulletin> request, final GallardoBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "songAuthor");
	}

}
