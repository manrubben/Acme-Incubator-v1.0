
package acme.features.anonymous.pavonBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.pavonBulletins.PavonBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/pavon-bulletin/")

public class AnonymousPavonBulletinController extends AbstractController<Anonymous, PavonBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnonymousPavonBulletinListService	listService;

	@Autowired
	private AnonymousPavonBulletinCreateService	createService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
