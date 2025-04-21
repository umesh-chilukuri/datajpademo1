package in.ashokit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTCTS_MASTER")
public class ContactsMasterEntity {

    @Id
    @Column(name = "Contact_Id")
    private Integer contactId;

    @Column(name = "Contact_Name")
    private String contactName;

    @Column(name = "Contact_Number")
    private Long contactNumber;

    // ======== Getters =========
    public Integer getContactId() {
        return contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    // ======== Setters =========
    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }
}
