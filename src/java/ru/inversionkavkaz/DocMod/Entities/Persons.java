/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.inversionkavkaz.DocMod.Entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DMITRY
 */
@Entity
@Table(name = "persons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persons.findAll", query = "SELECT p FROM Persons p"),
    @NamedQuery(name = "Persons.findByIdperson", query = "SELECT p FROM Persons p WHERE p.idperson = :idperson"),
    @NamedQuery(name = "Persons.findByFirstname", query = "SELECT p FROM Persons p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Persons.findByLastname", query = "SELECT p FROM Persons p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Persons.findByMiddlename", query = "SELECT p FROM Persons p WHERE p.middlename = :middlename"),
    @NamedQuery(name = "Persons.findBySex", query = "SELECT p FROM Persons p WHERE p.sex = :sex"),
    @NamedQuery(name = "Persons.findByCardDate", query = "SELECT p FROM Persons p WHERE p.cardDate = :cardDate"),
    @NamedQuery(name = "Persons.findByBornData", query = "SELECT p FROM Persons p WHERE p.bornData = :bornData"),
    @NamedQuery(name = "Persons.findByPolisser", query = "SELECT p FROM Persons p WHERE p.polisser = :polisser"),
    @NamedQuery(name = "Persons.findByPolisnum", query = "SELECT p FROM Persons p WHERE p.polisnum = :polisnum"),
    @NamedQuery(name = "Persons.findBySnils", query = "SELECT p FROM Persons p WHERE p.snils = :snils"),
    @NamedQuery(name = "Persons.findByMedInshur", query = "SELECT p FROM Persons p WHERE p.medInshur = :medInshur"),
    @NamedQuery(name = "Persons.findByBenefitCode", query = "SELECT p FROM Persons p WHERE p.benefitCode = :benefitCode"),
    @NamedQuery(name = "Persons.findByBenefitDocSer", query = "SELECT p FROM Persons p WHERE p.benefitDocSer = :benefitDocSer"),
    @NamedQuery(name = "Persons.findByBenefitDocNum", query = "SELECT p FROM Persons p WHERE p.benefitDocNum = :benefitDocNum"),
    @NamedQuery(name = "Persons.findByPrideState", query = "SELECT p FROM Persons p WHERE p.prideState = :prideState"),
    @NamedQuery(name = "Persons.findByEducation", query = "SELECT p FROM Persons p WHERE p.education = :education"),
    @NamedQuery(name = "Persons.findByBusiness", query = "SELECT p FROM Persons p WHERE p.business = :business"),
    @NamedQuery(name = "Persons.findByDisability", query = "SELECT p FROM Persons p WHERE p.disability = :disability"),
    @NamedQuery(name = "Persons.findByJob", query = "SELECT p FROM Persons p WHERE p.job = :job"),
    @NamedQuery(name = "Persons.findByChangeJob", query = "SELECT p FROM Persons p WHERE p.changeJob = :changeJob"),
    @NamedQuery(name = "Persons.findByChangeAdress", query = "SELECT p FROM Persons p WHERE p.changeAdress = :changeAdress"),
    @NamedQuery(name = "Persons.findByBloodGroup", query = "SELECT p FROM Persons p WHERE p.bloodGroup = :bloodGroup"),
    @NamedQuery(name = "Persons.findByCardNum", query = "SELECT p FROM Persons p WHERE p.cardNum = :cardNum"),
    @NamedQuery(name = "Persons.findByJobPosition", query = "SELECT p FROM Persons p WHERE p.jobPosition = :jobPosition"),
    @NamedQuery(name = "Persons.findByJobSubdivision", query = "SELECT p FROM Persons p WHERE p.jobSubdivision = :jobSubdivision"),
    @NamedQuery(name = "Persons.findByIcusnum", query = "SELECT p FROM Persons p WHERE p.icusnum = :icusnum"),
    @NamedQuery(name = "Persons.findBySelected", query = "SELECT p FROM Persons p WHERE p.selected = :selected"),
    @NamedQuery(name = "Persons.findByPassSer", query = "SELECT p FROM Persons p WHERE p.passSer = :passSer"),
    @NamedQuery(name = "Persons.findByPassNum", query = "SELECT p FROM Persons p WHERE p.passNum = :passNum"),
    @NamedQuery(name = "Persons.findByPassPlace", query = "SELECT p FROM Persons p WHERE p.passPlace = :passPlace"),
    @NamedQuery(name = "Persons.findByPassDate", query = "SELECT p FROM Persons p WHERE p.passDate = :passDate"),
    @NamedQuery(name = "Persons.findByPhone", query = "SELECT p FROM Persons p WHERE p.phone = :phone"),
    @NamedQuery(name = "Persons.findBySubId", query = "SELECT p FROM Persons p WHERE p.subId = :subId"),
    @NamedQuery(name = "Persons.findByProfId", query = "SELECT p FROM Persons p WHERE p.profId = :profId"),
    @NamedQuery(name = "Persons.findByStagStart", query = "SELECT p FROM Persons p WHERE p.stagStart = :stagStart"),
    @NamedQuery(name = "Persons.findByEmail", query = "SELECT p FROM Persons p WHERE p.email = :email"),
    @NamedQuery(name = "Persons.findBySmsphone", query = "SELECT p FROM Persons p WHERE p.smsphone = :smsphone")})
public class Persons implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persons")
    private Collection<PersonIllness> personIllnessCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId")
    private Collection<PersonJob> personJobCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persons")
    private Collection<PersonHazard> personHazardCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persons")
    private Collection<AllergyPerson> allergyPersonCollection;

    @Column(name = "dependent")
    private Boolean dependent;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idperson")
    private BigDecimal idperson;
    @Size(max = 50)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 50)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 50)
    @Column(name = "middlename")
    private String middlename;
    @Size(max = 10)
    @Column(name = "sex")
    private String sex;
    @Column(name = "card_date")
    @Temporal(TemporalType.DATE)
    private Date cardDate;
    @Column(name = "born_data")
    @Temporal(TemporalType.DATE)
    private Date bornData;
    @Size(max = 20)
    @Column(name = "polisser")
    private String polisser;
    @Size(max = 20)
    @Column(name = "polisnum")
    private String polisnum;
    @Size(max = 50)
    @Column(name = "snils")
    private String snils;
    @Size(max = 200)
    @Column(name = "med_inshur")
    private String medInshur;
    @Size(max = 3)
    @Column(name = "benefit_code")
    private String benefitCode;
    @Size(max = 10)
    @Column(name = "benefit_doc_ser")
    private String benefitDocSer;
    @Size(max = 15)
    @Column(name = "benefit_doc_num")
    private String benefitDocNum;
    @Size(max = 20)
    @Column(name = "pride_state")
    private String prideState;
    @Size(max = 50)
    @Column(name = "education")
    private String education;
    @Size(max = 100)
    @Column(name = "business")
    private String business;
    @Size(max = 200)
    @Column(name = "disability")
    private String disability;
    @Size(max = 200)
    @Column(name = "job")
    private String job;
    @Size(max = 200)
    @Column(name = "change_job")
    private String changeJob;
    @Size(max = 200)
    @Column(name = "change_adress")
    private String changeAdress;
    @Size(max = 10)
    @Column(name = "blood_group")
    private String bloodGroup;
    @Size(max = 10)
    @Column(name = "card_num")
    private String cardNum;
    @Size(max = 50)
    @Column(name = "job_position")
    private String jobPosition;
    @Size(max = 100)
    @Column(name = "job_subdivision")
    private String jobSubdivision;
    @Column(name = "icusnum")
    private BigInteger icusnum;
    @Column(name = "selected")
    private Integer selected;
    @Size(max = 6)
    @Column(name = "pass_ser")
    private String passSer;
    @Size(max = 10)
    @Column(name = "pass_num")
    private String passNum;
    @Size(max = 500)
    @Column(name = "pass_place")
    private String passPlace;
    @Column(name = "pass_date")
    @Temporal(TemporalType.DATE)
    private Date passDate;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Недопустимый формат номера телефона/факса (должен иметь формат xxx-xxx-xxxx)")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 200)
    @Column(name = "phone")
    private String phone;
    @Column(name = "sub_id")
    private Integer subId;
    @Column(name = "prof_id")
    private Integer profId;
    @Column(name = "stag_start")
    @Temporal(TemporalType.DATE)
    private Date stagStart;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 12)
    @Column(name = "smsphone")
    private String smsphone;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "persons")
    private Adress adress;
    

    public Persons() {
    }

    public Persons(BigDecimal idperson) {
        this.idperson = idperson;
    }

    public BigDecimal getIdperson() {
        return idperson;
    }

    public void setIdperson(BigDecimal idperson) {
        this.idperson = idperson;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCardDate() {
        return cardDate;
    }

    public void setCardDate(Date cardDate) {
        this.cardDate = cardDate;
    }

    public Date getBornData() {
        return bornData;
    }

    public void setBornData(Date bornData) {
        this.bornData = bornData;
    }

    public String getPolisser() {
        return polisser;
    }

    public void setPolisser(String polisser) {
        this.polisser = polisser;
    }

    public String getPolisnum() {
        return polisnum;
    }

    public void setPolisnum(String polisnum) {
        this.polisnum = polisnum;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public String getMedInshur() {
        return medInshur;
    }

    public void setMedInshur(String medInshur) {
        this.medInshur = medInshur;
    }

    public String getBenefitCode() {
        return benefitCode;
    }

    public void setBenefitCode(String benefitCode) {
        this.benefitCode = benefitCode;
    }

    public String getBenefitDocSer() {
        return benefitDocSer;
    }

    public void setBenefitDocSer(String benefitDocSer) {
        this.benefitDocSer = benefitDocSer;
    }

    public String getBenefitDocNum() {
        return benefitDocNum;
    }

    public void setBenefitDocNum(String benefitDocNum) {
        this.benefitDocNum = benefitDocNum;
    }

    public String getPrideState() {
        return prideState;
    }

    public void setPrideState(String prideState) {
        this.prideState = prideState;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getChangeJob() {
        return changeJob;
    }

    public void setChangeJob(String changeJob) {
        this.changeJob = changeJob;
    }

    public String getChangeAdress() {
        return changeAdress;
    }

    public void setChangeAdress(String changeAdress) {
        this.changeAdress = changeAdress;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getJobSubdivision() {
        return jobSubdivision;
    }

    public void setJobSubdivision(String jobSubdivision) {
        this.jobSubdivision = jobSubdivision;
    }

    public BigInteger getIcusnum() {
        return icusnum;
    }

    public void setIcusnum(BigInteger icusnum) {
        this.icusnum = icusnum;
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }

    public String getPassSer() {
        return passSer;
    }

    public void setPassSer(String passSer) {
        this.passSer = passSer;
    }

    public String getPassNum() {
        return passNum;
    }

    public void setPassNum(String passNum) {
        this.passNum = passNum;
    }

    public String getPassPlace() {
        return passPlace;
    }

    public void setPassPlace(String passPlace) {
        this.passPlace = passPlace;
    }

    public Date getPassDate() {
        return passDate;
    }

    public void setPassDate(Date passDate) {
        this.passDate = passDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public Integer getProfId() {
        return profId;
    }

    public void setProfId(Integer profId) {
        this.profId = profId;
    }

    public Date getStagStart() {
        return stagStart;
    }

    public void setStagStart(Date stagStart) {
        this.stagStart = stagStart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSmsphone() {
        return smsphone;
    }

    public void setSmsphone(String smsphone) {
        this.smsphone = smsphone;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperson != null ? idperson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persons)) {
            return false;
        }
        Persons other = (Persons) object;
        if ((this.idperson == null && other.idperson != null) || (this.idperson != null && !this.idperson.equals(other.idperson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ru.inversionkavkaz.DocMod.Entities.Persons[ idperson=" + idperson + " ]";
    }

    public Boolean getDependent() {
        return dependent;
    }

    public void setDependent(Boolean dependent) {
        this.dependent = dependent;
    }

    @XmlTransient
    public Collection<AllergyPerson> getAllergyPersonCollection() {
        return allergyPersonCollection;
    }

    public void setAllergyPersonCollection(Collection<AllergyPerson> allergyPersonCollection) {
        this.allergyPersonCollection = allergyPersonCollection;
    }

    @XmlTransient
    public Collection<PersonIllness> getPersonIllnessCollection() {
        return personIllnessCollection;
    }

    public void setPersonIllnessCollection(Collection<PersonIllness> personIllnessCollection) {
        this.personIllnessCollection = personIllnessCollection;
    }

    @XmlTransient
    public Collection<PersonJob> getPersonJobCollection() {
        return personJobCollection;
    }

    public void setPersonJobCollection(Collection<PersonJob> personJobCollection) {
        this.personJobCollection = personJobCollection;
    }

    @XmlTransient
    public Collection<PersonHazard> getPersonHazardCollection() {
        return personHazardCollection;
    }

    public void setPersonHazardCollection(Collection<PersonHazard> personHazardCollection) {
        this.personHazardCollection = personHazardCollection;
    }
    
}
