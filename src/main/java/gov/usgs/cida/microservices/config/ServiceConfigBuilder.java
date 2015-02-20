package gov.usgs.cida.microservices.config;

import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author isuftin
 */
public class ServiceConfigBuilder {
	private static final Logger logger = LoggerFactory.getLogger(ServiceConfigBuilder.class);
	private String name = null; // required
	private int port = 0; //required
	private String id = null; // optional
	private String version = null; //optional
	private String address = null; // Auto-Filled
	private String node = null; // Auto-filled
	
	public ServiceConfig build() {
		ServiceConfig result = new ServiceConfig();
		
		if (StringUtils.isBlank(name)) {
			throw new IllegalStateException("a service name is required");
		}
		result.setName(name);
		
		if (port < 1) {
			throw new IllegalStateException("The service port is required to be a positive integer");
		}
		result.setPort(port);
		
		if (StringUtils.isBlank(id)) {
			result.setId(UUID.randomUUID().toString());
		} else {
			result.setId(id);
		}
		
		if (version == null) {
			version = "";
		}
		result.setVersion(version);
		
		if (StringUtils.isNotBlank(node)) {
			result.setNode(node);
		}
		
		if (StringUtils.isNotBlank(address)) {
			result.setAddress(address);
		}
		else{
			throw new IllegalArgumentException("an address is required");
		}
		
		logger.debug("Created new service configuration: {}", result.toString());
		
		return result;
	}

	/**
	 * @param name the name to set
	 */
	public ServiceConfigBuilder setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * @param id the id to set
	 */
	public ServiceConfigBuilder setId(String id) {
		this.id = id;
		return this;
	}

	/**
	 * @param port the port to set
	 */
	public ServiceConfigBuilder setPort(int port) {
		this.port = port;
		return this;
	}

	/**
	 * @param version the version to set
	 */
	public ServiceConfigBuilder setVersion(String version) {
		this.version = version;
		return this;
	}

	/**
	 * @param address the address to set
	 */
	public ServiceConfigBuilder setAddress(String address) {
		this.address = address;
		return this;
	}

	/**
	 * @param node the node to set
	 */
	public ServiceConfigBuilder setNode(String node) {
		this.node = node;
		return this;
	}
}
