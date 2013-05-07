import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServerBatch {
	public static void main(String[] args) {
		String webappBase = "E:\\git\\CherryBatch\\src\\main\\webapp";

		Server server = new Server();

		SelectChannelConnector connector0 = new SelectChannelConnector();
		connector0.setPort(8090);
		connector0.setMaxIdleTime(30000);
		connector0.setRequestHeaderSize(8192);

		WebAppContext context = new WebAppContext();
		context.setDescriptor(webappBase+"/WEB-INF/web.xml");
		context.setResourceBase(webappBase);
		context.setContextPath("/CherryBatch");
		//context.setWar("E:/project/jetty-hightide-7.4.1/webapps/Cherry.war");
		//context.setParentLoaderPriority(true);
		server.setHandler(context);
		//server.setStopAtShutdown(true);
		server.setConnectors(new Connector[] { connector0 });

		
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}