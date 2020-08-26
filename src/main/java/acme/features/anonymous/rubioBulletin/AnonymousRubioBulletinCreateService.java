
package acme.features.anonymous.rubioBulletin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.rubioBulletins.RubioBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousRubioBulletinCreateService implements AbstractCreateService<Anonymous, RubioBulletin> {

	// Internal state ----------------------------------------------------------

	@Autowired
	AnonymousRubioBulletinRepository repository;


	@Override
	public boolean authorise(final Request<RubioBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public RubioBulletin instantiate(final Request<RubioBulletin> request) {
		assert request != null;

		RubioBulletin result;

		result = new RubioBulletin();
		result.setAuthor("");
		result.setLink("");

		return result;
	}

	@Override
	public void unbind(final Request<RubioBulletin> request, final RubioBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "link");
	}

	@Override
	public void bind(final Request<RubioBulletin> request, final RubioBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<RubioBulletin> request, final RubioBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<RubioBulletin> request, final RubioBulletin entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
