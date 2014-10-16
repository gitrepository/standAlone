package com.oxm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

public class Application {
    private static final String FILE_NAME = "settings.xml";
    private Settings settings = new Settings();

    private static final String GROUP = "group.xml";
    private Group group = new Group();
    
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }
    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public void saveSettings() throws IOException {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(FILE_NAME);
            this.marshaller.marshal(settings, new StreamResult(os));
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }

    public void loadSettings() throws IOException {
        FileInputStream is = null;
        try {
            is = new FileInputStream(FILE_NAME);
            Settings s = (Settings) this.unmarshaller.unmarshal(new StreamSource(is));
            System.out.println();
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public void loadSettings(String fileName) throws IOException {
        FileInputStream is = null;
        try {
            is = new FileInputStream(fileName);
            Settings s = (Settings) this.unmarshaller.unmarshal(new StreamSource(is));
            System.out.println();
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public void saveGroup() throws IOException {
    	List<Person> l = new ArrayList<Person>();
    	l.add(new Person("1", "1"));
    	l.add(new Person("2", "2"));
    	
    	group.setPersonList(l);
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(GROUP);
            this.marshaller.marshal(group, new StreamResult(os));
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }

    public void loadGroup() throws IOException {
        FileInputStream is = null;
        try {
            is = new FileInputStream(GROUP);
            this.group = (Group) this.unmarshaller.unmarshal(new StreamSource(is));
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext appContext = new FileSystemXmlApplicationContext("C:/projects/source/springApp/standAlone/applicationContext.xml");
        Application application = (Application) appContext.getBean("application");
        application.saveSettings();
        application.loadSettings();

        application.saveGroup();
        //application.loadGroup();
        
        application.loadSettings("echoRequest.xml");
    }
}