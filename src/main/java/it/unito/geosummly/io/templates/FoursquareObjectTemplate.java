package it.unito.geosummly.io.templates;

import java.util.Arrays;
import java.util.logging.Logger;

import fi.foyt.foursquare.api.entities.Category;

/**
 * Template of the object returned by 4square on the sampling state
 */

public class FoursquareObjectTemplate {
	
	private int row;
	private int column;
	private String venueId;
	private String venueName;
	private Double latitude;
	private Double longitude;
	private Category[] categories;
	private String email;
	private String phone;
	private String facebook;
	private String twitter;
	private boolean verified;
	private Integer checkinsCount;
	private Integer usersCount;
	private String url;
	private Long hereNow;
	private Long timestamp;
	
	public static Logger logger = Logger.getLogger(FoursquareObjectTemplate.class.toString());
	
	public FoursquareObjectTemplate() {}
	
	/**constructor without row and column informations*/
	public FoursquareObjectTemplate(String vId, String vName, double lat, double lng, Category[] cat, String email, 
			String phone, String fb, String tw, boolean ver, int chkCount, int usrCount, String url, long hn, long timestamp) {
		this.venueId=vId;
		this.venueName=vName;
		this.latitude=lat;
		this.longitude=lng;
		this.categories=cat;
		this.email=email;
		this.phone=phone;
		this.facebook=fb;
		this.twitter=tw;
		this.verified=ver;
		this.checkinsCount=chkCount;
		this.usersCount=usrCount;
		this.url=url;
		this.hereNow=hn;
		this.timestamp=timestamp;
	}
	
	/**Constructor with row and column informations*/
	public FoursquareObjectTemplate(int row, int col, String vId, String vName, double lat, double lng, Category[] cat, String email, 
			String phone, String fb, String tw, boolean ver, int chkCount, int usrCount, String url, long hn, long timestamp) {
		this.row=row; 
		this.column=col;
		this.venueId=vId;
		this.venueName=vName;
		this.latitude=lat;
		this.longitude=lng;
		this.categories=cat;
		this.email=email;
		this.phone=phone;
		this.facebook=fb;
		this.twitter=tw;
		this.verified=ver;
		this.checkinsCount=chkCount;
		this.usersCount=usrCount;
		this.url=url;
		this.hereNow=hn;
		this.timestamp=timestamp;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public String getVenueId() {
		return venueId;
	}

	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Category[] getCategories() {
		return categories;
	}

	public void setCategories(Category[] categories) {
		this.categories = categories;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public Integer getCheckinsCount() {
		return checkinsCount;
	}

	public void setCheckinsCount(Integer checkinsCount) {
		this.checkinsCount = checkinsCount;
	}

	public Integer getUsersCount() {
		return usersCount;
	}

	public void setUsersCount(Integer usersCount) {
		this.usersCount = usersCount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getHereNow() {
		return hereNow;
	}

	public void setHereNow(Long hereNow) {
		this.hereNow = hereNow;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "FoursquareObjectTemplate [row=" + row + ", column=" + column
				+ ", venueId=" + venueId + ", venueName=" + venueName
				+ ", latitude=" + latitude + ", longitude=" + longitude
				+ ", categories=" + Arrays.toString(categories) + ", email="
				+ email + ", phone=" + phone + ", facebook=" + facebook
				+ ", twitter=" + twitter + ", verified=" + verified
				+ ", checkinsCount=" + checkinsCount + ", usersCount="
				+ usersCount + ", url=" + url + ", hereNow=" + hereNow +", timestamp= "+ timestamp+ "]";
	}
}
