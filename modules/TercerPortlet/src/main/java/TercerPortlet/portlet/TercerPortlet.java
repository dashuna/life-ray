package TercerPortlet.portlet;

import TercerPortlet.constants.TercerPortletKeys;
import portlet.service.model.Factura;
import portlet.service.service.FacturaLocalServiceUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.io.OutputStreamWriter;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.CSVUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

/**
 * @author DaryaLynnykStorozhuk
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Tercer",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TercerPortletKeys.TERCER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class TercerPortlet extends MVCPortlet {
	
//	static private Vector<Hashtable<String, String>> facturas = new Vector<Hashtable<String, String>>();
//	esto solo nos sirve cuando no tenemos una base de datos
	
	//este metodo va gestionar todas las peticiones de tipo recurso
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		//necesitamos importar una dependencia que no liferay no tiene por defecto -> se ve en build.gradle
		resourceResponse.setContentType("application/csv"); //para que el navegador abra el fichero cuando lo descargue (si tiene con que hacerlo)
		resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=lista.csv");
		
		OutputStreamWriter osw = new OutputStreamWriter(resourceResponse.getPortletOutputStream());
		CSVPrinter printer = new CSVPrinter(
				osw,
				CSVFormat.DEFAULT.withHeader("numero", "cliente", "importe")
				);
		
		//vamos a crear un metodo que hemos implementado en portlet.service.impl
		FacturaLocalServiceUtil.getFacturasByTerm();
		
		//lo vamos a guardar todo en la base de datos
		List<Factura> facturas=FacturaLocalServiceUtil.getFacturas(-1, -1);
				//-1, -1 -> es para hacer paginación
		
		for (Factura f: facturas) { // for (Hashtable<String, String> f: facturas) {
			printer.printRecord( 		// printer.printRecord(
					f.getNumero(), 			// f.get("numero"),
					f.getCliente(),			// f.get("cliente"),
					f.getImporte() 			// f.get("importe")
					); 						// );
		} 							// }
		printer.flush();
		printer.close();
	}
	
	
//	va a procesar la accion
//	se va a ejecutar cuando le de a Enviar del formulario
		public void altaFactura(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
			//procesar el alta de formulario
			String numero=ParamUtil.getString(actionRequest, "numero", "");
			String cliente=ParamUtil.getString(actionRequest, "cliente", "");
			String importe=ParamUtil.getString(actionRequest, "importe", "");
			
			//generar el registro
			Factura reg = FacturaLocalServiceUtil.createFactura( 	
					CounterLocalServiceUtil.increment(Factura.class.getName())
					);					//Hashtable<String, String> reg = new Hashtable<String, String>();
			reg.setNumero(numero); 			// reg.put("numero", numero);
			reg.setCliente(cliente); 		// reg.put("cliente", cliente);
			reg.setImporte(importe); 		//	reg.put("importe", importe);
			
			FacturaLocalServiceUtil.addFactura(reg); 	//facturas.add(reg);
		}
	
//	hace el renderizado
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String jspPage=ParamUtil.getString(renderRequest, "jspPage", "");
		
		if (jspPage.equals("/cercania.jsp")) {
			List<Factura> facturas = FacturaLocalServiceUtil.getFacturas(-1, -1);
//			Vector<Hashtable<String, String>> facturas = new Vector<Hashtable<String, String>>();
			
//			Hashtable<String, String> r1 = new Hashtable<String, String>();
//			r1.put("numero", "2022/01");
//			r1.put("cliente", "IBM");
//			r1.put("importe", "18.000");
//			facturas.add(r1);
//			
//			r1.put("numero", "2022/02");
//			r1.put("cliente", "Google");
//			r1.put("importe", "28.000");
//			facturas.add(r1);
//			
//			r1.put("numero", "2022/03");
//			r1.put("cliente", "Netflix");
//			r1.put("importe", "12.000");
//			facturas.add(r1);
			
			renderRequest.setAttribute("facturas", facturas);
		}
		
		super.render(renderRequest, renderResponse);
	}
}