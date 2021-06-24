package lapr.project.gpsd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {

    /**
     * Name of the candidate
     */
    private String name;
    /**
     * Tin of the candidate
     */
    private int tin;
    /**
     * Telephone of the candidate
     */
    private int tel;
    /**
     * Email of the candidate
     */
    private String email;
    /**
     * Postal Address of the candidate
     */
    private PostalAddress postAd;
    /**
     * Professional Habilitaion of the candidate
     */
    private List<ProfessionalHabilitation> lstProfHab = new ArrayList<>();
    /**
     * Academic Habilitaion of the candidate
     */
    private List<AcademicHabilitation> lstAcadHab = new ArrayList<>();
    /**
     * Supporting document of the candidate's habilitations
     */
    private List<SupportingDocument> lstDoc = new ArrayList<>();

    /**
     * List of Categories of the candidate
     */
    private List<Category> lstCat = new ArrayList<>();

    /**
     * Constructor of the Application
     *
     * @param name Name of the candidate
     * @param tin Tin of the candidate
     * @param tel Telephone of the candidate
     * @param email Email of the candidate
     * @param postAd Postal Address of the candidate
     */
    public Application(String name, int tin, int tel, String email, PostalAddress postAd) {
        this.name = name;
        this.tin = tin;
        this.tel = tel;
        this.email = email;
        this.postAd = postAd;
    }

    /**
     * Method that returns name of candidate
     *
     * @return name of candidate
     */
    public String getName() {
        return name;
    }

    /**
     * Method that returns tin of candidate
     *
     * @return tin of candidate
     */
    public int getTin() {
        return tin;
    }

    /**
     * Method that returns telephone of candidate
     *
     * @return name of candidate
     */
    public int getTel() {
        return tel;
    }

    /**
     * Method that returns email of candidate
     *
     * @return email of candidate
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method that returns postal address of candidate
     *
     * @return name of candidate
     */
    public PostalAddress getPostalAddress() {
        return postAd;
    }
/**
 * Method that returns list of categories of candidate
 * @return list of categories of candidate 
 */
    public List<Category> getCatList() {
        return new ArrayList<>(lstCat);
    }

    /**
     * Method that creates and returns a Postal Address
     *
     * @param address Address of the Postal Address
     * @param strPostalCode Postal Code of the Postal Address
     * @param local Location of the Postal Address
     * @return Postal Address instance
     */
    public static PostalAddress newPostalAddress(String address, PostalCode strPostalCode, String local) {
        return new PostalAddress(address, strPostalCode, local);
    }

    /**
     * Methods that adds one academic habilitation
     *
     * @param description Description of the Academic Habilitation
     * @return true if academic habilitaion was added and false if academic
     * habilitation wasn't added
     */
    public boolean addAcadHabilitation(String description) {
        AcademicHabilitation acHab = new AcademicHabilitation(description);
        if (validaAcadHabilitation(acHab)) {
            if (addAcadHabilitation(acHab)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that validates Academic Habilitation
     *
     * @param acHab Academic Habilitation that will be validated
     * @return true if Academic Habiliation is valid and false if Academic
     * Habilitation isn't valid
     */
    private boolean validaAcadHabilitation(AcademicHabilitation acHab) {
        boolean b = true;
        if (acHab.getDescription().isEmpty()) {
            b = false;
        }
        if (acHab.getDescription() == null) {
            b = false;
        }
        return b;
    }

    /**
     *
     * Methods that adds one academic habilitation
     *
     * @param acadHab Academic Habilitation
     * @return true if academic habilitaion was added and false if academic
     * habilitation wasn't added
     */
    private boolean addAcadHabilitation(AcademicHabilitation acadHab) {
        return this.lstAcadHab.add(acadHab);
    }

    /**
     * Methods that adds one Professionall habilitation
     *
     * @param designation designation of the Professional habilitation
     * @param degree degree of the Professional habilitation
     * @param classification classification of the Professional habilitation
     * @return true if Professional habilitation was added and false if
     * Professional habilitation wasn't added
     */
    public boolean addProfHabilitation(String designation, int degree, String classification) {
        ProfessionalHabilitation profHabli = new ProfessionalHabilitation(designation, degree, classification);
        if (validateProfHabilitation(profHabli)) {
            if (addProfHabilitation(profHabli)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that validates Professional Habilitation
     *
     * @param profHab Professional Habilitation that will be validated
     * @return true if Professional Habiliation is valid and false if
     * Professional Habilitation isn't valid
     */
    private boolean validateProfHabilitation(ProfessionalHabilitation profHab) {
        boolean b = true;
        if (profHab.getClassification().isEmpty()) {
            b = false;
        }
        if (profHab.getClassification() == null) {
            b = false;
        }
        if (profHab.getDesignation().isEmpty()) {
            b = false;
        }
        if (profHab.getDesignation() == null) {
            b = false;
        }
        if (profHab.getDegree() == 0) {
            b = false;
        }
        return b;
    }

    /**
     * Methods that adds one Professional habilitation
     *
     * @param profHab Professional Habilitation
     * @return true if Professional habilitation was added and false if
     * Professional habilitation wasn't added
     */
    private boolean addProfHabilitation(ProfessionalHabilitation profHab) {
        return this.lstProfHab.add(profHab);
    }

    /**
     * Method that adds Supporting document
     *
     * @param doc Supporting Document
     * @return true if Supporting Document was added and false if Supporting
     * Document wasn't added
     */
    public boolean addSupportingDoc(String doc) {
        SupportingDocument spDoc = new SupportingDocument(doc);
        if (validateSupportingDocument(spDoc)) {
            if (addSupportingDocument(spDoc)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that validates Supporting Document
     *
     * @param spDoc Supporting Document that will be validated
     * @return true if Supporting Document is valid and false if Supporting
     * Document isn't valid
     */
    private boolean validateSupportingDocument(SupportingDocument spDoc) {
        boolean b = true;
        if (spDoc.getDoc().isEmpty()) {
            b = false;
        }
        if (spDoc.getDoc() == null) {
            b = false;
        }
        return b;
    }

    /**
     * Method that adds Supporting document
     *
     * @param spDoc Supporting Document
     * @return true if Supporting Document was added and false if Supporting
     * Document wasn't added
     */
    private boolean addSupportingDocument(SupportingDocument spDoc) {
        return this.lstDoc.add(spDoc);
    }

    /**
     * Method that adds a Category
     *
     * @param cat Category that will be added
     * @return true if Category was added and false if Category wasn't added
     */
    public boolean addCategory(Category cat) {
        return this.lstCat.add(cat);
    }

    /**
     * Checks if this instance of Application has a TIN number
     *
     * @param otherTin TIN number to compare
     * @return boolean relative to the operation
     */
    public boolean hasTIN(int otherTin) {
        return this.tin == otherTin;
    }

    /**
     * Method that changes Postal address of the candidate
     *
     * @param pa Postal Address
     * @return true if Postal Address was changed and false if PostalAddress
     * wasn't changed
     */
    public boolean addPostAdress(PostalAddress pa) {
        this.postAd = pa;
        if (this.postAd == null) {
            return false;
        }
        return true;
    }

    /**
     * Comparates two objects of Application and verify if they are equal
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
        Application obj = (Application) o;
        return (Objects.equals(this.name, obj.name) && Objects.equals(this.email, obj.email) && Objects.equals(this.lstAcadHab, obj.lstAcadHab)
                && Objects.equals(this.lstCat, obj.lstCat) && (Objects.equals(this.lstDoc, obj.lstDoc)) && (Objects.equals(this.postAd, obj.postAd))
                && (Objects.equals(this.lstProfHab, obj.lstProfHab)) && (Objects.equals(this.tel, obj.tel)) && (Objects.equals(this.tin, obj.tin)));
    }

}
