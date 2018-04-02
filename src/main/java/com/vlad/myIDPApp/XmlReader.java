package com.vlad.myIDPApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;

public class XmlReader {
	
	private String username = null;
	private String password = null;
	public HashMap<String, String> usersHashMap = new HashMap<String, String>();
	public List<User> users = new ArrayList<>();
	public ArrayList<String> usernames = new ArrayList<>();
	public ArrayList<String> passwords = new ArrayList<>();
	
	public XmlReader(){
		
	}
	
	public boolean readXML() {
        Document dom;
        
        // Make an  instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the    
            // XML file
            dom = db.parse("C:\\Users\\user\\eclipse-workspace\\myIDPApp\\users.xml");
            
            Element doc = dom.getDocumentElement();

            usernames = getUsernames(doc);
            //System.out.println(usernames);
            passwords = getPasswords(doc);
            
            for(int i = 0; i < usernames.size(); i++) {
            	usersHashMap.put(usernames.get(i), passwords.get(i));
            	User user = new User();
            	user.setPassword(passwords.get(i));
            	user.setUsername(usernames.get(i));
            	users.add(user);
            	
            }
            
            return true;

        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        return false;
    }
	
	private String getTextValue(String def, Element doc, String tag) {
	    String value = def;
	    NodeList nl;
	    nl = doc.getElementsByTagName(tag);
	    if (nl.getLength() > 0) {
	        value = nl.item(0).getFirstChild().getNodeValue();
	    }
	    return value;
	}
	
	public ArrayList<String> getUsernames(Element doc) {
		int i;
		ArrayList<String> usernamesList = new ArrayList<String>();
	    String username = "";
	    NodeList nl;
	    nl = doc.getElementsByTagName("username");
	    if (nl.getLength() > 0) {
	    	for(i=0; i<nl.getLength(); i++) {
	    		username = (String) nl.item(i).getFirstChild().getNodeValue();
	    		if (username != null) {
	    			if (!username.isEmpty())
	    				usernamesList.add(username);
	    		}
	    	}
	    }
	    return usernamesList;
	}
	
	private ArrayList<String> getPasswords(Element doc) {
		ArrayList<String> passwordsList = new ArrayList<String>();
	    String password = "";
	    NodeList nl;
	    nl = doc.getElementsByTagName("password");
	    if (nl.getLength() > 0) {
	    	for(int i=0; i<nl.getLength(); i++) {
	    		password = (String) nl.item(i).getFirstChild().getNodeValue();
	    		if (password != null) {
	    			if (!password.isEmpty())
	    				passwordsList.add(password);
	    		}
	    	}
	    }
	    return passwordsList;
	}
	
	
	
	public String getPassword(String username) {
		if (usernames.contains(username))
			return usersHashMap.get(username);
		else return null;
	}
	
	public User getByUsername(String username) {
		for(User user: users) {
			if (user.getUsername() == username)
				return user;
		}
		return null;
	}
}
