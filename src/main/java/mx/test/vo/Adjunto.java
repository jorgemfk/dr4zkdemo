package mx.test.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;
import mx.dr.forms.dto.DRAttachMedia;

import org.zkoss.util.resource.Labels;

@Entity
@Table(name = "ml_cadjunto")
@Inheritance(strategy = InheritanceType.JOINED)
public class Adjunto implements java.io.Serializable, DRAttachMedia {

    private Long id;
    private String name;
    private String format;
    private String contentType;
    private Long iddocumento;

    public Adjunto() {
        super();
    }

    public Adjunto(Long id) {
        super();
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "tipo")
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Column(name = "extension")
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Column(name = "nombre")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(Long iddocumento) {
        this.iddocumento = iddocumento;
    }

    @Transient
    public String getUri() {
        return Labels.getLabel("parametro.adjuntos.folder") + getFileName();
    }

    @Transient
    public String getFileName() {
        return iddocumento + "." + format;
    }
}
