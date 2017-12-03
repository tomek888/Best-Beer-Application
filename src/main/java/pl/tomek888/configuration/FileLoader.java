package pl.tomek888.configuration;


import java.io.File;
import java.io.IOException;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class FileLoader implements ResourceLoaderAware
{
	private ResourceLoader resourceLoader;

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public File get(String location) throws IOException{
		return resourceLoader.getResource("classpath:" + location).getFile();
	}
}
