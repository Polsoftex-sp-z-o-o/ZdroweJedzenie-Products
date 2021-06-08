package com.Polsoftex.Product.models;

        import org.hibernate.annotations.Type;

        import javax.persistence.*;
        import java.sql.Blob;
        import java.util.UUID;

@Entity
public class Image {

    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Lob
    @Column
    private byte[] image;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public byte[] getImage() { return image; }
    public void  setImage(byte[] image) { this.image = image; }

}
