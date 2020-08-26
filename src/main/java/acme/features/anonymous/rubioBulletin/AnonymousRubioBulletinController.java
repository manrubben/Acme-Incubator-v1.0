
package acme.features.anonymous.rubioBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.rubioBulletins.RubioBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/rubio-bulletin/")
public class AnonymousRubioBulletinController extends AbstractController<Anonymous, RubioBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnonymousRubioBulletinListService	listService;

	@Autowired
	private AnonymousRubioBulletinCreateService	createService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
