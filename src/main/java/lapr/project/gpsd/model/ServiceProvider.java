package lapr.project.gpsd.model;

import java.util.Objects;
import lapr.project.records.AvailabilityList;
import java.util.ArrayList;
import java.util.List;
import lapr.project.records.RateList;

public class ServiceProvider {

    /**
     * Service Provider's Full Name
     */
    private String fullName;

    /**
     * Service Provider's Abreviated Name
     */
    private String abrevName;

    /**
     * Service Provider's TIN Number
     */
    private int tinNumber;

    /**
     * Service Provider's Phone Number
     */
    private int phoneNumber;

    /**
     * Service Provider's Mechanographic Number
     */
    private int mechaNumber;

    /**
     * Service Provider's Password
     */
    private String pwd;

    /**
     * Service Provider's Email
     */
    private String email;

    /**
     * Service Provider's availability list
     */
    private AvailabilityList availabiityList;

    /**
     * Service Provider's List of Geographical Areas where he operates
     */
    private GeographicalArea spGeographicalArea;

    /**
     * Service Provider's List of Categories where he operates
     */
    private List<Category> spCategoryList;
    /**
     * Rate List with the ratings given to the service provider
     */
    private RateList rateList;
    /**
     * Evaluation of the service provider
     */
    private Evaluation evaluation;

    /**
     * Postal address of the service provider
     */
    private PostalAddress pAddress;

    public ServiceProvider() {

    }

    /**
     * Full Constructor and creates the necessary lists
     *
     * @param fullName full name of the service provider
     * @param abrevName abreviated name of the service provider
     * @param tinNumber tin number of the service provider
     * @param phoneNumber phone number of the service provider
     * @param email email of the service provider
     */
    public ServiceProvider(String fullName, String abrevName, int tinNumber, int phoneNumber, String email) {
        this.fullName = fullName;
        this.abrevName = abrevName;
        this.tinNumber = tinNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.availabiityList = new AvailabilityList();
        this.rateList = new RateList();
        rateList.registerRate(new Rate(Constants.INITIAL_RATE));
        spCategoryList = new ArrayList<>();
        evaluation = new Evaluation("Regular", 3);
    }

    /**
     * returns the full name of the service provider
     *
     * @return full name of service provider
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * returns the abreviated name of the service provide
     *
     * @return abreviated name of the service provider
     */
    public String getAbrevName() {
        return abrevName;
    }

    /**
     * returns the tin number of the service provider
     *
     * @return tin number of the service provider
     */
    public int getTinNumber() {
        return tinNumber;
    }

    /**
     * returns the phone number of the service provider
     *
     * @return of the service provider
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * returns the mechanical number of the service provider
     *
     * @return mechanical number of the service provider
     */
    public int getMechaNumber() {
        return mechaNumber;
    }

    /**
     * returns the email of the service provider
     *
     * @return email of service provider
     */
    public String getEmail() {
        return email;
    }

    /**
     * returns the password of the service provider
     *
     * @return password of the service provider
     */
    public String getPWD() {
        return pwd;
    }

    /**
     * returns the geographical area of the service provider
     *
     * @return geo arera
     */
    public GeographicalArea getGeoArea() {
        return this.spGeographicalArea;
    }

    /**
     * returns the postal address of the service provider
     *
     * @return postal address
     */
    public PostalAddress getPostalAddress() {
        return this.pAddress;
    }

    /**
     * Returns the avaialbility list of a service provider
     *
     * @return availability list
     */
    public AvailabilityList getAvailabilityList() {
        return this.availabiityList;
    }

    /**
     * Return the service provider rate list
     *
     * @return rate list
     */
    public RateList getRateList() {
        return this.rateList;
    }

    /**
     * returns the service providers evaluation
     *
     * @return
     */
    public Evaluation getEvaluation() {
        return this.evaluation;
    }

    /**
     * sets the full name of the service provider
     *
     * @param fullName full name of the service provider
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * sets the abreviate name of the service provider
     *
     * @param abrevName abreviated name of the service provider
     */
    public void setAbrevName(String abrevName) {
        this.abrevName = abrevName;
    }

    /**
     * sets the postal address of the serive provider
     *
     * @param pAddress postal address
     */
    public void setPostalAddress(PostalAddress pAddress) {
        this.pAddress = pAddress;
    }

    /**
     * sets the TIN number of the service provider
     *
     * @param tinNumber TIN number of the service provider
     */
    public void setTinNumber(int tinNumber) {
        this.tinNumber = tinNumber;
    }

    /**
     * sets the phone number of the service provider
     *
     * @param phoneNumber Phonee number of the service provider
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * sets the mechanographic number of the service provider
     *
     * @param mechaNumber mechanographic number of the service provider
     */
    public void setMechaNumber(int mechaNumber) {
        this.mechaNumber = mechaNumber;
    }

    /**
     * sets the email of the Service Provider
     *
     * @param email email of the Service Provide
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * sets the password of the service provider
     *
     * @param pwd password of the service provider
     */
    public void setPWD(String pwd) {
        this.pwd = pwd;
    }

    /**
     * sets the evaluation of the service provider
     *
     * @param eva evaluation of the service provider
     */
    public void setEvaluation(Evaluation eva) {
        this.evaluation = eva;
    }

    /**
     * adds the category to the list of categories of the Service Provider
     *
     * @param cat Category to be added
     * @return Boolean relative to the success of the operation
     */
    public boolean addCategory(Category cat) {
        return this.spCategoryList.add(cat);
    }

    /**
     * returns the category list
     *
     * @return list of categories
     */
    public List<Category> getCategoryList() {
        return new ArrayList<>(this.spCategoryList);
    }

    /**
     * adds the Geographical Area of the service Provider
     *
     * @param area Geographical Area to be added
     * @return Boolean relative to the success of the operation
     */
    public boolean addGeographicalArea(GeographicalArea area) {
        this.spGeographicalArea = area;
        return true;
    }

    /**
     * adds rate list
     *
     * @param ratelist rate list of the service provider
     */
    public void setRateList(RateList ratelist) {
        this.rateList = ratelist;
    }

    /**
     * Validates and adds the evaluation to the service provider
     *
     * @param eva evaluation
     * @return boolean regarding the success of the operation
     */
    public boolean registerEvaluation(Evaluation eva) {
        if (validateEvaluation(eva)) {
            return addEvaluation(eva);
        } else {
            return false;
        }
    }

    /**
     * adds a evauation to the service provider
     *
     * @param eva evaluation
     * @return boolean regarding the success of the operation
     */
    public boolean addEvaluation(Evaluation eva) {
        this.evaluation = eva;
        return true;
    }

    /**
     * validates the evaluation
     *
     * @param eva evaluation
     * @return boolean regarding the success of the operation
     */
    public boolean validateEvaluation(Evaluation eva) {
        boolean ver = true;
        if (eva == null) {
            ver = false;
        }
        return ver;
    }

    /**
     * Verifies if a service provider has an email
     *
     * @param email email to be searched
     * @return boolean that indicates if the service provider has that email or
     * not
     */
    public boolean hasEmail(String email) {
        return email.compareTo(this.email) == 0;
    }

    /**
     * removes the time period of the service provider
     *
     * @param avail availability
     * @param pref time preference
     * @param dur duration
     */
    public void removeTimePeriod(Availability avail, TimePreference pref, int dur) {
        this.availabiityList.removeTimePeriod(avail, pref, dur);
    }

    /**
     * Compares two objects of ServiceProvider and verifies if they are equal
     *
     * @param o: other object
     * @return verification if the two objects are the same
     */
    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }
        // field comparison
        ServiceProvider obj = (ServiceProvider) o;
        return (Objects.equals(this.email, obj.email));

    }

    /**
     * returns the information of the service provider in the format of a string
     *
     * @return string with info
     */
    public String toString() {
        return String.format("Full name: %s%n Abbreviated name: %s%n"
                + "TIN Number: %d%n Phone number: %d%n E-mail: %s%n ", this.fullName, this.abrevName,
                this.tinNumber, this.phoneNumber, this.email);
    }

    /**
     * adds a postal address to the service provider
     *
     * @param postalAddress postal address
     */
    public void addPostalAddress(PostalAddress postalAddress) {
        this.pAddress = postalAddress;
    }

    public int compareToEval(ServiceProvider o) {
        double eval1 = this.getEvaluation().getMeanRating();
        double eval2 = o.getEvaluation().getMeanRating();
        if (eval1 > eval2) {
            return 1;
        } else if (eval1 == eval2) {
            return 0;
        }
        return (-1);
    }

    public int compareToDist(ServiceProvider o, double lat, double lon) {
        double dist1 = ExternalService1API.calculateDistance(this.getPostalAddress().getPostalCode().getLatitude(), this.getPostalAddress().getPostalCode().getLongitude(), lat, lon);
        double dist2 = ExternalService1API.calculateDistance(o.getPostalAddress().getPostalCode().getLatitude(), o.getPostalAddress().getPostalCode().getLongitude(), lat, lon);
        if (dist1 < dist2) {
            return 1;
        } else if (dist1 == dist2) {
            return 0;
        }
        return -1;
    }

    public int compareToName(ServiceProvider o) {
        String name1 = this.fullName;
        String name2 = o.fullName;
        if (name1.compareTo(name2) > 0) {
            return 1;
        }
        return 0;
    }
}
