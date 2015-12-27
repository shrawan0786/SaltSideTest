package com.test.saltside;

import java.io.Serializable;

public class ItemData implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
    private String description;
    private String imageURL;
    
    // Constructor for the ItemData class
    public ItemData(String title, String description, String imageURL) {
            super();
            this.title = title;
            this.description = description;
            this.imageURL = imageURL;
    }
    
    // Getter and setter methods for all the fields.
    // Though you would not be using the setters for this example,
    // it might be useful later.
    public String getTitle() {
            return title;
    }
    public void setTitle(String title) {
            this.title = title;
    }
    public String getDescription() {
            return description;
    }
    public void setDescription(String description) {
            this.description = description;
    }
    public String getImageURL() {
            return imageURL;
    }
    public void setImageURL(String imageURL) {
            this.imageURL = imageURL;
    }
}
