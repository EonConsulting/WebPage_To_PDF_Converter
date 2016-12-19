/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.unisa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author motale
 */
@Entity
@Table(name = "lms_plugins", catalog = "tsugi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LmsPlugins.findAll", query = "SELECT l FROM LmsPlugins l")
    , @NamedQuery(name = "LmsPlugins.findByPluginId", query = "SELECT l FROM LmsPlugins l WHERE l.pluginId = :pluginId")
    , @NamedQuery(name = "LmsPlugins.findByPluginPath", query = "SELECT l FROM LmsPlugins l WHERE l.pluginPath = :pluginPath")
    , @NamedQuery(name = "LmsPlugins.findByVersion", query = "SELECT l FROM LmsPlugins l WHERE l.version = :version")
    , @NamedQuery(name = "LmsPlugins.findByTitle", query = "SELECT l FROM LmsPlugins l WHERE l.title = :title")
    , @NamedQuery(name = "LmsPlugins.findByCreatedAt", query = "SELECT l FROM LmsPlugins l WHERE l.createdAt = :createdAt")
    , @NamedQuery(name = "LmsPlugins.findByUpdatedAt", query = "SELECT l FROM LmsPlugins l WHERE l.updatedAt = :updatedAt")})
public class LmsPlugins implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "plugin_id")
    private Integer pluginId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "plugin_path")
    private String pluginPath;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version")
    private long version;
    @Size(max = 2048)
    @Column(name = "title")
    private String title;
    @Lob
    @Size(max = 65535)
    @Column(name = "json")
    private String json;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public LmsPlugins() {
    }

    public LmsPlugins(Integer pluginId) {
        this.pluginId = pluginId;
    }

    public LmsPlugins(Integer pluginId, String pluginPath, long version, Date createdAt, Date updatedAt) {
        this.pluginId = pluginId;
        this.pluginPath = pluginPath;
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getPluginId() {
        return pluginId;
    }

    public void setPluginId(Integer pluginId) {
        this.pluginId = pluginId;
    }

    public String getPluginPath() {
        return pluginPath;
    }

    public void setPluginPath(String pluginPath) {
        this.pluginPath = pluginPath;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pluginId != null ? pluginId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LmsPlugins)) {
            return false;
        }
        LmsPlugins other = (LmsPlugins) object;
        if ((this.pluginId == null && other.pluginId != null) || (this.pluginId != null && !this.pluginId.equals(other.pluginId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.unisa.entity.LmsPlugins[ pluginId=" + pluginId + " ]";
    }
    
}
