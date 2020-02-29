package mathiasschoepke.bean;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Named
// @RequestScoped
@ViewScoped
public class EmployeeBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String urlId;

	@PostConstruct
	public void init() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		urlId = params.get("id");
		System.out.println("id: " + urlId);
	}

	public void printUrlId() {
		System.out.println("id: " + urlId);
	}
}
