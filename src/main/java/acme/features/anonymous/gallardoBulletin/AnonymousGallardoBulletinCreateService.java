
package acme.features.anonymous.gallardoBulletin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.gallardoBulletins.GallardoBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousGallardoBulletinCreateService implements AbstractCreateService<Anonymous, GallardoBulletin> {

	// Internal state ----------------------------------------------------------

	@Autowired
	AnonymousGallardoBulletinRepository repository;


	@Override
	public boolean authorise(final Request<GallardoBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public GallardoBulletin instantiate(final Request<GallardoBulletin> request) {
		assert request != null;

		GallardoBulletin result;

		result = new GallardoBulletin();
		result.setAuthor("");
		result.setSongAuthor("");

		return result;
	}

	@Override
	public void unbind(final Request<GallardoBulletin> request, final GallardoBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "songAuthor");
	}

	@Override
	public void bind(final Request<GallardoBulletin> request, final GallardoBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<GallardoBulletin> request, final GallardoBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<GallardoBulletin> request, final GallardoBulletin entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
