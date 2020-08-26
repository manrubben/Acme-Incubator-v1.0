
package acme.features.anonymous.sanabriaBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.sanabriaBulletins.SanabriaBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/sanabria-bulletin/")

public class AnonymousSanabriaBulletinController extends AbstractController<Anonymous, SanabriaBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnonymousSanabriaBulletinListService	listService;

	@Autowired
	private AnonymousSanabriaBulletinCreateService	createService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
