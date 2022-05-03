package SegundoPortlet.portlet;

import SegundoPortlet.constants.SegundoPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author DaryaLynnykStorozhuk
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.grupo_sade",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=GrupoSade",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SegundoPortletKeys.SEGUNDO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SegundoPortlet extends MVCPortlet {
}