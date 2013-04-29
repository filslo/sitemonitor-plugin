package hudson.plugins.sitemonitor.model;

/**
 * This class keeps the details of a site monitoring result.
 * @author cliffano
 */
public class Result {

    /**
     * The monitored site.
     */
    private Site mSite;

    /**
     * The response code returned from the site.
     */
    private Integer mResponseCode;

    /**
     * Status of the monitored site. It can't be derived from the response code
     * because the success response code global config can differ between each
     * build.
     */
    private Status mStatus;

    /**
     * Additional textual information for the site monitoring result, e.g.
     * exception message when the site monitoring gives an unexpected exception.
     */
    private String mNote;
    
    /**
     * real url monitored, especially for site url using job variables
     */
    private String mMonitoredURL;

    /**
     * Constructs a {@link Result}.
     * @param site the monitored site
     * @param responseCode the response code returned from the site
     * @param status status of the monitored site
     * @param note additional textual information of the result
     * @param mMonitoredURL actual monitored URL
     */
    public Result(final Site site, final Integer responseCode,
            final Status status, final String note, String monitoredURL) {
        this.mSite = site;
        this.mResponseCode = responseCode;
        this.mStatus = status;
        this.mNote = note;
        this.mMonitoredURL = monitoredURL;
    }
    
    /**
     * Constructs a {@link Result}.
     * @param site the monitored site
     * @param responseCode the response code returned from the site
     * @param status status of the monitored site
     * @param note additional textual information of the result
     */
    public Result(final Site site, final Integer responseCode,
            final Status status, final String note) {
        this.mSite = site;
        this.mResponseCode = responseCode;
        this.mStatus = status;
        this.mNote = note;
        
        if( this.mSite != null ) {
        	this.mMonitoredURL = this.mSite.getUrl();
        }
    }

    /**
     * @return the monitored site
     */
    public final Site getSite() {
        return this.mSite;
    }

    /**
     * @return the response code
     */
    public final Integer getResponseCode() {
        return this.mResponseCode;
    }

    /**
     * @return the status of the monitored site
     */
    public final Status getStatus() {
        return this.mStatus;
    }

    /**
     * @return the note
     */
    public final String getNote() {
        return this.mNote;
    }

	/**
	 * @return the monitoredURL
	 */
	public String getMonitoredURL() {
		return this.mMonitoredURL;
	}
}
